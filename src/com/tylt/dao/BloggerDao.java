package com.tylt.dao;

import java.sql.SQLException;
import java.util.List;

import com.tylt.model.Blogger;

public interface BloggerDao {

	public int selectAllCount() throws SQLException;

	public List<Blogger> selectAll() throws SQLException;

	public Blogger select(int id) throws SQLException;

	public Boolean insert(Blogger blogger) throws SQLException;

	public Boolean update(Blogger blogger) throws SQLException;

	public Boolean delete(int id) throws SQLException;

	public int selectCountByUserId(int userId) throws SQLException;

	public int selectCountByUserIdAndTopicId(int userId, int topicId) throws SQLException;

	public List<Blogger> selectAllByUserId(int userId, int start, int pageSize) throws SQLException;

	public List<Blogger> selectAllByUserIdAndTopicId(int userId, int topicId, int start, int pageSize)
			throws SQLException;


}
