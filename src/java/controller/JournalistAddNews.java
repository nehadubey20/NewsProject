/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBConnector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NEHA
 */

@WebServlet(name = "JournalistAddNews", urlPatterns = {"/JournalistAddNews"})
public class JournalistAddNews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.sendRedirect("jaddnews.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        
        //String username=req.getParameter("username");
        String category=req.getParameter("category");
        String postname=req.getParameter("postname");
        String description=req.getParameter("description");
        String location=req.getParameter("location");
        String keyword=req.getParameter("keyword");
        String image=req.getParameter("image");
        
        try
        {
            Connection con=DBConnector.getConnection();
            Statement st=con.createStatement();
            PreparedStatement pst=con.prepareStatement("insert into jaddnews values(?,?,?,?,?,?)");
            pst.setString(1,category);
            pst.setString(2,postname);
            pst.setString(3,description);
            pst.setString(4,location); 
            pst.setString(5,keyword);
            pst.setString(6,image);
            
            int i=pst.executeUpdate();
            if(i>0)
            {
                System.out.println("Inserted successfully");
                resp.sendRedirect("jviewstatus.jsp");
            }
            else
            {
                System.out.println("fail");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }    
}
}