package com.atm.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.dao.DatabaseDaoImpl;
import com.atm.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String cardNumber=request.getParameter("cardNumber");
		DatabaseDaoImpl dbDao=new DatabaseDaoImpl();
		
		User users=dbDao.verifyCardNumber(cardNumber);
		System.out.println("get user obj at post Login");
		System.out.println(users);
		if(users!=null)
		{
			session.setAttribute("cardNumber", users.getAccountNo());
			session.setAttribute("pinNumber", users.getPinNo());
			System.out.println("Request send to pinvalidation.jsp");
			RequestDispatcher reqDis=request.getRequestDispatcher("pinvalidation.jsp");
			reqDis.forward(request, response);
		}
		else
		{
			System.out.println("Request redirect to index.jsp page");
			RequestDispatcher reqDis=request.getRequestDispatcher("index.jsp");
			reqDis.forward(request, response);
		}
	}

}
