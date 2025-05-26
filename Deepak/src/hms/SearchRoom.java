package hms;

import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table;

    SearchRoom() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 590);
        panel.setBackground(new Color(171, 213, 255));
        panel.setLayout(null);
        add(panel);

        JLabel For = new JLabel("Search For Room");
        For.setBounds(250, 11, 186, 31);
        For.setForeground(new Color(31, 118, 192));
        For.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(For);

        JLabel status = new JLabel("Status :");
        status.setBounds(230, 70, 84, 22);
        status.setForeground(Color.black);
        status.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(320, 70, 120, 22);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0, 146, 700, 320);
        table.setRowHeight(24);
        table.setBackground(new Color(171, 213, 255));
        table.setFont(new Font("Tahoma",Font.BOLD,16));
        table.setForeground(Color.black);
        panel.add(table);

        loadRoomData();

        JLabel Roomno = new JLabel("Room Number");
        Roomno.setBounds(23, 120, 150, 20);
        Roomno.setForeground(Color.white);
        Roomno.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(Roomno);

        JLabel available = new JLabel("Availability");
        available.setBounds(200, 120, 150, 20);
        available.setForeground(Color.white);
        available.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(available);

        JLabel price = new JLabel("Price");
        price.setBounds(416, 120, 150, 20);
        price.setForeground(Color.white);
        price.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(price);

        JLabel Bed = new JLabel("Bed Type");
        Bed.setBounds(560, 120, 150, 20);
        Bed.setForeground(Color.white);
        Bed.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(Bed);

        JButton Search = new JButton("Search");
        Search.setBounds(200, 520, 120, 25);
        Search.setBackground(new Color(31, 118, 192));
        Search.setFont(new Font("Tahoma", Font.BOLD, 16));
        Search.setForeground(Color.white);
        
       // Add action listener for search button
       Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availability = '" + choice.getSelectedItem() + "'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
       });
       
       panel.add(Search);

       JButton Back = new JButton("Back");
       Back.setBounds(380,520,120,25);
       Back.setBackground(new Color(31, 118, 192));
       Back.setFont(new Font("Tahoma", Font.BOLD, 16));
       Back.setForeground(Color.white);
       panel.add(Back);

       Back.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);
           }
       });

       setUndecorated(true);
       setSize(700,600);
       setLayout(null);
       setLocation(620,120);
       setVisible(true);
    }

    // Method to load room data into the table
    private void loadRoomData() {
      try {
          conn c = new conn();
          String q = "select * from Room";
          ResultSet resultSet = c.statement.executeQuery(q);
          table.setModel(DbUtils.resultSetToTableModel(resultSet));
      } catch (Exception e) {
          e.printStackTrace();
      }
    }

    // Method to check if a room is occupied
    private boolean isRoomOccupied(int roomNumber) {
      try {
          conn c = new conn();
          String query = "SELECT Availability FROM Room WHERE RoomNumber = " + roomNumber;
          ResultSet rs = c.statement.executeQuery(query);

          if (rs.next()) {
              return rs.getString("Availability").equalsIgnoreCase("Occupied");
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return false;
    }

    // Method to add a patient (example)
    public void addPatient(int roomNumber) {
      if (isRoomOccupied(roomNumber)) {
          JOptionPane.showMessageDialog(this,
                  "Cannot add patient. The room is currently occupied.",
                  "Error",
                  JOptionPane.ERROR_MESSAGE);
      } else {
          // Code to add the patient
      }
    }

    public static void main(String[] args) {
      new SearchRoom();
    }
}
