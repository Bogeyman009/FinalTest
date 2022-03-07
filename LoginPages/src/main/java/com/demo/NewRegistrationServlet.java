package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewRegistrationServlet
 */
@WebServlet("/register")
public class NewRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logindao logindao;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("email");
        String password = request.getParameter("pass");
        
        LoginBean login=new LoginBean();
        login.setUsername(username);
        login.setPassword(password);
        
        registerDao reg=new registerDao();
        String result=reg.insert(login);
        
        response.getWriter().print(result);
        
        
        
	}

}
