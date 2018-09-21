package com.atm.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.dao.DatabaseDaoImpl;


public class checkPin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public checkPin() {
        super();
        
    }

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		DatabaseDaoImpl dbDao = new DatabaseDaoImpl();
		if(session!=null)
		{
			System.out.println("session is not null at doPost checkpin");
			String cardNumber = (String) session.getAttribute("cardNumber");
			
			
			
			int pin =Integer.parseInt(request.getParameter("pin"));
			
			String pinAsString = request.getParameter("pinNo");
			String pinAsString2 = request.getParameter("newPinAgain");
			int pinNo =0;
			int newPinAgain =0;
			
			if(pinAsString.length()==4)
			{
				 pinNo =Integer.parseInt(pinAsString);
			}
			
			if(pinAsString2.length()==4)
			{
				 newPinAgain =Integer.parseInt(pinAsString2);
			}
			
			
			try {
				if(dbDao.isPinValid(pin ,cardNumber))
				{
					
					System.out.println("pin is valid");
					//boolean status =false;
					if(pinNo== newPinAgain)
					{
						int isUpdated=dbDao.changePin(pinNo, cardNumber);
						if(isUpdated!=0)
						{
							System.out.println("Successfuly pin display");
							response.sendRedirect("changePin.jsp");	
						}
						else
						{
							response.sendRedirect("Pin.jsp");
						}
						
					}
					
					else
					{
						response.sendRedirect("Pin.jsp");
					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
