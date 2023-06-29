package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Signup1 extends JFrame implements ActionListener{
    
    long rand; 
    JTextField nameTF, fnameTF, emailTF, addrTF, cityTF, stateTF, pcodeTF; 
    JRadioButton male, female, marr, unmarr;
    JButton next;
    JDateChooser dc;
    
    Signup1()
    {   
        setTitle("NEW APPLICATION FORM - PAGE 1");
        setSize(850,800);
        setLocation(300,0);
        setVisible(true);
        setLayout(null);
        
        Random r = new Random();
        rand = Math.abs((r.nextLong()%9000L)+1000L); 
        JLabel formno = new JLabel("APPLICATION FORM NO : "+rand);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel details = new JLabel("Page 1 : Personal Details");
        details.setFont(new Font("Raleway",Font.BOLD,22));
        details.setBounds(290,80,400,30);
        add(details);
        
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTF = new JTextField();
        nameTF.setFont(new Font("Raleway",Font.BOLD,14));
        nameTF.setBounds(300,140,400,30);
        add(nameTF);
        
        JLabel fname = new JLabel("Fathers Name :");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTF = new JTextField();
        fnameTF.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTF.setBounds(300,190,400,30);
        add(fnameTF);
        
        JLabel dob = new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dc = new JDateChooser();
        dc.setBounds(300,240,400,30);
        dc.setForeground(Color.RED);
        add(dc);
        
        JLabel gen = new JLabel("Gender :");
        gen.setFont(new Font("Raleway",Font.BOLD,22));
        gen.setBounds(100,290,100,30);
        add(gen);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,120,30);
        male.setBackground(Color.WHITE);
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(male);
        add(female);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        JLabel email = new JLabel("E-mail :");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,340,100,30);
        add(email);
        
        emailTF = new JTextField();
        emailTF.setFont(new Font("Raleway",Font.BOLD,14));
        emailTF.setBounds(300,340,400,30);
        add(emailTF);
        
        JLabel status = new JLabel("Marital Status :");
        status.setFont(new Font("Raleway",Font.BOLD,22));
        status.setBounds(100,390,200,30);
        add(status);
        
        marr = new JRadioButton("Married");
        marr.setBounds(300,390,120,30);
        marr.setBackground(Color.WHITE);
        unmarr = new JRadioButton("Unmarried");
        unmarr.setBounds(450,390,120,30);
        unmarr.setBackground(Color.WHITE);
        add(marr);
        add(unmarr);
        
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(marr);
        bg2.add(unmarr);
        
        JLabel addr = new JLabel("Address :");
        addr.setFont(new Font("Raleway",Font.BOLD,22));
        addr.setBounds(100,440,100,30);
        add(addr);
        
        addrTF = new JTextField();
        addrTF.setFont(new Font("Raleway",Font.BOLD,14));
        addrTF.setBounds(300,440,400,30);
        add(addrTF);
        
        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,100,30);
        add(city);
        
        cityTF = new JTextField();
        cityTF.setFont(new Font("Raleway",Font.BOLD,14));
        cityTF.setBounds(300,490,400,30);
        add(cityTF);
        
        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,100,30);
        add(state);
        
        stateTF = new JTextField();
        stateTF.setFont(new Font("Raleway",Font.BOLD,14));
        stateTF.setBounds(300,540,400,30);
        add(stateTF);
        
        JLabel pcode = new JLabel("Pin Code :");
        pcode.setFont(new Font("Raleway",Font.BOLD,22));
        pcode.setBounds(100,590,200,30);
        add(pcode);
        
        pcodeTF = new JTextField();
        pcodeTF.setFont(new Font("Raleway",Font.BOLD,14));
        pcodeTF.setBounds(300,590,400,30);
        add(pcodeTF);
        
        next = new JButton("NEXT");
        next.setBounds(350,640,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        add(next);
        next.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String formno = "" + rand;
        String name = nameTF.getText();
        String fname = fnameTF.getText();
        String email = emailTF.getText();
        String dob = ((JTextField)dc.getDateEditor().getUiComponent()).getText();  
        String gen = null;
        if(male.isSelected())
        {
        gen = "Male";
        }
        else if(female.isSelected())
        {
        gen = "Female";
        }
        String status = null;
        if(marr.isSelected())
        {
        status = "Married";
        }
        else if(unmarr.isSelected())
        {
        status = "Unmarried";
        }
        String addr = addrTF.getText();
        String state = stateTF.getText();
        String city = cityTF.getText();
        String pcode = pcodeTF.getText();
        
        try
        {
        if(name.equals(""))
        {
        JOptionPane.showMessageDialog(null,"Name is required");
        }
        else
        {
        Conn c = new Conn();
        String sql = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gen+"','"+email+"','"+status+"','"+addr+"','"+city+"','"+pcode+"','"+state+"')";
        c.st.executeUpdate(sql);
        
        setVisible(false);
        new Signup2(formno).setVisible(true);
        }
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Signup1();
    }
    
}
