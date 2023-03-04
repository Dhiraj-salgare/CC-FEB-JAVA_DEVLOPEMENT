//program for Atm interface

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PassDetails {
   public static String cardNo = "";
   public static String  p="";
}

public class login extends JFrame implements ActionListener
{
    JFrame log;
    JLabel logo,l1,cd,pin;
    JButton lo,re,ex;
    JTextField tf;
    JPasswordField pf;
    String cardNo = "";


    login()
    {
        //frame
        log=new JFrame();
        log.getContentPane().setBackground(Color.cyan);

        //logo
        logo=new JLabel("ATM");
        l1=new JLabel("Management System");

        logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setFont(new Font("Times New Roman",Font.BOLD,65));
        logo.setBounds(300,50,200,100);
        l1.setBounds(280,110,300,50);
        l1.setFont(new Font("Times New Roman",Font.BOLD,26));

        //labels for cardno and Pin

        cd =new JLabel("CARD NO:");
        cd.setFont(new Font("Monospace",Font.BOLD,22));
        cd.setBounds(50,250,200,50);

        pin=new JLabel("PIN:");
        pin.setFont(new Font("Monospace",Font.BOLD,22));
        pin.setBounds(50,320,200,50);

        //textfield and passwordField
        tf=new JTextField();
        tf.setBounds(250,250,300,40);

        pf=new JPasswordField();
        pf.setBounds(250,320,300,40);

        //buttons 
        lo=new JButton("LOGIN");
        lo.setFont(new Font("Rockwell",Font.BOLD,22));
        lo.setBounds(50,450,150,50);

        re=new JButton("REGISTER");
        re.setFont(new Font("Rockwell",Font.BOLD,22));
        re.setBounds(225,450,200,50);
        
        ex=new JButton("EXIT");
        ex.setFont(new Font("Rockwell",Font.BOLD,22));
        ex.setBounds(450,450,150,50);

        //action listner
        lo.addActionListener(this);
        re.addActionListener(this);
        ex.addActionListener(this);

        //adding in frame

        log.add(logo);
        log.add(l1);
        log.add(cd);
        log.add(pin);
        log.add(tf);
        log.add(pf);
        log.add(lo);
        log.add(re);
        log.add(ex);
        log.setSize(800,800);
        log.setLayout(null);
        log.setVisible(true);


    }

    //action performed on click button

    public void actionPerformed(ActionEvent e)
     {
        

        if(e.getSource()==lo)
        {
              String card=tf.getText();
               String pi=String.valueOf(pf.getPassword());
               PassDetails.cardNo = card;
               PassDetails.p=pi;
          try{
               connection aa=new connection();
               String s="select *from user where cardno='"+card+"'and pin='"+pi+"'";
               ResultSet rs = aa.stm.executeQuery(s);
               if(rs.next())
               {
                  log.dispose();
                menus mm=new menus();
               }

               else
               {
                  JFrame mn=new JFrame();
                JLabel cc=new JLabel("incorrect username or password");
                cc.setBounds(50,200,400,50);
                cc.setFont(new Font("times new roman",Font.BOLD,22));

                JButton p3=new JButton("ok");
                p3.setBounds(50,300,200,50);

                mn.add(cc);
                mn.add(p3);

                p3.addActionListener(this);

                mn.setSize(500,500);
                mn.setLayout(null);
                mn.setVisible(true);

                p3.addActionListener(new ActionListener(){

                    public void actionPerformed(ActionEvent t)
                    {
                       mn.setVisible(false);
                       login ll=new login();
                    }
                    });
                
               }

           }
           catch(Exception ece)
           {
            ece.printStackTrace();
          }

     }
       //register button
        else if(e.getSource()==re)
        {
         log.dispose();
          Register rr=new Register();
        }
  
     //exit

     else{
        log.setVisible(false);
     }
    }


     public static void main(String args[])
     {
        login ll=new login();
     }
    }