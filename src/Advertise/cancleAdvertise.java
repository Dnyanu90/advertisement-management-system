package Advertise;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class cancleAdvertise extends JFrame implements ActionListener {
    Choice addNumber,ctime;
    JDateChooser dcdate;
    JTextField tftime;
    JButton submit,cancle;

    cancleAdvertise(){
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading =new JLabel("Cancle Advertise");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tohoma",Font.BOLD,20));
        add(heading);

        JLabel lblAddno =new JLabel("Cancle Advertise");
        lblAddno.setBounds(60,100,150,30);
        lblAddno.setFont(new Font("Tohoma",Font.PLAIN,18));
        add(lblAddno);

        addNumber =new Choice();
        addNumber.setBounds(60,130,140,20);
        add(addNumber);

        try {

            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select *from Advertise");
            while (rs.next()){
                addNumber.add(rs.getString("addno"));
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        JLabel lblDate=new JLabel("Date");
        lblDate.setBounds(60,180,200,20);
        lblDate.setFont(new Font("Tohoma",Font.PLAIN,18));
        add(lblDate);

        dcdate =new JDateChooser();
        dcdate.setBounds(60,210,180,30);
        add(dcdate);

        JLabel lbltime =new JLabel("Time");
        lbltime.setBounds(60,260,200,30);
        lbltime.setFont(new Font("Tohoma",Font.PLAIN,18));
        add(lbltime);

        tftime=new JTextField();
        tftime.setBounds(60,290,200,30);
        tftime.setFont(new Font("Tohoma",Font.PLAIN,16));
        add(tftime);

        submit=new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,14));
        add(submit);

        cancle=new JButton("Cancle");
        cancle.setBounds(200,350,100,25);
        cancle.setForeground(Color.white);
        cancle.setBackground(Color.black);
        cancle.addActionListener(this);
        cancle.setFont(new Font("Tahoma",Font.BOLD,14));
        add(cancle);


        setVisible(true);

    }
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){

            String addno=addNumber.getSelectedItem();
            String date= ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String time =tftime.getText();

            String query="Insert into deleteAdvertise values('"+ addno+"','"+ date+"','"+time+"')";

            try{
                conn c=new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Advertise Deleted ");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {


        new cancleAdvertise();
    }
}

