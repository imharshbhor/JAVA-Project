package bank.management.system;

import java.sql.*;

public class Conn {
    
    Connection con;
    Statement st;

    public Conn()
    {
        try
        {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","admin");
        st = con.createStatement();
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
    }
    
}
