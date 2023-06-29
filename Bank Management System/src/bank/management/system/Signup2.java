package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Signup2 extends JFrame implements ActionListener{
    
    JTextField relTF, catTF, incTF, quaTF, occTF, panTF, aadharTF, extTF; 
    JRadioButton yes,no;
    JButton next;
    JDateChooser dc;
    String formno;
    
    Signup2(String formno)
    {   
        this.formno = formno;
        setTitle("NEW APPLICATION FORM - PAGE 2");
        setSize(850,800);
        setLocation(300,0);
        setVisible(true);
        setLayout(null);
        
        JLabel details2 = new JLabel("Page 2 : Additional Details");
        details2.setFont(new Font("Raleway",Font.BOLD,22));
        details2.setBounds(290,80,400,30);
        add(details2);
        
        JLabel rel = new JLabel("Religon :");
        rel.setFont(new Font("Raleway",Font.BOLD,22));
        rel.setBounds(100,140,100,30);
        add(rel);
        
        relTF = new JTextField();
        relTF.setFont(new Font("Raleway",Font.BOLD,14));
        relTF.setBounds(300,140,400,30);
        add(relTF);
        
        JLabel cat = new JLabel("Category :");
        cat.setFont(new Font("Raleway",Font.BOLD,22));
        cat.setBounds(100,190,200,30);
        add(cat);
        
        catTF = new JTextField();
        catTF.setFont(new Font("Raleway",Font.BOLD,14));
        catTF.setBounds(300,190,400,30);
        add(catTF);
        
        JLabel inc = new JLabel("Income :");
        inc.setFont(new Font("Raleway",Font.BOLD,22));
        inc.setBounds(100,240,200,30);
        add(inc);
        
        incTF = new JTextField();
        incTF.setFont(new Font("Raleway",Font.BOLD,14));
        incTF.setBounds(300,240,400,30);
        add(incTF);
        
        JLabel qua = new JLabel("Qualification :");
        qua.setFont(new Font("Raleway",Font.BOLD,22));
        qua.setBounds(100,290,200,30);
        add(qua);
        
        quaTF = new JTextField();
        quaTF.setFont(new Font("Raleway",Font.BOLD,14));
        quaTF.setBounds(300,290,400,30);
        add(quaTF);
        
        JLabel occ = new JLabel("Occupation :");
        occ.setFont(new Font("Raleway",Font.BOLD,22));
        occ.setBounds(100,340,200,30);
        add(occ);
        
        occTF = new JTextField();
        occTF.setFont(new Font("Raleway",Font.BOLD,14));
        occTF.setBounds(300,340,400,30);
        add(occTF);
        
        JLabel pan = new JLabel("PAN no :");
        pan.setFont(new Font("Raleway",Font.BOLD,22));
        pan.setBounds(100,390,100,30);
        add(pan);
        
        panTF = new JTextField();
        panTF.setFont(new Font("Raleway",Font.BOLD,14));
        panTF.setBounds(300,390,400,30);
        add(panTF);
        
        JLabel aadhar = new JLabel("Aadhar Card no :");
        aadhar.setFont(new Font("Raleway",Font.BOLD,22));
        aadhar.setBounds(100,440,300,30);
        add(aadhar);
        
        aadharTF = new JTextField();
        aadharTF.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTF.setBounds(300,440,400,30);
        add(aadharTF);
        
        JLabel ext = new JLabel("Existing Account :");
        ext.setFont(new Font("Raleway",Font.BOLD,22));
        ext.setBounds(100,490,200,30);
        add(ext);
        
        yes = new JRadioButton("Yes");
        yes.setBounds(300,490,120,30);
        yes.setBackground(Color.WHITE);
        no = new JRadioButton("No");
        no.setBounds(450,490,120,30);
        no.setBackground(Color.WHITE);
        add(yes);
        add(no);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(yes);
        bg.add(no);
        
        next = new JButton("NEXT");
        next.setBounds(350,540,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        add(next);
        next.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String rel = relTF.getText();
        String cat = catTF.getText();
        String inc = incTF.getText();
        String qua = quaTF.getText();  
        String occ = occTF.getText();
        String pan = panTF.getText();
        String aadhar = aadharTF.getText();
        String ext = null;
        if(yes.isSelected())
        {
        ext = "Yes";
        }
        else if(no.isSelected())
        {
        ext = "No";
        }
        
        try
        {
        if(relTF.equals(""))
        {
        JOptionPane.showMessageDialog(null,"Religon is required");
        }
        else
        {
        Conn c = new Conn();
        String sql = "insert into signuptwo values('"+formno+"','"+rel+"','"+cat+"','"+inc+"','"+qua+"','"+occ+"','"+pan+"','"+aadhar+"','"+ext+"')";
        c.st.executeUpdate(sql);
        
        setVisible(false);
        
        new Signup3(formno).setVisible(true);
        }
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
    
}
