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


public class TopicServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		Object userIdObject = session.getAttribute("USERID");

		int userId = (int) userIdObject;
		int topicId = Integer.parseInt(request.getParameter("topicId"));
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
			
			List<Blogger> bloggerList = bd.selectAllByUserIdAndTopicId(userId, topicId, 10*(searchPage-1), 10);
			request.setAttribute("bloggerList", bloggerList);
		
			int bloggerCount = bd.selectCountByUserIdAndTopicId(userId,topicId);
			
			int totalPage = bloggerCount / 10;
			if(bloggerCount % 10 != 0){
				totalPage += 1;
			}
			
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCount", bloggerCount);
			request.setAttribute("searchPage", searchPage);
			request.setAttribute("searchType", "TopicServlet");
			request.setAttribute("topicId", topicId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
		
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
