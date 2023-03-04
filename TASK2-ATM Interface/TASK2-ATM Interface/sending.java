//program for transfer

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class sending extends JFrame implements ActionListener
{
    JFrame pp;
    JLabel m5,m6,m7;
    JTextField t8,t9,t7;
    JButton b8,b9;

    sending()
    {
         pp=new JFrame("TRANSFER:");
         m5=new JLabel("Name:");
         m5.setFont(new Font("Monospace",Font.BOLD,22));
         m5.setBounds(50,100,200,50);
        
         m6=new JLabel("cardNO:");
         m6.setFont(new Font("Monospace",Font.BOLD,22));
         m6.setBounds(50,200,200,50);

         m7=new JLabel("Amount:");
         m7.setFont(new Font("Monospace",Font.BOLD,22));
         m7.setBounds(50,300,200,50);

         t8=new JTextField();
         t8.setBounds(50,150,600,40);

         t9=new JTextField();
         t9.setBounds(50,250,600,40);

         t7=new JTextField();
         t7.setBounds(50,350,600,40);
        
         b8=new JButton("submit");
         b8.setFont(new Font("times New Roman",Font.BOLD,22));
         b8.setBounds(50,500,200,50);

         b9=new JButton("cancel");
         b9.setFont(new Font("times New Roman",Font.BOLD,22));
         b9.setBounds(300,500,200,50);

         pp.add(m5);
         pp.add(m6);
         pp.add(m7);
         pp.add(t8);
         pp.add(t9);
         pp.add(t7);
         pp.add(b8);
         pp.add(b9);

         b8.addActionListener(this);
         b9.addActionListener(this);
            
         pp.setSize(800,800);
         pp.setLayout(null);
         pp.setVisible(true);

    }

     public void actionPerformed(ActionEvent el)
     {
        if(el.getSource()==b8)
        {
              String j6=t8.getText();
              String ca=t9.getText();
              int ru=Integer.parseInt(t7.getText());

              try {
                   
                connection aa=new connection();

                String hh="update user set balance =balance-'"+ru+"' where cardno='"+PassDetails.cardNo+"' and pin='"+PassDetails.p+"'";
                String ww="update user set balance=balance+ '"+ru+"' where cardno='"+ca+"' and username='"+j6+"'";
                aa.stm.executeUpdate(hh);
                aa.stm.executeUpdate(ww);
                
                JFrame b=new JFrame();
                JLabel y=new JLabel(+ru+ "is transfered ");
                y.setBounds(50,200,200,50);
                y.setFont(new Font("times new roman",Font.BOLD,22));

                JButton m=new JButton("ok");
                m.setBounds(50,300,200,50);

                b.add(y);
                b.add(m);

                m.addActionListener(this);

                b.setSize(500,500);
                b.setLayout(null);
                b.setVisible(true);

                m.addActionListener(new ActionListener(){

                    public void actionPerformed(ActionEvent t)
                    {
                       b.setVisible(false);
                    }
                    });
                
              } 

              catch(Exception t)
              {
                t.printStackTrace();
              }
         
        }

        if(el.getSource()==b9)
        {
            pp.dispose();
            menus mm=new menus();
        }
        }
        
     }

 
