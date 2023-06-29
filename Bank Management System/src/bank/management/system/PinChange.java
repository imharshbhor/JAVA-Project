
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{

    String pinno;
    JTextField npin,rnpin;
    JButton change,back;
    
    PinChange(String pinno)
    {
        this.pinno = pinno;
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);
        
        JLabel l1 = new JLabel("Change PIN");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(200,250,700,35);
        img.add(l1);
        
        JLabel l2 = new JLabel("Enter new PIN :");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(200,300,180,35);
        img.add(l2);
        
        npin = new JTextField();
        npin.setFont(new Font("Raleway",Font.BOLD,22));
        npin.setBounds(360,300,100,25);
        img.add(npin);
        
        JLabel l3 = new JLabel("Re-Enter new PIN :");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System",Font.BOLD,16));
        l3.setBounds(200,350,180,35);
        img.add(l3);
        
        rnpin = new JTextField();
        rnpin.setFont(new Font("Raleway",Font.BOLD,22));
        rnpin.setBounds(360,350,100,25);
        img.add(rnpin);
        
        change = new JButton("Change");
        change.setBounds(355,410,150,30);
        img.add(change);
        change.addActionListener(this);
        
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
    if(ae.getSource()==change)
    {
    try
    {
    String pin = npin.getText();
    String rpin = rnpin.getText();
    
    if(!pin.equals(rpin))
    {
    JOptionPane.showMessageDialog(null, "PIN does not match");
    }
    else if(pin.equals(""))
    {
    JOptionPane.showMessageDialog(null, "Please enter PIN");
    }
    else
    {
    Conn c = new Conn();
    String sql = "update account set pin = '"+rpin+"' where pin = '"+pinno+"'";
    String sql2 = "update login set pin = '"+rpin+"' where pin = '"+pinno+"'";
    String sql3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinno+"'";
    c.st.executeUpdate(sql);
    c.st.executeUpdate(sql2);
    c.st.executeUpdate(sql3);
    
    JOptionPane.showMessageDialog(null, "PIN changed");
    setVisible(false);
    new Transactions(rpin).setVisible(true);
    }
    }
    
    catch(Exception e)
    {
    System.out.println(e);
    }
    }
    else if(ae.getSource()==back)
    {
    setVisible(false);
    new Transactions(pinno).setVisible(true);
    }
    }

    
    public static void main(String[] args) {
        new PinChange("");
    }
    
}
