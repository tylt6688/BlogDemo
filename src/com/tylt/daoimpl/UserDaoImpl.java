package com.tylt.daoimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.tylt.dao.UserDao;
import com.tylt.model.User;
import com.tylt.utils.C3p0Utils;

public class UserDaoImpl implements UserDao{
	
	public int selectAllCount() throws SQLException {
		
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select count(*) from _user";
		Long count = (Long) runner.query(sql, new ScalarHandler());
		return count.intValue();
	}
	
	public List<User> selectAll() throws SQLException {

		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from _user";
		return (List) runner.query(sql, new BeanListHandler(User.class));
	}

	public User select(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from _user where id=?";
		Object[] params = new Object[] { id };
		return (User) runner.query(sql, new BeanHandler(User.class), params);
	}
	
	public User selectByUserName(String userName) throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from _user where userName=?";
		Object[] params = new Object[] { userName };
		return (User) runner.query(sql, new BeanHandler(User.class), params);
	}
	

	public Boolean insert(User user) throws SQLException {

		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into _user(userName,password,nickName) values (?,?,?)";
		Object[] params = new Object[] { user.getUserName(), user.getPassword(), user.getNickName() };
		Object insert = runner.insert(sql, new ScalarHandler(), params);
		Long insertRs = (Long) insert;
		user.setId(insertRs.intValue());

		return true;
	}

	public Boolean update(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update _user set userName=?,password=?,nickName=? where id=?";
		Object[] params = new Object[] { user.getUserName(),user.getPassword(),user.getNickName(),
				user.getId() };
		int num = runner.update(sql, params);
		return num > 0;
	}

	public Boolean delete(int id) throws SQLException {

		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "delete from _user where id=?";
		int num = runner.update(sql, id);
		return num > 0;
	}
}
