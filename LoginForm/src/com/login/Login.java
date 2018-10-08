package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Login() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In post");
		HttpSession session = request.getSession(false);
		
		if(session!= null)
		{
			session.invalidate();
			response.sendRedirect("Welcome.jsp");
		}
		
	}

}
