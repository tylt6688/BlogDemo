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

public class TopicToDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TopicToDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		TopicDao td = DaoFactory.getTopicDao();
		try {
			td.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("deleted",td);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/TopicListServlet");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
