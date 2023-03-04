//program for menu
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class menus extends JFrame implements ActionListener
{
    JFrame m;
    JLabel t1;
    JButton b1,b2,b3,b4,b5,b6;
    
    menus()
    {
        //frame
        m=new JFrame("menu");
        m.getContentPane().setBackground(Color.lightGray);
        
        //label
        t1=new JLabel("Menu");
        t1.setFont(new Font("times New Roman",Font.BOLD,30));
        t1.setHorizontalAlignment(JLabel.CENTER);
        t1.setBounds(270,50,200,100);
        t1.setForeground(Color.BLUE);
        //buttons
        b1=new JButton("Withdraw");
        b1.setFont(new Font("times New Roman",Font.BOLD,22));
        b1.setBounds(420,200,200,50);

        b2=new JButton("transfer");
        b2.setFont(new Font("times New Roman",Font.BOLD,22));
        b2.setBounds(70,300,200,50);

        b3=new JButton("Change Pin");
        b3.setFont(new Font("times New Roman",Font.BOLD,22));
        b3.setBounds(420,300,200,50);

        b4=new JButton("Deposite");
        b4.setFont(new Font("times New Roman",Font.BOLD,22));
        b4.setBounds(70,200,200,50);

        b5=new JButton("Logout");
        b5.setFont(new Font("times New Roman",Font.BOLD,22));
        b5.setBounds(70,400,200,50);


        b6=new JButton("Balance");
        b6.setFont(new Font("times New Roman",Font.BOLD,22));
        b6.setBounds(420,400,200,50);




        //add
        m.add(t1);
        m.add(b1);
        m.add(b2);
        m.add(b3);
        m.add(b4);
        m.add(b5);
        m.add(b6);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        m.setSize(800,800);
        m.setLayout(null);
        m.setVisible(true);
        

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            m.dispose();
            withdraws ww=new withdraws();

        }

     else if(e.getSource()==b4)
        {
            m.dispose();
            deposites xx=new deposites();

        }

        else if(e.getSource()==b6)
        {
            m.dispose();
            balancp bb=new balancp();

        }

        else if(e.getSource()==b3)
        {
            m.dispose();
            chang cc=new chang();
            

        }

        else if(e.getSource()==b2)
        {
            m.dispose();
            Transaction tt=new Transaction();
            

        }

        else
        {
        
            m.dispose();
            login hh=new login();
        }






    }

}



