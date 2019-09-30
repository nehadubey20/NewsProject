/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnector;
import dto.JAddNewsDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NEHA
 */
@WebServlet(name = "JournalistAddNewsDAO", urlPatterns = {"/JournalistAddNewsDAO"})
public class JournalistAddNewsDAO extends HttpServlet {
 /*  public List<JournalistDTO> getAllUserData()
    {
        List<JournalistDTO> listOfAllUser=new ArrayList<JournalistDTO>();
        
        try
        {
        Statement st=DBConnector.getStatement();
        
        String query="Select * from jaddnews";
        
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
  */
    public JAddNewsDTO getSpecificUserData(String postname)
    {
        JAddNewsDTO jAddNewsDTO=new JAddNewsDTO();
        
        try
        {
        Statement st=DBConnector.getStatement();
        
        String query="Select * from jaddnews where postname='fashion'";
          //String query="Select * from jaddnews where username='"+username+"''";
      
        ResultSet rs=st.executeQuery(query);
        
        System.out.println("query:" +query);
        
        if(rs.next())
        {
            jAddNewsDTO=new JAddNewsDTO();
            jAddNewsDTO.setCategory(rs.getString(1));
            jAddNewsDTO.setPostname(rs.getString(2));
            jAddNewsDTO.setDesc(rs.getString(3));
            jAddNewsDTO.setLocation(rs.getString(4));
            jAddNewsDTO.setImage(rs.getString(5));            
        }
        
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return jAddNewsDTO;
    }
}
