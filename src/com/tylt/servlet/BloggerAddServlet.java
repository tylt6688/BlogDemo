package com.tylt.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tylt.dao.BloggerDao;
import com.tylt.factory.DaoFactory;
import com.tylt.model.Blogger;


public class BloggerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BloggerAddServlet() {
        super();
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Object userIdObject = session.getAttribute("USERID");
		int userId = (int) userIdObject;
		String bloggerTitle = request.getParameter("bloggerTitle");
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		String bloggerContent = request.getParameter("bloggerContent");
		
		
		Blogger b = new Blogger();
		b.setBloggerContent(bloggerContent);
		b.setBloggerTitle(bloggerTitle);
		b.setCreateTime(System.currentTimeMillis());
		b.setTopicId(topicId);
		b.setUserId(userId);
		
		BloggerDao bd = DaoFactory.getBloggerDao();
		try {
			bd.insert(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("HomeServlet");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
