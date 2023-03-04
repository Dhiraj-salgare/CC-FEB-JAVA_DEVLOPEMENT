//program for balance

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

    public class balancp
    {

        JFrame u;
        JLabel y,oo;
    
        JButton d;
        balancp()
        {
            try
            {
                connection aa=new connection();
                String gg="select balance from user where cardno='"+PassDetails.cardNo+"' and pin='"+PassDetails.p+"'";
                ResultSet ts=aa.stm.executeQuery(gg);
                ts.next();
                int tt=ts.getInt("balance");

                  u=new JFrame("balance");
                  y=new JLabel();
                
                  y.setText("your balance is::"+tt);
                  y.setFont(new Font("Monospace",Font.BOLD,22));
                  y.setBounds(50,150,400,50);
                  
                  

            //buttons
                    d=new JButton("ok");
            
                   d.setFont(new Font("times New Roman",Font.BOLD,22));
                   d.setBounds(70,300,200,50);


                  u.add(y);
                  u.add(d);

                 d.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent t)
                {
                   u.dispose();
                   menus ppp=new menus();
                }
                });
        
            
            u.setSize(500,500);
            u.setLayout(null);
            u.setVisible(true);
            }

            catch(Exception ey)
            {
                ey.printStackTrace();
            }
            
        
        }
        
    }
