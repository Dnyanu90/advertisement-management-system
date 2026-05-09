package Advertise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class AdvertiseFee  extends JFrame implements ActionListener {
Choice adnumber;
JComboBox cbdesignname,cbsoftware,cbfee;
JLabel lbltotal,lbl_total;
JButton update,pay,back;


        AdvertiseFee(){
            setSize(900,500);
            setLocation(300,100);
            setLayout(null);

            getContentPane().setBackground(Color.white);


            ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/pic7.jpg"));
            Image i2=il.getImage().getScaledInstance(500,200,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image=new JLabel(i3);
            image.setBounds(400,75,500,200);
            add(image);

            JLabel Hsearch =new JLabel("Search Advertise No");
            Hsearch.setBounds(40,60,150,20);
            Hsearch.setFont(new Font("Tahoma",Font.BOLD,16));
            add(Hsearch);

            adnumber =new Choice();
            adnumber.setBounds(200,60,150,20);
            add(adnumber);

            try {

                conn c=new conn();
                ResultSet rs=c.s.executeQuery("Select *from Advertise");
                while (rs.next()){
                    adnumber.add(rs.getString("addno"));
                }

            }catch (Exception e){

                e.printStackTrace();

            }


            JLabel lblname=new JLabel("Name");
            lblname.setBounds(40,100,150,20);
            lblname.setFont(new Font("Tahoma",Font.BOLD,18));
            add(lblname);

            JLabel labelname=new JLabel();
            labelname.setBounds(200,100,150,20);
            labelname.setFont(new Font("Tahoma",Font.PLAIN,18));
            add(labelname);

            JLabel lblsize=new JLabel("Ad Size");
            lblsize.setBounds(40,140,150,20);
            lblsize.setFont(new Font("Tahoma",Font.BOLD,18));
            add(lblsize);

            JLabel labelsize=new JLabel();
            labelsize.setBounds(200,140,150,20);
            labelsize.setFont(new Font("Tahoma",Font.PLAIN,18));
            add(labelsize);

            try{
                conn c=new conn();
                String query="select *from Advertise where addno='"+adnumber.getSelectedItem()+"'";
                ResultSet rs=c.s.executeQuery(query);
                while (rs.next()){
                    labelname.setText(rs.getString("name"));
                    labelsize.setText(rs.getString("adsize"));

                }

            }catch (Exception e){
                e.printStackTrace();
            }

            adnumber.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent ie) {
                    try{
                        conn c=new conn();
                        String query="select *from Advertise where addno='"+adnumber.getSelectedItem()+"'";
                        ResultSet rs=c.s.executeQuery(query);
                        while (rs.next()){
                            labelname.setText(rs.getString("name"));
                            labelsize.setText(rs.getString("adsize"));


                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });

            JLabel lbleditor=new JLabel("Editor Name");
            lbleditor.setBounds(40,180,150,20);
            lbleditor.setFont(new Font("Tahoma",Font.BOLD,18));
            add(lbleditor);

            String editor[]={"Banker","Jethalal","Albert","Geni","Anney","Harry","Hector"};
            cbdesignname =new JComboBox(editor);
            cbdesignname.setBounds(200,180,150,20);
            cbdesignname.setBackground(Color.white);
            add(cbdesignname);

            JLabel lblsoftwares=new JLabel("Softwares");
            lblsoftwares.setBounds(40,220,150,20);
            lblsoftwares.setFont(new Font("Tahoma",Font.BOLD,18));
            add(lblsoftwares);

            String swname[]={"Photoshop","Canva","GIMP","Inkscape","CoralDraw","Figma","Adobe Express","AdobeIndesign"};
            cbsoftware =new JComboBox(swname);
            cbsoftware.setBounds(200,220,150,20);
            cbsoftware.setBackground(Color.white);
            add(cbsoftware);

           JLabel lbladdtype=new JLabel("AD Type");
           lbladdtype.setBounds(40,260,150,20);
           lbladdtype.setFont(new Font("Tahoma",Font.BOLD,18));
           add(lbladdtype);

           String fee[]={"LandScape"};
           cbfee=new JComboBox(fee);
           cbfee.setBounds(200,260,150,20);
           cbfee.setBackground(Color.WHITE);;
           add(cbfee);

            JLabel total=new JLabel("Total Payable");
            total.setBounds(40,300,150,20);
            total.setFont(new Font("Tahoma",Font.BOLD,18));
            add(total);

             lbltotal=new JLabel();
            lbltotal.setBounds(200,300,150,20);
            lbltotal.setFont(new Font("Tahoma",Font.PLAIN,18));
            add(lbltotal);

            update=new JButton("Update");
            update.setBounds(30,380,100,25);
            update.setForeground(Color.white);
            update.setBackground(Color.black);
            update.addActionListener(this);
            update.setFont(new Font("Tahoma",Font.BOLD,14));
            add(update);

            pay=new JButton("Pay Fee");
            pay.setBounds(150,380,100,25);
            pay.setForeground(Color.white);
            pay.setBackground(Color.black);
            pay.addActionListener(this);
            pay.setFont(new Font("Tahoma",Font.BOLD,14));
            add(pay);

            back=new JButton("Back");
            back.setBounds(270,380,100,25);
            back.setForeground(Color.white);
            back.setBackground(Color.black);
            back.addActionListener(this);
            back.setFont(new Font("Tahoma",Font.BOLD,14));
            add(back);


            setVisible(true);

        }

        public void actionPerformed(ActionEvent ae){
            if (ae.getSource()==update){
                String placerent=(String) cbdesignname.getSelectedItem();
                String software=(String) cbsoftware.getSelectedItem();

                try {
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery("select *from fee where'"+placerent+"'");
                    while (rs.next()){
                        lbltotal.setText(rs.getString(software));
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            } else if (ae.getSource()==pay) {

            } else if (ae.getSource()==back) {
                setVisible(false);
            }
        }

    public static void main(String[] args) {

        new AdvertiseFee();
    }
}
