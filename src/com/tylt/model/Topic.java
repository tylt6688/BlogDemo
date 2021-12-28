package com.tylt.model;

public class Topic {

	private int id;
	private int userId;
	private String name;
	private int indexed;
	private boolean deleted;

	@Override
	public String toString() {
		return "Topic [id=" + id + ", userId=" + userId + ", name=" + name + ", indexed=" + indexed + ", deleted="
				+ deleted + "]";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndexed() {
		return indexed;
	}

	public void setIndexed(int indexed) {
		this.indexed = indexed;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public String getDeletedStr() {
		if (this.deleted) {
			return "ÊÇ";
		} else {
			return "·ñ";
		}
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
