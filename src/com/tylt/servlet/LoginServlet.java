package com.tylt.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tylt.dao.UserDao;
import com.tylt.factory.DaoFactory;
import com.tylt.model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String imageText = request.getParameter("image");

		// Õº∆¨—È÷§¬Î
		String text = (String) request.getSession().getAttribute("text");

		if (!text.equalsIgnoreCase(imageText)) {
			request.setAttribute("imageMess", "—È÷§¬Î ‰»Î¥ÌŒÛ!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		boolean success = false;
		UserDao ud = DaoFactory.getUserDao();
		User u = null;
		try {
			u = ud.selectByUserName(userName);
			if (u != null && u.getPassword().equals(password.trim())) {
				success = true;
			}
		} catch (SQLException e) {

		}

		if (success) {
			HttpSession session = request.getSession();
			session.setAttribute("USERID", u.getId());
			session.setAttribute("USERNICKNAME", u.getNickName());
			response.sendRedirect("HomeServlet");
		} else {
			request.setAttribute("error", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
