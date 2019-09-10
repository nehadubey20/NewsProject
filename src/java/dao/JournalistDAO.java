/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnector;
import dto.JournalistDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author NEHA
 */
@WebServlet(name = "JournalistDAO", urlPatterns = {"/JournalistDAO"})
public class JournalistDAO extends HttpServlet {
  public List<JournalistDTO> getAllUserData()
    {
        List<JournalistDTO> listOfAllUser=new ArrayList<JournalistDTO>();
        
        try
        {
        Statement st=DBConnector.getStatement();
        
        String query="Select * from jregister";
        
        ResultSet rs=st.executeQuery(query);
        
        System.out.println("query:" +query);
        
        while(rs.next())
        {
            JournalistDTO journalistDTO=new JournalistDTO();
            journalistDTO.setFullname(rs.getString(1));
            journalistDTO.setUsername(rs.getString(2));
            journalistDTO.setEmail(rs.getString(3));
            journalistDTO.setPhoneno(rs.getString(4));
            
            listOfAllUser.add(journalistDTO);
        }
        
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return listOfAllUser;
    }
   
    public JournalistDTO getSpecificUserData(String username)
    {
        JournalistDTO journalistDTO=null;
        
        try
        {
        Statement st=DBConnector.getStatement();
        
        String query="Select * from jregister where username='"+username+"'";
        
        ResultSet rs=st.executeQuery(query);
        
        System.out.println("query:" +query);
        
        if(rs.next())
        {
            journalistDTO=new JournalistDTO();
            journalistDTO.setFullname(rs.getString(1));
            journalistDTO.setUsername(rs.getString(2));
            journalistDTO.setEmail(rs.getString(3));
            journalistDTO.setPhoneno(rs.getString(4));
        }
        
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return journalistDTO;
    }
    
    


}
