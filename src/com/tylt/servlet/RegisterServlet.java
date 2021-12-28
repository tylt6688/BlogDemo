package com.tylt.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tylt.dao.UserDao;
import com.tylt.factory.DaoFactory;
import com.tylt.model.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String Username = request.getParameter("UserName");
		String Password = request.getParameter("Password");

		User u = new User();
		u.setUserName(Username);
		u.setPassword(Password);
		System.out.println(Username+" "+Password);
		UserDao ud = DaoFactory.getUserDao();
		try {
			ud.insert(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("welcome.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
