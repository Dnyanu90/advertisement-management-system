package Advertise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class CustomerDetails extends JFrame implements ActionListener {

    Choice cCustomerid;
    JTable  table;
    JButton search,print,update,add,canle;

    CustomerDetails(){
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
            ResultSet rs=c.s.executeQuery("Select *from Customer");
            while (rs.next()){
                cCustomerid.add(rs.getString("customerid"));
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        table =new JTable();
        try {

            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select *from Customer");
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

        add=new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);

        update=new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);

        canle=new JButton("Cancle");
        canle.setBounds(420,70,80,20);
        canle.addActionListener(this);
        add(canle);




        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

        if (ae.getSource()==search){

            String query="Select *from Customer where customerid='"+ cCustomerid.getSelectedItem()+"'";
            try {
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource()==print){

            try{
                table.print();

            }catch (Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource()==add){
            setVisible(false);
            new Customer();

        }else if (ae.getSource()==update){
            setVisible(false);

        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new CustomerDetails();
    }
}
