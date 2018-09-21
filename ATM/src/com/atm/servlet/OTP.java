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
 * Servlet implementation class OTP
 */
public class OTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public OTP() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		DatabaseDaoImpl dbDao= new DatabaseDaoImpl();
		if(session!=null)
		{
			System.out.println("session is not null");
			String cardNumber = (String) session.getAttribute("cardNumber");
			int otp = dbDao.getOtp();
			System.out.println("Otp got");
			System.out.println(otp);
			
			try {
				if(otp>0)
				{
					if(dbDao.updatePinTable(cardNumber,otp))
					{
						System.out.println("table Updated");
						response.sendRedirect("changePhoneNumber.jsp");
					}
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
