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
import model.JournalistRegisterAuthenticator;


/**
 *
 * @author NEHA
 */
@WebServlet(name = "JournalistRegisterChecker", urlPatterns = {"/JournalistRegisterChecker"})
public class JournalistRegisterChecker extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.sendRedirect("jregister.html");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String fullname=req.getParameter("fullname");
        String username=req.getParameter("username");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        String cpassword=req.getParameter("cpassword");
        String phoneno=req.getParameter("phoneno");

        JournalistDTO journalist=new JournalistDTO();
        journalist.setFullname(fullname);
        journalist.setEmail(email);
        journalist.setUsername(username);
        journalist.setPassword(password);
        journalist.setCpassword(cpassword);
        journalist.setPhoneno(phoneno);
        
        JournalistRegisterAuthenticator authenticator=new JournalistRegisterAuthenticator();
        boolean register=authenticator.isRegister(journalist);
        
        if(register)
        {
            HttpSession session=req.getSession(true);
            resp.sendRedirect("journalist.html");
        }
        else
        {
            resp.sendRedirect("jregister.html");
        }
     }
}
