package com.atm.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.dao.DatabaseDaoImpl;

/**
 * Servlet implementation class Number
 */
public class Number extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Number() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		DatabaseDaoImpl dbDao = new DatabaseDaoImpl();
		if(session!= null)
		{
			String cardNumber = (String) session.getAttribute("cardNumber");
			String number= request.getParameter("number");
			Long number1= (long) 0;
			if(number.length()==10)
			{
				 number1 = Long.parseLong(number);
			}
			System.out.println("session is not null: in do post of Number.java");
			try {
				if(dbDao.changePhoneNumber(cardNumber ,number1))
				{
					response.sendRedirect("phoneNumberChange.jsp");
				}
				
				else{
					response.sendRedirect("changePhoneNumber.jsp");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
	}

}
