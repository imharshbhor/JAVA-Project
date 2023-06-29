package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
        
public class Login extends JFrame implements ActionListener{
    
    JButton login, clear, signup;
    JTextField cardTF;
    JPasswordField pinTF;
    
    Login()
    {
        setTitle("ATM");
        
        setLayout(null);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(180,10,100,100);
        add(label); 
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(300,40,400,40);
        text.setFont(new Font("Oswald",Font.BOLD, 38));
        add(text);
        
        JLabel cardno = new JLabel("Card no :");
        cardno.setBounds(120,150,150,30);
        cardno.setFont(new Font("Raleway",Font.BOLD, 28));
        add(cardno);
        
        cardTF = new JTextField();
        cardTF.setBounds(300,150,230,30);
        cardTF.setFont(new Font("Arial",Font.BOLD, 14));
        add(cardTF);
        
        JLabel pin = new JLabel("PIN :");
        pin.setBounds(120,220,250,30);
        pin.setFont(new Font("Raleway",Font.BOLD, 28));
        add(pin);
        
        pinTF = new JPasswordField();
        pinTF.setBounds(300,220,230,30);
        pinTF.setFont(new Font("Arial",Font.BOLD, 14));
        add(pinTF);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        login.addActionListener(this);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);
        signup.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login)
        {
           String cardno = cardTF.getText();
           String pinno = pinTF.getText();
           Conn c = new Conn();
           String sql = "select * from login where cardnumber = '"+cardno+"' and pin = '"+pinno+"'";
           try
           {
           ResultSet rs = c.st.executeQuery(sql);
           if(rs.next())
           {
           setVisible(false);
           new Transactions(pinno).setVisible(true);
           }
           else
           {
           JOptionPane.showMessageDialog(null,"Wrong Credentials");
           }
           }
           catch(Exception e)
           {
           System.out.println(e);
           }
        }
        else if(ae.getSource()==clear)
        {
            cardTF.setText("");
            pinTF.setText("");
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }
    
    public static void main(String [] args)
    {
        new Login();
    }
}
