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


public class BloggerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BloggerUpdateServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Object userIdObject = session.getAttribute("USERID");
		int userId = (int) userIdObject;
		int id = Integer.parseInt(request.getParameter("id"));
		String bloggerTitle = request.getParameter("bloggerTitle");
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		String bloggerContent = request.getParameter("bloggerContent");
		
		
		Blogger b = new Blogger();
		b.setId(id);
		b.setBloggerContent(bloggerContent);
		b.setBloggerTitle(bloggerTitle);
		b.setCreateTime(System.currentTimeMillis());
		b.setTopicId(topicId);
		b.setUserId(userId);
		
		BloggerDao bd = DaoFactory.getBloggerDao();
		try {
			bd.update(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String searchType = request.getParameter("searchType");
		int searchPage = Integer.parseInt(request.getParameter("searchPage"));
		if(searchType.equals("HomeServlet")){
			response.sendRedirect("HomeServlet?searchPage="+searchPage);
		}else if(searchType.equals("TopicServlet")){
			int oldTopicId = Integer.parseInt(request.getParameter("oldTopicId"));
			response.sendRedirect("TopicServlet?searchPage="+searchPage+"&topicId="+oldTopicId);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
