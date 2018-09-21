package com.atm.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.dao.DatabaseDaoImpl;


public class PhoneNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PhoneNumber() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		DatabaseDaoImpl dbDao = new DatabaseDaoImpl();
		if(session!= null)
		{
			String cardNumber = (String) session.getAttribute("cardNumber");
			int otp= Integer.parseInt(request.getParameter("otp"));
			
			try {
				if(dbDao.checkOtp(cardNumber, otp ))
				{
					System.out.println("redirecting to number.jsp");
					response.sendRedirect("number.jsp");
				}
				
				else
				{
					response.sendRedirect("changePhoneNumber.jsp");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
			response.sendRedirect("index.jsp");
	}

}
