//program for withdraw
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class withdraws extends login implements ActionListener
    {

        JFrame w;
        JLabel k1;
        JTextField h;
        JButton j1,j2;
        withdraws()
        {
            
            //frame and labels
            w=new JFrame("withdraw");
            k1=new JLabel("AMOUNT:");
            k1.setFont(new Font("Monospace",Font.BOLD,22));
            k1.setBounds(50,150,200,50);
           
            //textfield
            h=new JTextField();
            h.setBounds(50,210,600,40);

            //buttons
             j1=new JButton("WITHDRAW");
            
            j1.setFont(new Font("times New Roman",Font.BOLD,22));
            j1.setBounds(70,300,200,50);

            j2=new JButton("BACK");
            
            j2.setFont(new Font("times New Roman",Font.BOLD,22));
            j2.setBounds(300,300,200,50);

            w.add(k1);
            w.add(h);
            w.add(j1);
            w.add(j2);
            j1.addActionListener(this);
            j2.addActionListener(this);
            
            w.setSize(800,800);
            w.setLayout(null);
            w.setVisible(true);
        }
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==j1)
            {
                
                int ba=Integer.parseInt(h.getText());
                

                try
                {
                  connection aa=new connection();

                 String d="select balance from user where cardno='"+PassDetails.cardNo+"'";
                 ResultSet rs=aa.stm.executeQuery(d);
                 rs.next();
                 int bb=rs.getInt("balance");
                  if(bb<ba)
                  {
                     JFrame tp=new JFrame();
                     JLabel lm=new JLabel();
                     lm.setText("Not Sufficient balance..");
                     lm.setFont(new Font("Times New Roman",Font.BOLD,20));
                     lm.setBounds(50,150,200,50);
                     JButton nn=new JButton("ok");
                     nn.setFont(new Font("times new roman",Font.BOLD,22));
                     nn.setBounds(100,400,100,50);
                    


                    
                     nn.addActionListener(new ActionListener(){

                     public void actionPerformed(ActionEvent t)
                     {
                        tp.dispose();
                     }
                     });
                     tp.add(lm);
                     tp.add(nn);
                     tp.setSize(800,500);
                     tp.setLayout(null);
                     tp.setVisible(true);

                  }

                  else
                  {
                  String p="update user SET balance = balance - '"+ba+"'WHERE cardno='"+PassDetails.cardNo+"'and pin='"+PassDetails.p+"'";
                  aa.stm.executeUpdate(p);
                  }
             }

             catch(Exception ec)
             {
                ec.printStackTrace();
             }


           }


               if(e.getSource()==j2)
               {
                w.setVisible(false);
                menus uu=new menus();
                
               }
        }
    }

