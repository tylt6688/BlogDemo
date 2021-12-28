package com.tylt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tylt.dao.BloggerDao;
import com.tylt.dao.TopicDao;
import com.tylt.factory.DaoFactory;
import com.tylt.model.Blogger;
import com.tylt.model.Topic;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HomeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Object userIdObject = session.getAttribute("USERID");
		int userId = (int) userIdObject;
		
		int searchPage = 1;
		try {
			searchPage = Integer.parseInt(request.getParameter("searchPage"));
		} catch (Exception e) {
		}
		TopicDao td = DaoFactory.getTopicDao();
		BloggerDao bd = DaoFactory.getBloggerDao();
		
		try {
			List<Topic> topicList = td.selectAllByUserIdWithoutDeleted(userId);
			request.setAttribute("topicList", topicList);
			
			List<Blogger> bloggerList = bd.selectAllByUserId(userId, 10*(searchPage-1), 10);
			request.setAttribute("bloggerList", bloggerList);
		
			
			int bloggerCount = bd.selectCountByUserId(userId);
			int totalPage = bloggerCount / 10;
			if(bloggerCount % 10 != 0){
				totalPage += 1;
			}
			
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCount", bloggerCount);
			request.setAttribute("searchPage", searchPage);
			request.setAttribute("searchType", "HomeServlet");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		
		dispatcher.forward(request, response);
	}

}
