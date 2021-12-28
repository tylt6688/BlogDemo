package com.tylt.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tylt.dao.TopicDao;
import com.tylt.factory.DaoFactory;
import com.tylt.model.Topic;

public class TopicToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TopicToUpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Topic c = null;
		TopicDao td = DaoFactory.getTopicDao();
		try {
			c = td.select(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("topic", c);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/topicUpdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
