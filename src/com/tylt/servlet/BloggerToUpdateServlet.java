package com.tylt.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tylt.dao.TopicDao;
import com.tylt.factory.DaoFactory;
import com.tylt.model.Blogger;
import com.tylt.model.Topic;

public class BloggerToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BloggerToUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("searchType", request.getParameter("searchType"));
		request.setAttribute("searchPage", request.getParameter("searchPage"));
		request.setAttribute("topicId", request.getParameter("topicId"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		Blogger b = null;
		try {
			b = DaoFactory.getBloggerDao().select(id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		request.setAttribute("blogger", b);
		
		HttpSession session = request.getSession();
		Object userIdObject = session.getAttribute("USERID");
		int userId = (int) userIdObject;

		TopicDao td = DaoFactory.getTopicDao();
		
		try {
			List<Topic> topicList = td.selectAllByUserIdWithoutDeleted(userId);
			request.setAttribute("topicList", topicList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/bloggerUpdate.jsp");
		dispatcher.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
