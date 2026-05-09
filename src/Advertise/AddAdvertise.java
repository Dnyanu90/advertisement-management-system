package Advertise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class AddAdvertise extends JFrame implements ActionListener {
    JTextField tfname,tfsize,tfcontact,tflocation,tfemail,tfdesign;
    JLabel lbladdnumber;
    JDateChooser dateChooser;
    Random ran=new Random();
    JComboBox cbdesignname,cbsoftware;
    long first4= Math.abs(ran.nextLong() %90l)+10l;
    JButton submit,cancle;

    AddAdvertise(){
        setSize(900,700);
        setLocation(350,50);


        setLayout(null);
        JLabel heading =new JLabel("New Advertise Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("sarif",Font.BOLD,30));
        add(heading);


        JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("sarif",Font.BOLD,20));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel lblsize=new JLabel("Ad Size");
        lblsize.setBounds(400,150,100,30);
        lblsize.setFont(new Font("sarif",Font.BOLD,20));
        add(lblsize);

        tfsize=new JTextField();
        tfsize.setBounds(500,150,150,30);
        add(tfsize);

        JLabel lbladdno=new JLabel("Advertise N0");
        lbladdno.setBounds(50,200,200,30);
        lbladdno.setFont(new Font("sarif",Font.BOLD,20));
        add(lbladdno);

        lbladdnumber=new JLabel("0910"+first4);
        lbladdnumber.setBounds(200,200,200,30);
        lbladdnumber.setFont(new Font("sarif",Font.BOLD,20));
        add(lbladdnumber);

        JLabel lbldis=new JLabel("Disp Date");
        lbldis.setBounds(400,200,200,30);
        lbldis.setFont(new Font("sarif",Font.BOLD,20));
        add(lbldis);

        dateChooser =new JDateChooser();
        dateChooser.setBounds(500,200,170,30);
        add(dateChooser);

        JLabel lbllocation=new JLabel("Location");
        lbllocation.setBounds(50,250,100,30);
        lbllocation.setFont(new Font("sarif",Font.BOLD,20));
        add(lbllocation);

        tflocation=new JTextField();
        tflocation.setBounds(200,250,150,30);
        add(tflocation);

        JLabel lblcontact=new JLabel("Contact");
        lblcontact.setBounds(400,250,200,30);
        lblcontact.setFont(new Font("sarif",Font.BOLD,20));
        add(lblcontact);

        tfcontact=new JTextField();
        tfcontact.setBounds(500,250,150,30);
        add(tfcontact);

        JLabel lblemail=new JLabel("Email Id");
        lblemail.setBounds(50,300,100,30);
        lblemail.setFont(new Font("sarif",Font.BOLD,20));
        add(lblemail);

        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel lbldesign=new JLabel("Design");
        lbldesign.setBounds(400,300,200,30);
        lbldesign.setFont(new Font("sarif",Font.BOLD,20));
        add(lbldesign);

        tfdesign=new JTextField();
        tfdesign.setBounds(500,300,150,30);
        add(tfdesign);

        JLabel lbleditor=new JLabel("Editor Name");
        lbleditor.setBounds(50,350,200,30);
        lbleditor.setFont(new Font("sarif",Font.BOLD,20));
        add(lbleditor);

        String editor[]={"Banker","Jethalal","Albert","Geni","Anney","Harry","Hector"};
        cbdesignname =new JComboBox(editor);
        cbdesignname.setBounds(200,350,150,30);
        cbdesignname.setBackground(Color.white);
        add(cbdesignname);

        JLabel lblsoftwares=new JLabel("Softwares");
        lblsoftwares.setBounds(400,350,200,30);
        lblsoftwares.setFont(new Font("sarif",Font.BOLD,20));
        add(lblsoftwares);

        String swname[]={"Photoshop","Canva","GIMP","Inkscape","CoralDraw","Figma","Adobe Express","AdobeIndesign"};
        cbsoftware =new JComboBox(swname);
        cbsoftware.setBounds(500,350,150,30);
        cbsoftware.setBackground(Color.white);
        add(cbsoftware);

        submit=new JButton("Submit");
        submit.setBounds(250,500,120,30);
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,14));
        add(submit);

        cancle=new JButton("Cancle");
        cancle.setBounds(500,500,120,30);
        cancle.setForeground(Color.white);
        cancle.setBackground(Color.black);
        cancle.addActionListener(this);
        cancle.setFont(new Font("Tahoma",Font.BOLD,14));
        add(cancle);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String name=tfname.getText();
            String adsize =tfsize.getText();
            String addno=lbladdnumber.getText();
            String dispdate =((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
            String location=tflocation.getText();
            String  contact=tfcontact.getText();
            String email =tfemail.getText();
            String design =tfdesign.getText();
            String editorname=(String) cbdesignname.getSelectedItem();
            String software=(String) cbsoftware.getSelectedItem();
            try {
                String query="insert into advertise values('"+name+"','"+adsize+"','"+addno+"','"+dispdate+"','"+location+"','"+contact+"','"+email+"','"+design+"','"+editorname+"','"+software+"')";
                conn con=new conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Advertise Detail Inserted Sucessful" );
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }


        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddAdvertise();

    }
}
