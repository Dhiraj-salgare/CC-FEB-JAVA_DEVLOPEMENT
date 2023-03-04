import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class chang extends JFrame implements ActionListener
{
    JFrame e;
    JLabel C1,C2,C3,C4;
    JTextField t5,t6;
    JPasswordField p6;
    JButton o5,o6;

    chang()
    {
        e=new JFrame("changepin");
        e.getContentPane().setBackground(Color.lightGray);

        C1 =new JLabel("CHANGEPIN");
        C1.setFont(new Font("Times New Roman",Font.BOLD,30));
        C1.setBounds(270,50,200,100);
        C1.setHorizontalAlignment(JLabel.CENTER);

        C2=new JLabel("CARDNO:");
        C2.setFont(new Font("Monospace",Font.BOLD,22));
        C2.setBounds(50,150,200,50);

        C3=new JLabel("PREVIOUS PIN:");
        C3.setFont(new Font("Monospace",Font.BOLD,22));
        C3.setBounds(50,250,200,50);

        C4=new JLabel("NEW PIN:");
        C4.setFont(new Font("Monospace",Font.BOLD,22));
        C4.setBounds(50,350,200,50);


        t5=new JTextField();
        t5.setBounds(50,200,400,40);
        
        t6=new JTextField();
        t6.setBounds(50,300,400,40);

        p6=new JPasswordField();
        p6.setBounds(50,400,400,40);


        o5=new JButton("SUBMIT");
            
        o5.setFont(new Font("times New Roman",Font.BOLD,22));
        o5.setBounds(50,500,200,50);

        o6=new JButton("CANCEL");
            
        o6.setFont(new Font("times New Roman",Font.BOLD,22));
        o6.setBounds(420,500,200,50);


        o5.addActionListener(this);
        o6.addActionListener(this);

          e.add(C1);
          e.add(C2);
          e.add(C3);
          e.add(C4);
          e.add(t5);
          e.add(t6);
          e.add(p6);
          e.add(o5);
          e.add(o6);

          e.setLayout(null);
          e.setSize(800,800);
          e.setVisible(true);

    }

        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==o5)
            {
                String ss=t5.getText();
                String oo=t6.getText();
                String zz=String.valueOf(p6.getPassword());

                try 
                {
                    connection aa=new connection();
                    String op="update user set pin='"+zz+"'where cardno='"+PassDetails.cardNo+"' and pin='"+PassDetails.p+"'";
                    aa.stm.executeUpdate(op);

                    JFrame rr=new JFrame("changepin");
                    JLabel kk=new JLabel();
                    kk.setText("your pin is changed");
                    kk.setFont(new Font("Monospace",Font.BOLD,22));
                    kk.setBounds(50,150,200,50);
        
                    //buttons
                    JButton pp=new JButton("ok");
                    
                    pp.setFont(new Font("times New Roman",Font.BOLD,22));
                    pp.setBounds(70,300,200,50);
        
        
                    rr.add(kk);
                    rr.add(pp);
                
                    pp.addActionListener(new ActionListener(){

                        public void actionPerformed(ActionEvent t)
                        {
                           rr.setVisible(false);
                        }
                        });
                    rr.setSize(800,800);
                    rr.setLayout(null);
                    rr.setVisible(true);
                }
                catch(Exception ep)
                {
                    ep.printStackTrace();
                }
            }
            if(e.getSource()==o6)
            {
                menus kk=new menus();
            }
            
        }

}