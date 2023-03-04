//program for deposite

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class deposites extends JFrame implements ActionListener
    {

        JFrame v;
        JLabel x;
        JTextField n;
        JButton q1,q2;
        deposites()
        {
            
            //frame and labels
            v=new JFrame("withdraw");
            x=new JLabel("AMOUNT:");
            x.setFont(new Font("Monospace",Font.BOLD,22));
            x.setBounds(50,150,200,50);
            
           
            //textfield
            n=new JTextField();
            n.setBounds(50,210,600,40);

            //buttons
             q1=new JButton("DEPOSITE");
            
            q1.setFont(new Font("times New Roman",Font.BOLD,22));
            q1.setBounds(70,300,200,50);

            q2=new JButton("BACK");
            
            q2.setFont(new Font("times New Roman",Font.BOLD,22));
            q2.setBounds(300,300,200,50);
            
            q1.addActionListener(this);
            q2.addActionListener(this);

            v.add(x);
            v.add(n);
            v.add(q1);
            v.add(q2);
            
            v.setSize(800,800);
            v.setLayout(null);
            v.setVisible(true);
        }
        public void actionPerformed(ActionEvent e)
        {
            

            if(e.getSource()==q1)
            {
                int de=Integer.parseInt(n.getText());

                try
                {
                    connection aa=new connection();
                    String rr="update user set balance=balance+'"+de+"' where cardno='"+PassDetails.cardNo+"' and pin='"+PassDetails.p+"'";
                    aa.stm.executeUpdate(rr);

                    JFrame jt=new JFrame();
                    JLabel ii=new JLabel();
                    ii.setText(+de+"Rs Deposited..");
                     ii.setFont(new Font("Times New Roman",Font.BOLD,20));
                    ii.setBounds(50,150,200,50);
                     JButton nn2=new JButton("ok");
                     nn2.setFont(new Font("times new roman",Font.BOLD,22));
                     nn2.setBounds(100,400,100,50);
                     nn2.addActionListener(new ActionListener(){

                        public void actionPerformed(ActionEvent t)
                        {
                           jt.setVisible(false);
                        }
                        });
                        jt.add(ii);
                        jt.add(nn2);
                        jt.setSize(800,500);
                        jt.setLayout(null);
                        jt.setVisible(true);
   


                    
            }
            catch(Exception er)
            {
                er.printStackTrace();
            }
        
            
        }

        if(e.getSource()==q2)
        {
            menus jj=new menus();
        }
    }
}