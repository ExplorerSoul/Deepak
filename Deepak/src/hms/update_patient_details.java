package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {

    update_patient_details(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,640,490);
        panel.setBackground(Color.white);
        panel.setLayout(null);
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setBounds(5,5,640,50);
        panel1.setBackground(new Color(31, 118, 192));
        panel1.setLayout(null);
        add(panel1);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(200,30,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(new Color(31, 118, 192));
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(96,109,104,20);
        label2.setFont(new Font("Tahoma",Font.PLAIN,18));
        label2.setForeground(Color.black);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(382,109,146,22);
        panel.add(choice);

        try {
            conn c= new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(96,159,146,20);
        label3.setFont(new Font("Tahoma",Font.PLAIN,18));
        label3.setForeground(Color.black);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(382,159,146,22);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time  :");
        label4.setBounds(96,209,104,20);
        label4.setFont(new Font("Tahoma",Font.PLAIN,18));
        label4.setForeground(Color.black);
        panel.add(label4);

        JTextField textFieldINTIme = new JTextField();
        textFieldINTIme.setBounds(382,209,146,22);
        panel.add(textFieldINTIme);

        JLabel label5 = new JLabel("Amount Paid (Rs) :");
        label5.setBounds(96,259,154,20);
        label5.setFont(new Font("Tahoma",Font.PLAIN,18));
        label5.setForeground(Color.black);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(382,259,146,22);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount (Rs) :");
        label6.setBounds(96,309,190,22);
        label6.setFont(new Font("Tahoma",Font.PLAIN,18));
        label6.setForeground(Color.black);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(382,309,146,22);
        panel.add(textFieldPending);

        JButton check = new JButton("CHECK");
        check.setBounds(391,404,92,26);
        check.setBackground(new Color(31, 118, 192));
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info where Name = '"+id+"'";
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()){
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldINTIme.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select* from Room where room_no = '"+textFieldR.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+amountPaid);
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setBounds(146,404,92,26);
        update.setBackground(new Color(31, 118, 192));
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldINTIme.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("update patient_info set Room_Number = '"+room+"', Time = '"+time+"', Deposite = '"+amount+"' where Name = '"+q+"'" );
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(268,404,92,26);
        back.setBackground(new Color(31, 118, 192));
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(650,500);
        setLayout(null);
        setLocation(640,120);
        setVisible(true);

    }
    public static void main(String[] args) {
        new update_patient_details();
    }
}
