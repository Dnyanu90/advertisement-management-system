package Advertise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class RemoveCustomerDetails extends JFrame implements ActionListener {

    Choice cCustomerid;
    JTable  table;
    JButton search,print,update,add,canle;

    RemoveCustomerDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel heading =new JLabel("Search CustomerID");
        heading.setBounds(20,20,150,20);
        add(heading);

        cCustomerid =new Choice();
        cCustomerid.setBounds(180,20,150,20);
        add(cCustomerid);

        try {

            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select *from removecustomer");
            while (rs.next()){
                cCustomerid.add(rs.getString("CustomerId"));
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        table =new JTable();
        try {

            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select *from removecustomer ");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){

            e.printStackTrace();

        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        canle=new JButton("Cancle");
        canle.setBounds(220,70,80,20);
        canle.addActionListener(this);
        add(canle);




        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {

            String query = "Select *from Customer where Removecustomer ='" + cCustomerid.getSelectedItem() + "'";
            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == print) {

            try {
                table.print();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new RemoveCustomerDetails();
    }
}

