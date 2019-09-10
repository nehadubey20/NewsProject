/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBConnector;
import dto.EditorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author NEHA
 */
public class EditorRegisterAuthenticator extends HttpServlet {
    public boolean isRegister(EditorDTO editor)
    {
        String fullname=editor.getFullname();
        String email=editor.getEmail();
        String username=editor.getUsername();
        String password=editor.getPassword();
        String cpassword=editor.getCpassword();
        String phoneno=editor.getPhoneno();
        try
        {
            Connection con=DBConnector.getConnection();
            Statement st=con.createStatement();
            String query="select username from eregister where username='"+username+"'";
            ResultSet rs=st.executeQuery(query);
            System.out.println("Query:"+query);
            
            if(rs.next())
            {
                return false;
            }
            else
            {
            PreparedStatement pst=con.prepareStatement("insert into eregister values(?,?,?,?,?)");
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
