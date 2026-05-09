package Advertise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JButton login,cancle;
    JTextField tfuser,tfpassword;

    login(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lbluser=new JLabel("UserName");
        lbluser.setBounds(40,20,100,20);
        add(lbluser);

         tfuser=new JTextField();
        tfuser.setBounds(150,20,150,20);
        add(tfuser);

        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(40,70,100,20);
        add(lblpassword);

         tfpassword=new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);

        login=new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setForeground(Color.white);
        login.setBackground(Color.black);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma",Font.BOLD,14));
        add(login);

        cancle=new JButton("Cancle");
        cancle.setBounds(180,140,120,30);
        cancle.setForeground(Color.white);
        cancle.setBackground(Color.black);
        cancle.addActionListener(this);
        cancle.setFont(new Font("Tahoma",Font.BOLD,14));
        add(cancle);

        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2=il.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);

        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==login){
            String username=tfuser.getText();
            String password=tfpassword.getText();

            String query="select *from login where username= '"+username+"'and password='"+password+ "'";

            try{
                conn c=new conn();
               ResultSet rs= c.s.executeQuery(query);
               if (rs.next()){
                   setVisible(false);
                   new Dashboard();
               }else {
                  JOptionPane.showMessageDialog(null,"Invalid PassWord");

               }
            }catch (Exception e){
                e.printStackTrace();
            }


        } else if (ae.getSource()==cancle) {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new login();
    }
}

