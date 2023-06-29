package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdraw extends JFrame implements ActionListener{

    JTextField amt;
    JButton with,back;
    String pinno;
    Withdraw(String pinno)
    {
    this.pinno = pinno;
    ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel img = new JLabel(i3);
    img.setBounds(0,0,900,900);
    add(img);
    
    JLabel l1 = new JLabel("Enter the amount to be withdrawn");
    l1.setForeground(Color.WHITE);
    l1.setFont(new Font("System",Font.BOLD,16));
    l1.setBounds(200,250,700,35);
    img.add(l1);
    
    amt = new JTextField();
    amt.setFont(new Font("Raleway",Font.BOLD,22));
    amt.setBounds(170,300,315,25);
    img.add(amt);
    
    with = new JButton("Withdraw");
    with.setBounds(355,410,150,30);
    img.add(with);
    with.addActionListener(this);
    
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
    if(ae.getSource()==with)
    {
    String money = amt.getText();
    Date date = new Date();
    if(money.equals(""))
    {
    JOptionPane.showMessageDialog(null, "Please enter amount");
    }
    else
    {
    try
    {
    Conn c = new Conn();
    ResultSet rs = c.st.executeQuery("select * from account where pin = '"+pinno+"'");
    int balance = 0;
    while(rs.next())
    {
    if(rs.getString("type").equals("Deposit"))
    {
    balance += Integer.parseInt(rs.getString("amount"));
    }
    }
    if(balance < Integer.parseInt(money))
    {
    JOptionPane.showMessageDialog(null, "Insufficiant funds");
    }
    else
    {
    String sql = "insert into account values('"+pinno+"','"+date+"','Withdraw',"+money+"')";
    c.st.executeUpdate(sql);
    JOptionPane.showMessageDialog(null, "Funds withdrawn successfully");
    setVisible(false);
    new Transactions(pinno).setVisible(true);
    }
    }
    catch(Exception e)
    {
    System.out.println(e);
    }
    }
    }
    else if(ae.getSource()==back)
    {
    setVisible(false);
    new Transactions(pinno).setVisible(true);
    }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
    
}
