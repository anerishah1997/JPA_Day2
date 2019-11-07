package com.lti.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.model.Users;
import com.lti.service.UserServiceImpl;

public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String mobilenumber = request.getParameter("mobilenumber");
		
		Users user = new Users(username, password, firstname, lastname, mobilenumber);
		UserServiceImpl service = new UserServiceImpl();
		boolean result = service.addUser(user);
		
		RequestDispatcher rd = request.getRequestDispatcher("showUsers.view");
		rd.forward(request, response);
	}

}
