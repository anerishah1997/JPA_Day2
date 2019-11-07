package com.lti.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.service.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =  request.getParameter("username");
		String password =  request.getParameter("password");
		
		UserServiceImpl service = new UserServiceImpl();
		boolean result = service.checkLogin(username, password);
		if(result){
			//response.sendRedirect("home.view");
			HttpSession session =  request.getSession(true);
			session.setAttribute("username", username);
			
			/*RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);*/
			response.sendRedirect("Home.jsp");
		}else{
			response.sendRedirect("Error.html");
		}
	}
}
