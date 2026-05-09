package Advertise;

import javax.swing.*;
import java.awt.*;
import  java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{

    JMenuItem ex,notepad,calc;
    Dashboard(){
        setSize(1570,850);

        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/advertise.jpg"));
        Image i2=il.getImage().getScaledInstance(1530,790,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);

        JMenuBar mb=new JMenuBar();

        //new Information
        JMenu newInfo= new JMenu("New Information");
        newInfo.setForeground(Color.BLUE);
        mb.add(newInfo);



        JMenuItem advertiseInfo=new JMenuItem("New Advertise Information");
        advertiseInfo.setBackground(Color.WHITE);
        advertiseInfo.addActionListener(this);
        newInfo.add(advertiseInfo);

        JMenuItem customerInfo=new JMenuItem("New Customer Information");
        customerInfo.setBackground(Color.WHITE);
        customerInfo.addActionListener(this);
        newInfo.add(customerInfo);

        //Details
        JMenu details= new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);



        JMenuItem facultydetils=new JMenuItem("Advertise Details");
        facultydetils.setBackground(Color.WHITE);
        facultydetils.addActionListener(this);
        details.add(facultydetils);

        JMenuItem customerdetail=new JMenuItem("Customer Details");
        customerdetail.setBackground(Color.WHITE);
        customerdetail.addActionListener(this);
        details.add(customerdetail);

        //leave
        JMenu applyCancle= new JMenu("Apply Cancel");
        applyCancle.setForeground(Color.blue);
        mb.add(applyCancle);



        JMenuItem Deleteadvertise=new JMenuItem("Delete Advertise");
        Deleteadvertise.setBackground(Color.WHITE);
        Deleteadvertise.addActionListener(this);

        applyCancle.add(Deleteadvertise);

        JMenuItem removecustomer=new JMenuItem(" Remove Customer");
        removecustomer.setBackground(Color.WHITE);
        removecustomer.addActionListener(this);
        applyCancle.add(removecustomer);

        //Cancle Details
        JMenu cancledetail= new JMenu("Cancel Details" );
        cancledetail.setForeground(Color.RED);
        mb.add(cancledetail);



        JMenuItem deladvertisedetails=new JMenuItem("Advertise Delete Details");
        deladvertisedetails.setBackground(Color.WHITE);
        deladvertisedetails.addActionListener(this);
        cancledetail.add(deladvertisedetails);

        JMenuItem CustomerDeletedetails=new JMenuItem("Customer Delete Details");
        CustomerDeletedetails.setBackground(Color.WHITE);
        CustomerDeletedetails.addActionListener(this);
        cancledetail.add(CustomerDeletedetails);

        // UpdateInfo
        JMenu updateinfo= new JMenu(" Update Information");
        updateinfo.setForeground(Color.BLUE);
        mb.add(updateinfo);



        JMenuItem facultyupdate=new JMenuItem("Advertise Update Details");
        facultyupdate.setBackground(Color.WHITE);
        facultyupdate.addActionListener(this);
        updateinfo.add(facultyupdate);

        JMenuItem studentupdate=new JMenuItem("Customer Update Details");
        studentupdate.setBackground(Color.WHITE);
        studentupdate.addActionListener(this);
        updateinfo.add(studentupdate);

        // UpdateInfo
        JMenu feedetail= new JMenu("Fee Details");
        feedetail.setForeground(Color.RED);
        mb.add(feedetail);



        JMenuItem feestructure=new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);

        feedetail.add(feestructure);

        JMenuItem feeform=new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feedetail.add(feeform);

        // Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility);


        notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        calc = new JMenuItem("Calc");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);

        // Exits
        JMenu exit= new JMenu("Exits");
        exit.setForeground(Color.RED);
        mb.add(exit);



        ex=new JMenuItem("Exits");
        ex.addActionListener(this);
        ex.setBackground(Color.WHITE);
        exit.add(ex);



        setJMenuBar(mb);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg=ae.getActionCommand();
        if (msg.equals("Exits")) {
            setVisible(false);

        } else if (msg.equals("Calc")) {
            try {
                Runtime.getRuntime().exec("calc.exe");

            }catch (Exception e){

            }
        }else if (msg.equals("Notepad")) {

            try {
                Runtime.getRuntime().exec("notepad.exe");

            }catch (Exception e){

            }
        }else if (msg.equals("New Customer Information")){
            new Customer();

        }else if(msg.equals("New Advertise Information")){
            new AddAdvertise();

        }else if (msg.equals("Advertise Details")) {
            new AdvertiseDetails();

        }else  if (msg.equals("Customer Details")){
            new CustomerDetails();

        }else if (msg.equals("Delete Advertise")){
            new cancleAdvertise();
        } else if (msg.equals(" Remove Customer")) {
            new RemoveCustomer();
        }else if (msg.equals("Advertise Delete Details")) {
            new RemoveAddDetails();
        }else if (msg.equals("Customer Delete Details")) {
            new RemoveCustomerDetails();
        } else if (msg.equals("Advertise Update Details")) {
            new UpdateAdvertise();
        }
        else if (msg.equals("Customer Update Details")) {
            new updatecustomer();
        }else if (msg.equals("Fee Structure")) {
            new FeeStructure();
        }else if(msg.equals("Student Fee Form")) {
            new AdvertiseFee();
        }
    }


    public static void main(String[] args) {

        new Dashboard();
    }
}

