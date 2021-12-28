package com.tylt.daoimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.tylt.dao.TopicDao;
import com.tylt.model.Topic;
import com.tylt.utils.C3p0Utils;

public class TopicDaoImpl implements TopicDao{

	
	public int selectAllCount() throws SQLException {
		
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select count(*) from _topic";
		Long count = (Long) runner.query(sql, new ScalarHandler());
		return count.intValue();
	}
	
	public List<Topic> selectAll() throws SQLException {

		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from _topic";
		return (List) runner.query(sql, new BeanListHandler(Topic.class));
	}
	
	public List<Topic> selectAllByUserId(int userId) throws SQLException {

		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from _topic where userId=? order by indexed";
		Object[] params = new Object[] { userId };
		return (List) runner.query(sql, new BeanListHandler(Topic.class),params);
	}
	
	public List<Topic> selectAllByUserIdWithoutDeleted(int userId) throws SQLException {

		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from _topic where userId=? and deleted=0 order by indexed";
		Object[] params = new Object[] { userId };
		return (List) runner.query(sql, new BeanListHandler(Topic.class),params);
	}

	public Topic select(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from _topic where id=?";
		Object[] params = new Object[] { id };
		return (Topic) runner.query(sql, new BeanHandler(Topic.class), params);
	}

	public Boolean insert(Topic topic) throws SQLException {

		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into _topic(userId,name,indexed,deleted) values (?,?,?,?)";
		Object[] params = new Object[] { topic.getUserId(), topic.getName(), topic.getIndexed(), topic.isDeleted() };
		Object insert = runner.insert(sql, new ScalarHandler(), params);
		Long insertRs = (Long) insert;
		topic.setId(insertRs.intValue());

		return true;
	}

	public Boolean update(Topic topic) throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update _topic set userId=?,name=?,indexed=?,deleted=? where id=?";
		Object[] params = new Object[] { topic.getUserId(), topic.getName(), topic.getIndexed(), topic.isDeleted(),
				topic.getId() };
		int num = runner.update(sql, params);
		return num > 0;
	}

	public Boolean delete(int id) throws SQLException {

		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "delete from _topic where id=?";
		int num = runner.update(sql, id);
		return num > 0;
	}
}
