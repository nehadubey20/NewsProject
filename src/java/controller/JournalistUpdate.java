/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
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
@WebServlet(name = "JournalistUpdate", urlPatterns = {"/JournalistUpdate"})
public class JournalistUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.sendRedirect("jprofile.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String username=req.getParameter("username");
        String fullname=req.getParameter("fullname");
        String email=req.getParameter("email");
        String contact=req.getParameter("phoneno");
        
        try
        {
            Connection con=DBConnector.getConnection();
            Statement st=con.createStatement();
            
            String query="update jregister set fullname='"+fullname+"' email='"+email+"',  phoneno='"+contact+"' where username='"+username+"'";
            System.out.println("query:"+query);
            System.out.println("update success...");
            int rs=st.executeUpdate(query);
            
        }
        
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
}
