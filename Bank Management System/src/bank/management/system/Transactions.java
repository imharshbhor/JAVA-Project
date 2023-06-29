package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdraw,min,pchange,bal,exit;
    String pinno;
    
    Transactions(String pinno)
    {
        this.pinno = pinno;
    setSize(900,900);
    setLocation(300,0);
    
    setVisible(true);
   
    ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    
    JLabel img = new JLabel(i3);
    img.setBounds(0,0,900,9000);
    add(img);
    
    JLabel l1 = new JLabel("Please select your transaction");
    l1.setBounds(215,250,700,35);
    l1.setForeground(Color.WHITE);
    l1.setFont(new Font("System",Font.BOLD,16));
    img.add(l1);
    
    deposit = new JButton("Deposit");
    deposit.setBounds(150,340,150,30);
    img.add(deposit);
    deposit.addActionListener(this);
    
    withdraw = new JButton("Withdraw");
    withdraw.setBounds(355,340,150,30);
    img.add(withdraw);
    withdraw.addActionListener(this);
    
    min = new JButton("Mini Statement");
    min.setBounds(150,375,150,30);
    img.add(min);
    min.addActionListener(this);
    
    pchange = new JButton("Pin Change");
    pchange.setBounds(355,375,150,30);
    img.add(pchange);
    pchange.addActionListener(this);
    
    bal = new JButton("Balance Enquiry");
    bal.setBounds(355,410,150,30);
    img.add(bal);
    bal.addActionListener(this);
    
    exit = new JButton("Exit");
    exit.setBounds(355,445,150,30);
    img.add(exit);
    exit.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    { 
    if(ae.getSource()==exit)
    {
    System.exit(0);
    }
    else if(ae.getSource()==deposit)
    {
    setVisible(false);
    new Deposit(pinno).setVisible(true);
    }
    else if(ae.getSource()==withdraw)
    {
    setVisible(false);
    new Withdraw(pinno).setVisible(true);
    }
    else if(ae.getSource()==pchange)
    {
    setVisible(false);
    new PinChange(pinno).setVisible(true);
    }
    else if(ae.getSource()==bal)
    {
    setVisible(false);
    new BalanceEnquiry(pinno).setVisible(true);
    }
    else if(ae.getSource()==min)
    {
    new MiniStatement(pinno).setVisible(true);
    }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
    
}
