package com.tylt.factory;

import com.tylt.dao.BloggerDao;
import com.tylt.dao.TopicDao;
import com.tylt.dao.UserDao;
import com.tylt.daoimpl.BloggerDaoImpl;
import com.tylt.daoimpl.TopicDaoImpl;
import com.tylt.daoimpl.UserDaoImpl;

public class DaoFactory {

	private static UserDao ud = null;
	private static TopicDao td = null;
	private static BloggerDao bd = null;
	
	public synchronized static UserDao getUserDao(){
		if(ud == null){
			ud = new UserDaoImpl();
		}
		return ud;
	}
	
	public synchronized static TopicDao getTopicDao(){
		if(td == null){
			td = new TopicDaoImpl();
		}
		return td;
	}
	
	public synchronized static BloggerDao getBloggerDao(){
		if(bd == null){
			bd = new BloggerDaoImpl();
		}
		return bd;
	}
	
}
