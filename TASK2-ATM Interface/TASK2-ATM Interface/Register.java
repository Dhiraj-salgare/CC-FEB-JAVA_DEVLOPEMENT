//program for register 

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Register extends JFrame implements ActionListener
{
    JFrame r;
    JLabel g1,g2,g3,g4,g5;
    JTextField t1,t3,t4;
    JPasswordField t2;
    JButton p1,p2;
    Register()
    {
        //Frames
        r=new JFrame("Register");
        r.getContentPane().setBackground(Color.lightGray);
        //labels
        g1 =new JLabel("REGISTER");
        g1.setFont(new Font("Times New Roman",Font.BOLD,30));
        g1.setBounds(270,50,200,100);
        g1.setHorizontalAlignment(JLabel.CENTER);

        g2=new JLabel("USERNAME:");
        g2.setFont(new Font("Monospace",Font.BOLD,22));
        g2.setBounds(50,150,200,50);

        g3=new JLabel("CARD NO:");
        g3.setFont(new Font("Monospace",Font.BOLD,22));
        g3.setBounds(50,250,200,50);

        g4=new JLabel("SET PIN:");
        g4.setFont(new Font("Monospace",Font.BOLD,22));
        g4.setBounds(50,350,200,50);

        g5=new JLabel("BALANCE:");
        g5.setFont(new Font("Monospace",Font.BOLD,22));
        g5.setBounds(50,450,200,50);

        //textfield and password
        t1=new JTextField();
        t1.setBounds(50,210,600,40);

        t3=new JTextField();
        t3.setBounds(50,300,600,40);

        t2=new JPasswordField();
        t2.setBounds(50,400,600,40);

        t4=new JTextField();
        t4.setBounds(50,500,600,40);


        //buttons

        p1=new JButton("SUBMIT");
        p1.setFont(new Font("times New Roman",Font.BOLD,22));
        p1.setBounds(50,600,150,50);

        p2=new JButton("CANCEL");
        p2.setFont(new Font("times New Roman",Font.BOLD,22));
        p2.setBounds(450,600,150,50);
       p1.addActionListener(this);
       p2.addActionListener(this);

        //add
        r.add(g1);
        r.add(g2);
        r.add(g3);
        r.add(g4);
        r.add(g5);
        r.add(t1);
        r.add(t2);
        r.add(t3);
        r.add(t4);

        r.add(p1);
        r.add(p2);

        r.setSize(800,800);
        r.setLayout(null);
        r.setVisible(true);




    }

    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource()==p1)
        {
        String us=t1.getText();
        String pwd=t3.getText();
        String npwd=String.valueOf(t2.getPassword());
        int b=Integer.parseInt(t4.getText());

        try{
            connection aa=new connection();
            
            String f="INSERT INTO user values('"+pwd+"','"+us+"','"+npwd+"','"+b+"')";
            aa.stm.executeUpdate(f);
            JFrame xx=new JFrame("register");
            JLabel bc=new JLabel();
            bc.setText("congrates your registration is sucessfully completed");
            bc.setFont(new Font("Monospace",Font.BOLD,18));
            bc.setBounds(50,150,700,50);

            //buttons
            JButton pp1=new JButton("ok");
            
            pp1.setFont(new Font("times New Roman",Font.BOLD,22));
            pp1.setBounds(70,300,200,50);


            xx.add(bc);
            xx.add(pp1);
        
            pp1.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent t)
                {
                   xx.setVisible(false);
                   login uy=new login();
                }
                });
            xx.setSize(800,800);
            xx.setLayout(null);
            xx.setVisible(true);

        }

        catch(Exception c)
        {
            c.printStackTrace();
            
        }

    }
    if(e.getSource()==p2)
    {
        r.dispose();
        login ll=new login();
    }
}

}