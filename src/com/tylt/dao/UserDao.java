package com.tylt.dao;

import java.sql.SQLException;
import java.util.List;

import com.tylt.model.User;

public interface UserDao {

	public int selectAllCount() throws SQLException;

	public List<User> selectAll() throws SQLException;

	public User select(int id) throws SQLException;

	public User selectByUserName(String userName) throws SQLException;

	public Boolean insert(User user) throws SQLException;

	public Boolean update(User user) throws SQLException;

	public Boolean delete(int id) throws SQLException;
}