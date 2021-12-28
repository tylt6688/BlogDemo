package com.tylt.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Blogger {

	private int id;
	private int userId;
	private int topicId;
	private String bloggerTitle;
	private String bloggerContent;
	private long createTime;

	@Override
	public String toString() {
		return "Blogger [id=" + id + ", userId=" + userId + ", topicId=" + topicId + ", bloggerTitle=" + bloggerTitle
				+ ", bloggerContent=" + bloggerContent + ", createTime=" + createTime + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getBloggerTitle() {
		return bloggerTitle;
	}

	public void setBloggerTitle(String bloggerTitle) {
		this.bloggerTitle = bloggerTitle;
	}

	public String getBloggerContent() {
		return bloggerContent;
	}

	public void setBloggerContent(String bloggerContent) {
		this.bloggerContent = bloggerContent;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeStr() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(createTime);
		return sdf.format(date);
	}

}
