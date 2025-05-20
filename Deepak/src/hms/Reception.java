package hms;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(12,12,400,880);
        panel.setBackground(Color.white);
        int borderWidth = 3;
        panel.setBorder(new LineBorder(Color.darkGray, borderWidth));
        add(panel);

        ImageIcon i1 = new ImageIcon("res/icon/pic.jpg");
        Image image = i1.getImage().getScaledInstance(250,180,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(70,638,248,160);
        panel.add(label);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(424,12,1100,880);
        panel1.setBackground(Color.white);
        panel1.setBorder(new LineBorder(Color.darkGray, borderWidth));
        add(panel1);

        ImageIcon i11 = new ImageIcon("res/icon/logo.png");
        Image image1 = i11.getImage().getScaledInstance(560,360,Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label1 = new JLabel(i22);
        label1.setBounds(240,180,580,370);
        panel1.add(label1);

       


        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(40,30,320,36);
        btn1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn1.setBackground(new Color(246,215,118));
        panel.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();
            }
        });

        JButton btn2 = new JButton("Room");
        btn2.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn2.setBounds(40,82,320,36);;
        btn2.setBackground(new Color(246,215,118));
        panel.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton btn3 = new JButton("Department");
        btn3.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn3.setBounds(40,134,320,36);;
        btn3.setBackground(new Color(246,215,118));
        panel.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        JButton btn4 = new JButton("All Employee Info");
        btn4.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn4.setBounds(40,186,320,36);;
        btn4.setBackground(new Color(246,215,118));
        panel.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_info();
            }
        });

        JButton btn5 = new JButton("Patient Info");
        btn5.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn5.setBounds(40,238,320,36);;
        btn5.setBackground(new Color(246,215,118));
        panel.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ALL_Patient_Info();
            }
        });

        JButton btn6= new JButton("Patient Discharge");
        btn6.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn6.setBounds(40,290,320,36);;
        btn6.setBackground(new Color(246,215,118));
        panel.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patient_discharge();
            }
        });

        JButton btn7= new JButton("Update Patient Details");
        btn7.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn7.setBounds(40,342,320,36);;
        btn7.setBackground(new Color(246,215,118));
        panel.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new update_patient_details();
            }
        });

        JButton btn8= new JButton("Hospital Ambulance");
        btn8.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn8.setBounds(40,394,320,36);;
        btn8.setBackground(new Color(246,215,118));
        panel.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });

        JButton btn9= new JButton("Search Room");
        btn9.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn9.setBounds(40,446,320,36);;
        btn9.setBackground(new Color(246,215,118));
        panel.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
            }
        });

        JButton btn10= new JButton(" Book Appointment");
        btn10.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn10.setBounds(40,498,320,36);;
        btn10.setBackground(new Color(246,215,118));
        panel.add(btn10);

        JButton btn11= new JButton("Patient History");
        btn11.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn11.setBounds(40,550,320,36);;
        btn11.setBackground(new Color(246,215,118));
        panel.add(btn11);

        JButton btn12= new JButton("Logout");
        btn12.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn12.setBounds(40,602,320,36);;
        btn12.setBackground(new Color(246,215,118));
        panel.add(btn12);
        btn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

        setSize(1548,1080);
        getContentPane().setBackground(new Color(31, 118, 192));
        setLayout(null);
        setVisible(true);
        
    }

    public static void main(String[] args) {
        new Reception();
    }
}
