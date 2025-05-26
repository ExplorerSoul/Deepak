package hms;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(171, 213, 255));
        add(panel);

        JTable table = new JTable();
        table.setBounds(5,80,680,320);
        table.setRowHeight(30);
        
        table.setBackground(new Color(171, 213, 255));
        table.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Department");
        label1.setBounds(110,24,125,22);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(431,24,150,22);
        label2.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label2);

        JButton b1 = new JButton("BACK");
        b1.setBounds(280,430,130,30);
        b1.setBackground(new Color(31, 118, 192));
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(640,120);
        setVisible(true);

    }

    public static void main(String[] args) {
         new Department();
    }
}
