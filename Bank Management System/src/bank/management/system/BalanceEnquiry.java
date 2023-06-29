package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JTextField amt;
    JButton with,back;
    String pinno;
    int balance = 0;
    BalanceEnquiry(String pinno)
    {
    this.pinno = pinno;
    ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel img = new JLabel(i3);
    img.setBounds(0,0,900,900);
    add(img);
    
    JLabel l1 = new JLabel("Your balance :");
    l1.setForeground(Color.WHITE);
    l1.setFont(new Font("System",Font.BOLD,16));
    l1.setBounds(200,250,700,35);
    img.add(l1);
    
    
    try
    {
    Conn c = new Conn();
    ResultSet rs = c.st.executeQuery("select * from account where pin = '"+pinno+"'");
    while(rs.next())
    {
    if(rs.getString("type").equals("Deposit"))
    {
    balance += Integer.parseInt(rs.getString("amount"));
    }
    else if(rs.getString("type").equals("Withdraw"))
    {
    balance -= Integer.parseInt(rs.getString("amount"));
    }
    }
    }
    catch(Exception e)
    {
    System.out.println(e);
    } 
    
    JLabel l2 = new JLabel(""+balance);
    l2.setForeground(Color.WHITE);
    l2.setFont(new Font("System",Font.BOLD,16));
    l2.setBounds(200,300,700,35);
    img.add(l2);
    
    back = new JButton("Back");
    back.setBounds(355,445,150,30);
    img.add(back);
    back.addActionListener(this);
        
    setSize(900,900);
    setLocation(300,0);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getSource()==back)
    {
    setVisible(false);
    new Transactions(pinno).setVisible(true);
    }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
    
}
