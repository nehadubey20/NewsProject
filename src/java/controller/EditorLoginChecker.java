/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.EditorDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EditorLoginAuthenticator;

/**
 *
 * @author NEHA
 */
@WebServlet(name = "EditorLoginChecker", urlPatterns = {"/EditorLoginChecker"})
public class EditorLoginChecker extends HttpServlet {
       
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.sendRedirect("editor.html");
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        
        EditorDTO edto=new EditorDTO();
        edto.setUsername(username);
        edto.setPassword(password);
        
        
        EditorLoginAuthenticator authenticator=new EditorLoginAuthenticator();
        boolean login=authenticator.isLogin(edto);
        
        if(login)
        {
            HttpSession session=req.getSession(true);
            session.setAttribute("username",username);
            resp.sendRedirect("eprofile.jsp");
        }
        else
        {
            resp.sendRedirect("editor.html");
        }
    }  

  }
