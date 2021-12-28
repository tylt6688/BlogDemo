package com.tylt.daoimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.tylt.dao.BloggerDao;
import com.tylt.model.Blogger;
import com.tylt.utils.C3p0Utils;

public class BloggerDaoImpl implements BloggerDao{

	public int selectAllCount() throws SQLException {

		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select count(*) from _blogger";
		Long count = (Long) runner.query(sql, new ScalarHandler());
		return count.intValue();
	}

	public List<Blogger> selectAll() throws SQLException {

		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from _blogger";
		return (List) runner.query(sql, new BeanListHandler(Blogger.class));
	}

	public Blogger select(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from _blogger where id=?";
		Object[] params = new Object[] { id };
		return (Blogger) runner.query(sql, new BeanHandler(Blogger.class), params);
	}

	public Boolean insert(Blogger blogger) throws SQLException {

		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into _blogger(userId,topicId,bloggerTitle,bloggerContent,createTime) values (?,?,?,?,?)";
		Object[] params = new Object[] { blogger.getUserId(), blogger.getTopicId(), blogger.getBloggerTitle(),
				blogger.getBloggerContent(), blogger.getCreateTime() };
		Object insert = runner.insert(sql, new ScalarHandler(), params);
		Long insertRs = (Long) insert;
		blogger.setId(insertRs.intValue());

		return true;
	}

	public Boolean update(Blogger blogger) throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update _blogger set userId=?,topicId=?,bloggerTitle=?,bloggerContent=?,createTime=? where id=?";
		Object[] params = new Object[] { blogger.getUserId(), blogger.getTopicId(), blogger.getBloggerTitle(),
				blogger.getBloggerContent(), blogger.getCreateTime(), blogger.getId() };
		int num = runner.update(sql, params);
		return num > 0;
	}

	public Boolean delete(int id) throws SQLException {

		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "delete from _blogger where id=?";
		int num = runner.update(sql, id);
		return num > 0;
	}

	@Override
	public List<Blogger> selectAllByUserId(int userId, int start, int pageSize) throws SQLException {
		
		
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from _blogger where userId=? order by createTime desc limit ?,?";
		Object[] params = new Object[] {userId,start,pageSize};
		return (List) runner.query(sql, new BeanListHandler(Blogger.class),params);
	}

	@Override
	public int selectCountByUserId(int userId) throws SQLException {
		
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select count(*) from _blogger where userId=?";
		Object[] params = new Object[]{userId};
		Long count = (Long) runner.query(sql, new ScalarHandler(),params);
		return count.intValue();
	}
	
	
	@Override
	public int selectCountByUserIdAndTopicId(int userId,int topicId) throws SQLException {
		
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select count(*) from _blogger where userId=? and topicId=?";
		Object[] params = new Object[]{userId,topicId};
		Long count = (Long) runner.query(sql, new ScalarHandler(),params);
		return count.intValue();
	}
	@Override
	public List<Blogger> selectAllByUserIdAndTopicId(int userId,int topicId,int start, int pageSize) throws SQLException {
		
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from _blogger where userId=? and topicId=? order by createTime desc limit ?,?";
		Object[] params = new Object[] {userId,topicId,start,pageSize};
		return (List) runner.query(sql, new BeanListHandler(Blogger.class),params);
	}
}
