package model;

import db.DBConnector;
import dto.JournalistDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author NEHA
 */
public class JournalistRegisterAuthenticator
{
    public boolean isRegister(JournalistDTO user)
    {
        String fullname=user.getFullname();
        String email=user.getEmail();
        String username=user.getUsername();
        String password=user.getPassword();
        String cpassword=user.getCpassword();
        String phoneno=user.getPhoneno();
        try
        {
            Connection con=DBConnector.getConnection();
            Statement st=con.createStatement();
            String query="select username from jregister where username='"+username+"'";
            ResultSet rs=st.executeQuery(query);
            System.out.println("Query:"+query);
            
            if(rs.next())
            {
                return false;
            }
            else
            {
            PreparedStatement pst=con.prepareStatement("insert into jregister values(?,?,?,?,?)");
            pst.setString(1,fullname);
            pst.setString(2,username);
            pst.setString(3,email);
            pst.setString(4,password); 
            pst.setString(5,phoneno);
            
            int i=pst.executeUpdate();
            if(i>0)
            {
                System.out.println("registeration successful");
                return true;
            }
            else
            {
                System.out.println("fail");
            }
        }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        if(username!=null && password!=null && !password.trim().equals("") && password.equals(cpassword))
        {
            return true;
        }
        return false;
    }
}
