package com.atm.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.dao.DatabaseDaoImpl;

/**
 * Servlet implementation class INBOX
 */
public class INBOX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public INBOX() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String cardNumber = (String) session.getAttribute("cardNumber");
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate date = currentTime.toLocalDate();
		Date date1 = Date.valueOf(date);
		
		DatabaseDaoImpl dbDao = new DatabaseDaoImpl();
		if(session!=null)
		{
			try {
				System.out.println("session is not null at inbox post");
				int otp = dbDao.printOtp(cardNumber , date1 );
				System.out.println("otp Attr set"+otp);
				//HttpSession session2=request.getSession(true);
				
				response.sendRedirect("otpDetails.jsp?otp='"+otp+"'");
				
				
//				session.setAttribute("otp", otp);
//				RequestDispatcher rd = request.getRequestDispatcher("otpDetails.jsp");
//				rd.forward(request, response);
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
