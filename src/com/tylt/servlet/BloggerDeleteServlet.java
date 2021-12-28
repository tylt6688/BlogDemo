package com.tylt.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tylt.dao.BloggerDao;
import com.tylt.factory.DaoFactory;


public class BloggerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BloggerDeleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String searchType = request.getParameter("searchType");
		int searchPage = Integer.parseInt(request.getParameter("searchPage"));
	
		int id = Integer.parseInt(request.getParameter("id"));
		
		BloggerDao bd = DaoFactory.getBloggerDao();
		try {
			bd.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(searchType.equals("HomeServlet")){
			response.sendRedirect("HomeServlet?searchPage="+searchPage);
		}else if(searchType.equals("TopicServlet")){
			int topicId = Integer.parseInt(request.getParameter("topicId"));
			response.sendRedirect("TopicServlet?searchPage="+searchPage+"&topicId="+topicId);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
