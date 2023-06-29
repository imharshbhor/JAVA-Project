package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame{

    String pinno;
    MiniStatement(String pinno)
    {
    this.pinno = pinno;
    setLayout(null);    
        
    JLabel l1 = new JLabel("Indian Bank");
    l1.setBounds(150,20,100,20);
    add(l1);
    
    JLabel card = new JLabel();
    card.setBounds(20,80,300,20);
    add(card);
    
    JLabel mini = new JLabel();
    mini.setBounds(20,120,300,20);
    add(mini);
    
    JLabel bal = new JLabel();
    mini.setBounds(20,400,300,20);
    add(bal);
    
    try
    {
    Conn c = new Conn();
    ResultSet rs = c.st.executeQuery("select * from login where pin  = '"+pinno+"'");
    while(rs.next())
    {
    card.setText("Card number : "+rs.getString("cardnumber"));
    }
    }
    catch(Exception e)
    {
    }
    
    try
    {
    Conn c = new Conn();
    ResultSet rs = c.st.executeQuery("select * from account where pin = '"+pinno+"'");
    while(rs.next())
    {
    mini.setText(mini.getText() + "<html>" + rs.getString("date") + "<br>" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br>");
    }
    }
    catch(Exception e)
    {
    
    }
    
    try
    {
    BalanceEnquiry be = new BalanceEnquiry(pinno);
    String balance = ""+be.balance;
    bal.setText("Total balance : "+balance);
    }
    catch(Exception e)
    {
    
    }
    
    setTitle("MINI STATEMENT");
    setSize(400,600);
    setLocation(20,20);
    getContentPane().setBackground(Color.WHITE);
    }      

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
    
}
