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
import model.EditorRegisterAuthenticator;


/**
 *
 * @author NEHA
 */
@WebServlet(name = "EditorRegisterChecker", urlPatterns = {"/EditorRegisterChecker"})
public class EditorRegisterChecker extends HttpServlet {

        @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.sendRedirect("eregister.html");
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

        EditorDTO editor=new EditorDTO();
        editor.setFullname(fullname);
        editor.setEmail(email);
        editor.setUsername(username);
        editor.setPassword(password);
        editor.setCpassword(cpassword);
        editor.setPhoneno(phoneno);
        
        EditorRegisterAuthenticator authenticator=new EditorRegisterAuthenticator();
        boolean register=authenticator.isRegister(editor);
        
        if(register)
        {
            HttpSession session=req.getSession(true);
            resp.sendRedirect("editor.html");
        }
        else
        {
            resp.sendRedirect("eregister.html");
        }
     }

}
