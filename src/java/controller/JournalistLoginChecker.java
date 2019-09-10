/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.JournalistDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.JournalistLoginAuthenticator;

/**
 *
 * @author NEHA
 */
@WebServlet(name = "JournalistLoginChecker", urlPatterns = {"/JournalistLoginChecker"})
public class JournalistLoginChecker extends HttpServlet {

   
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.sendRedirect("journalist.html");
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        
        JournalistDTO journalist=new JournalistDTO();
        journalist.setUsername(username);
        journalist.setPassword(password);
        
        
        JournalistLoginAuthenticator authenticator=new JournalistLoginAuthenticator();
        boolean login=authenticator.isLogin(journalist);
        
        if(login)
        {
            HttpSession session=req.getSession(true);
            session.setAttribute("username",username);
            resp.sendRedirect("jprofile.jsp");
        }
        else
        {
            resp.sendRedirect("journalist.html");
        }
    }  
}
