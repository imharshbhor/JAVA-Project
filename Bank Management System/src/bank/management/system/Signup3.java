package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,can;
    String formno;
    
    Signup3(String formno)
    {
    this.formno = formno;
    setTitle("ACCOUNT DETAILS - PAGE 3");
    setSize(850,800);
    setLocation(300,0);
    setVisible(true);
    setLayout(null);
        
    JLabel l1 = new JLabel("Page 3 : Account Details :");
    l1.setFont(new Font("Raleway",Font.BOLD,22));
    l1.setBounds(300,40,400,40);
    add(l1);
    
    JLabel type = new JLabel("Account Type");
    type.setFont(new Font("Raleway",Font.BOLD,22));
    type.setBounds(100,100,200,30);
    add(type);
    
    r1 = new JRadioButton("Savings Account");
    r1.setFont(new Font("Raleway",Font.BOLD,16));
    r1.setBackground(Color.WHITE);
    r1.setBounds(100,140,250,20);
    add(r1);
            
    r2 = new JRadioButton("Fixed Deposit Account");
    r2.setFont(new Font("Raleway",Font.BOLD,16));
    r2.setBackground(Color.WHITE);
    r2.setBounds(350 ,140,250,20);
    add(r2);
    
    r3 = new JRadioButton("Current Account");
    r3.setFont(new Font("Raleway",Font.BOLD,16));
    r3.setBackground(Color.WHITE);
    r3.setBounds(100,180,250,20);
    add(r3);
    
    r4 = new JRadioButton("Recurring Account");
    r4.setFont(new Font("Raleway",Font.BOLD,16));
    r4.setBackground(Color.WHITE);
    r4.setBounds(350,180,250,20);
    add(r4);
    
    ButtonGroup bg = new ButtonGroup();
    bg.add(r1);
    bg.add(r2);
    bg.add(r3);
    bg.add(r4);
    
    JLabel card = new JLabel("Card Number");
    card.setFont(new Font("Raleway",Font.BOLD,22));
    card.setBounds(100,240,200,30);
    add(card);
    
    JLabel num = new JLabel("XXXX-XXXX-XXXX-2416");
    num.setFont(new Font("Raleway",Font.BOLD,22));
    num.setBounds(330,240,300,30);
    add(num);
    
    JLabel l2 = new JLabel("Your 16 digit card number");
    l2.setFont(new Font("Raleway",Font.BOLD,15));
    l2.setBounds(100,280,400,20);
    add(l2);
    
    JLabel pin = new JLabel("PIN");
    pin.setFont(new Font("Raleway",Font.BOLD,22));
    pin.setBounds(100,320,200,30);
    add(pin);
    
    JLabel pnum = new JLabel("XXXX");
    pnum.setFont(new Font("Raleway",Font.BOLD,22));
    pnum.setBounds(330,320,300,30);
    add(pnum);
    
    JLabel l3 = new JLabel("Your 4 digit PIN");
    l3.setFont(new Font("Raleway",Font.BOLD,15));
    l3.setBounds(100,360,400,20);
    add(l3);
    
    JLabel ser = new JLabel("Services Required");
    ser.setFont(new Font("Raleway",Font.BOLD,22));
    ser.setBounds(100,410,400,30);
    add(ser);
    
    c1 = new JCheckBox("ATM Card");
    c1.setBackground(Color.WHITE);
    c1.setFont(new Font("Raleway",Font.BOLD,16));
    c1.setBounds(100,460,200,30);
    add(c1);
    
    c2 = new JCheckBox("Cheque Book");
    c2.setBackground(Color.WHITE);
    c2.setFont(new Font("Raleway",Font.BOLD,16));
    c2.setBounds(350,460,200,30);
    add(c2);
    
    c3 = new JCheckBox("Mobile Banking");
    c3.setBackground(Color.WHITE);
    c3.setFont(new Font("Raleway",Font.BOLD,16));
    c3.setBounds(100,510,200,30);
    add(c3);
    
    c4 = new JCheckBox("E-mail Alerts");
    c4.setBackground(Color.WHITE);
    c4.setFont(new Font("Raleway",Font.BOLD,16));
    c4.setBounds(350,510,200,30);
    add(c4);
    
    c5 = new JCheckBox("Internet Banking");
    c5.setBackground(Color.WHITE);
    c5.setFont(new Font("Raleway",Font.BOLD,16));
    c5.setBounds(100,560,200,30);
    add(c5);
    
    c6 = new JCheckBox("E-Statement");
    c6.setBackground(Color.WHITE);
    c6.setFont(new Font("Raleway",Font.BOLD,16));
    c6.setBounds(350,560,200,30);
    add(c6);
    
    c7 = new JCheckBox("I hereby declare that above mentioned details are correct to the best fo mt knowledge");
    c7.setBackground(Color.WHITE);
    c7.setFont(new Font("Raleway",Font.BOLD,12));
    c7.setBounds(100,610,600,30);
    add(c7);
    
    submit = new JButton("SUBMIT");
    submit.setBounds(250,650,100,30);
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    add(submit);
    submit.addActionListener(this);
        
    can = new JButton("CANCEL");
    can.setBounds(420,650,100,30);
    can.setBackground(Color.BLACK);
    can.setForeground(Color.WHITE);
    add(can);
    can.addActionListener(this);    
    
    getContentPane().setBackground(Color.WHITE);
    
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
        String acctype = null;
        if(r1.isSelected())
        {
            acctype = "Savings Account";
        }
        else if(r2.isSelected())
        {
            acctype = "Fixed Deposit Account";
        }
        else if(r3.isSelected())
        {
            acctype = "Current Account";
        }
        else if(r4.isSelected())
        {
            acctype = "Recurring Account";
        }
        Random r = new Random();
        
        String cardno = "" + Math.abs(r.nextLong() % 90000000L) + 50409360L;
        
        String pinno = "" + Math.abs(r.nextLong() % 9000L);
       
        String serv = "";
        if(c1.isSelected())
        {
            serv = serv + "ATM Card";
        }
        else if(c2.isSelected())
        {
            serv = serv + "Cheque Book";
        }
        else if(c3.isSelected())
        {
            serv = serv + "Mobile Banking";
        }
        else if(c4.isSelected())
        {
            serv = serv + "E-mail Alerts";;
        }
        else if(c5.isSelected())
        {
            serv = serv + "Internet Banking";
        }
        else if(c6.isSelected())
        {
            serv = serv + "E-Statement";
        }
        
        try
        {
        if(acctype.equals(""))
        {
        JOptionPane.showMessageDialog(null,"Account type is required");
        }
        else
        {
        Conn c = new Conn();
        String sql = "insert into signupthree values('"+formno+"','"+acctype+"','"+cardno+"','"+pinno+"','"+serv+"')";
        String sql2 = "insert into login values('"+formno+"','"+cardno+"','"+pinno+"')";
        c.st.executeUpdate(sql);
        c.st.executeUpdate(sql2);
        
        JOptionPane.showMessageDialog(null,"Card no : "+cardno+"\nPIN : "+pinno);
        
        setVisible(false);
        new Deposit(pinno).setVisible(true);
        }
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
        
        } 
        else if(ae.getSource()==can)
        {
        System.exit(0);
        }
        
    }
    public static void main(String[] args) {
        new Signup3("");
    }
}

