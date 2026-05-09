package Advertise;

import javax.sql.rowset.spi.SyncResolver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class updatecustomer extends JFrame implements ActionListener {
    JTextField tfcontact,tflocation,tfemail;
    JLabel CusomerID,custID;
    Choice customerId;
    JButton submit,cancle;

    updatecustomer(){
        setSize(900,700);
        setLocation(350,50);


        setLayout(null);
        JLabel heading =new JLabel("Update Customer Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("sarif",Font.BOLD,30));
        add(heading);

        JLabel Hsearch =new JLabel("Search Customer ID");
        Hsearch.setBounds(50,100,200,20);
        Hsearch.setFont(new Font("sarif",Font.PLAIN,20));
        add(Hsearch);

        customerId =new Choice();
        customerId.setBounds(250,100,200,20);
        add(customerId);

        try {

            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select *from Customer");
            while (rs.next()){
                customerId.add(rs.getString("customerid"));
            }

        }catch (Exception e){

            e.printStackTrace();

        }


        JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("sarif",Font.BOLD,20));
        add(lblname);

        JLabel labelname=new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelname);

        JLabel lblsize=new JLabel("Ad Size");
        lblsize.setBounds(400,150,100,30);
        lblsize.setFont(new Font("sarif",Font.BOLD,20));
        add(lblsize);

        JLabel labelsize=new JLabel();
        labelsize.setBounds(530,150,150,30);
        labelsize.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelsize);

        CusomerID=new JLabel("Customer ID");
        CusomerID.setBounds(50,200,200,30);
        CusomerID.setFont(new Font("sarif",Font.BOLD,20));
        add(CusomerID);

        custID =new JLabel();
        custID.setBounds(200,200,200,30);
        custID.setFont(new Font("sarif",Font.BOLD,18));
        add(custID);




        JLabel lbldis=new JLabel("Date");
        lbldis.setBounds(400,200,200,30);
        lbldis.setFont(new Font("sarif",Font.BOLD,20));
        add(lbldis);

        JLabel dipsdate=new JLabel();
        dipsdate.setBounds(530,200,150,30);
        dipsdate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(dipsdate);



        JLabel lbllocation=new JLabel("Address");
        lbllocation.setBounds(50,250,100,30);
        lbllocation.setFont(new Font("sarif",Font.BOLD,20));
        add(lbllocation);

        tflocation=new JTextField();
        tflocation.setBounds(200,250,150,30);
        tflocation.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tflocation);

        JLabel lblcontact=new JLabel("Contact");
        lblcontact.setBounds(400,250,200,30);
        lblcontact.setFont(new Font("sarif",Font.BOLD,20));
        add(lblcontact);

        tfcontact=new JTextField();
        tfcontact.setBounds(530,250,150,30);
        tfcontact.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfcontact);

        JLabel lblemail=new JLabel("Email Id");
        lblemail.setBounds(50,300,100,30);
        lblemail.setFont(new Font("sarif",Font.BOLD,20));
        add(lblemail);

        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        tfemail.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfemail);

        JLabel lbldesign=new JLabel("Design");
        lbldesign.setBounds(400,300,200,30);
        lbldesign.setFont(new Font("sarif",Font.BOLD,20));
        add(lbldesign);

        JLabel design=new JLabel();
        design.setBounds(530,300,150,30);
        design.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(design);

        JLabel lbleditor=new JLabel("Editor Name");
        lbleditor.setBounds(50,350,200,30);
        lbleditor.setFont(new Font("sarif",Font.BOLD,20));
        add(lbleditor);

        JLabel editor=new JLabel();
        editor.setBounds(200,350,200,30);
        editor.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(editor);



        JLabel lblsoftwares=new JLabel("Softwares");
        lblsoftwares.setBounds(400,350,200,30);
        lblsoftwares.setFont(new Font("sarif",Font.BOLD,20));
        add(lblsoftwares);

        JLabel software=new JLabel();
        software.setBounds(530,350,150,30);
        software.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(software);

        try{
            conn c=new conn();
            String query="select *from Customer where customerid='"+customerId.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while (rs.next()){
                labelname.setText(rs.getString("name"));
                labelsize.setText(rs.getString("surname"));
                custID.setText(rs.getString("customerid"));
                dipsdate.setText(rs.getString("date"));
                tflocation.setText(rs.getString("address"));
                tfemail.setText(rs.getString("email"));
                tfcontact.setText(rs.getString("contact"));
                design.setText(rs.getString("design"));
                editor.setText(rs.getString("editorname"));
                software.setText(rs.getString("softwar"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        customerId.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie) {
                try{
                    conn c=new conn();
                    String query="select *from Customer where customerid='"+customerId.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    while (rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelsize.setText(rs.getString("surname"));
                        custID.setText(rs.getString("customerid"));
                        dipsdate.setText(rs.getString("date"));
                        tflocation.setText(rs.getString("address"));
                        tfemail.setText(rs.getString("email"));
                        tfcontact.setText(rs.getString("contact"));
                        design.setText(rs.getString("design"));
                        editor.setText(rs.getString("editorname"));
                        software.setText(rs.getString("softwar"));

                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });



        submit=new JButton("Update");
        submit.setBounds(250,450,120,30);
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,14));
        add(submit);

        cancle=new JButton("Cancle");
        cancle.setBounds(500,450,120,30);
        cancle.setForeground(Color.white);
        cancle.setBackground(Color.black);
        cancle.addActionListener(this);
        cancle.setFont(new Font("Tahoma",Font.BOLD,14));
        add(cancle);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){

            String customerid=CusomerID.getText();
            String  contact=tfcontact.getText();
            String email =tfemail.getText();
            String address=tflocation.getText();

            try{
                String query="update Customer set contact='"+contact+"',email=+'"+email+"',address='"+address+"' where customerid='"+customerid+"'";
                conn con=new conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Customer details Update Succefully");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();

            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new updatecustomer();
    }
}
