package com.tylt.dao;

import java.sql.SQLException;
import java.util.List;

import com.tylt.model.Topic;

public interface TopicDao {

	public int selectAllCount() throws SQLException;	
	public List<Topic> selectAll() throws SQLException;
	public List<Topic> selectAllByUserId(int userId) throws SQLException;
	public List<Topic> selectAllByUserIdWithoutDeleted(int userId) throws SQLException;
	public Topic select(int id) throws SQLException;
	public Boolean insert(Topic topic) throws SQLException ;
	public Boolean update(Topic topic) throws SQLException;
	public Boolean delete(int id) throws SQLException;
}
