package com.tylt.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tylt.dao.TopicDao;
import com.tylt.factory.DaoFactory;
import com.tylt.model.Topic;

public class TopicAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TopicAddServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Object userIdObject = session.getAttribute("USERID");
		int userId = (int) userIdObject;
		String name = request.getParameter("name");
		int indexed = Integer.parseInt(request.getParameter("indexed"));
		boolean deleted = request.getParameter("deleted") != null;
		
		Topic t = new Topic();
		t.setUserId(userId);
		t.setName(name);
		t.setDeleted(deleted);
		t.setIndexed(indexed);
		
		TopicDao td = DaoFactory.getTopicDao();
		try {
			td.insert(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("TopicListServlet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
