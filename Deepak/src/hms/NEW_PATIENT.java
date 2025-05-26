package hms;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class New_Patient extends JFrame implements ActionListener {
    @SuppressWarnings("rawtypes")
    JComboBox comboBox;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposite;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1 ,b2;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    New_Patient(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(Color.white);
        int borderWidth = 3;
        panel.setBorder(new LineBorder(new Color(31, 118, 192), borderWidth));
        panel.setLayout(null);
        add(panel);

        // ImageIcon imageIcon = new ImageIcon(getClass().getResource("/res/icon/patient.png"));
        // Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        // ImageIcon imageIcon1 = new ImageIcon(image);
        // JLabel label = new JLabel(imageIcon1);
        // label.setBounds(550,150,200,200);
        // panel.add(label);


        JLabel labelName = new JLabel("ADD NEW PATIENT");
        labelName.setBounds(140,12,260,53);
        labelName.setForeground(new Color(31, 118, 192));
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelName);

        JLabel labelID = new JLabel("Id :");
        labelID.setBounds(35,80,200,20);
        labelID.setFont(new Font("Tahoma",Font.BOLD,16));
        labelID.setForeground(Color.black);
        panel.add(labelID);

        comboBox = new JComboBox(new String[] {"Aadhar Card","Voter Id","Driving License"});
        comboBox.setBounds(271,80,200,20);
        // comboBox.setBackground(Color.white);
        comboBox.setForeground(Color.black);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35,119,204,20);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,16));
        labelNumber.setForeground(Color.black);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,119,200,20);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name :");
        labelName1.setBounds(35,163,204,20);
        labelName1.setFont(new Font("Tahoma",Font.BOLD,16));
        labelName1.setForeground(Color.black);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271,163,200,20);
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35,207,204,20);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,16));
        labelGender.setForeground(Color.black);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.black);
        r1.setBackground(Color.white);
        r1.setBounds(271,207,80,15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.black);
        r2.setBackground(Color.white);
        r2.setBounds(350,207,80,15);
        panel.add(r2);

        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(35,251,204,20);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,16));
        labelDisease.setForeground(Color.black);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271,251,200,20);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(35,298,204,20);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,16));
        labelRoom.setForeground(Color.black);
        panel.add(labelRoom);

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while (resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        c1.setBounds(271,298,200,20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.WHITE);
        // c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        JLabel labelDate = new JLabel("Time :");
        labelDate.setBounds(35,344,204,20);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,16));
        labelDate.setForeground(Color.black);
        panel.add(labelDate);

        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271,344,248,20);
        date.setForeground(Color.black);
        date.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(date);

        JLabel labelDeposite = new JLabel("Deposite :");
        labelDeposite.setBounds(35,391,200,20);
        labelDeposite.setFont(new Font("Tahoma",Font.BOLD,16));
        labelDeposite.setForeground(Color.black);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271,391,200,20);
        panel.add(textFieldDeposite);

        b1 = new JButton("ADD");
        b1.setBounds(100,460,120,30);
        b1.setFont(new Font("Tahoma", Font.BOLD, 16));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(31, 118, 192));
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(260,460,120,30);
        b2.setFont(new Font("Tahoma", Font.BOLD, 16));
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(31, 118, 192));
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(520,120);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            conn c = new conn();
            String radioBTN = null;
            if (r1.isSelected()){
                radioBTN = "Male";
            }else if (r2.isSelected()){
                radioBTN = "Female";
            }
            
            String s1 = (String)comboBox.getSelectedItem();
            String s2 =  textFieldNumber.getText();
            String s3 =  textName.getText();
            String s4 =  radioBTN;
            String s5 =  textFieldDisease.getText();
            String s6 =  c1.getSelectedItem();
            String s7 =  date.getText();
            String s8 = textFieldDeposite.getText();

            try {

                 // Check if the selected room is occupied
                String checkRoomQuery = "SELECT Availability FROM Room WHERE room_no = '" + s6 + "'";
                ResultSet rs = c.statement.executeQuery(checkRoomQuery);
                if (rs.next()) {
                    String availability = rs.getString("Availability");
                    if ("Occupied".equals(availability)) {
                        JOptionPane.showMessageDialog(null, "Room is already occupied. Please select another room.");
                        return; // Exit the method to prevent further processing
                    }
                }

                String q ="insert into patient_info values ('"+s1+"', '"+s2+"','"+s3+"','"+s4+"', '"+s5+"', '"+s6+"', '"+s7+"', '"+s8+"')";
                String q1 = "update Room set Availability = 'Occupied' where room_no = "+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);

            }catch (Exception E) {
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new New_Patient();
    }

}
