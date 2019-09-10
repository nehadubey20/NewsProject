/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBConnector;
import dto.EditorDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author NEHA
 */
@WebServlet(name = "EditorLoginAuthenticator", urlPatterns = {"/EditorLoginAuthenticator"})
public class EditorLoginAuthenticator extends HttpServlet {
    public boolean isLogin(EditorDTO edto)
    {
        String username=edto.getUsername();
        String password=edto.getPassword();
        
        String tablepassword="";
        try
        {
            Statement st=DBConnector.getStatement();
            String query="select password from eregister where username='"+username+"'";
            System.out.println("Query is:"+query);
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                tablepassword=rs.getString(1);
            }
            else
            {
                return false;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        if(username!=null && password!=null && !username.trim().equalsIgnoreCase("") && !password.trim().equals("") && password.equals(tablepassword))
        {
            return true;
        }
        return false;
    }


}
