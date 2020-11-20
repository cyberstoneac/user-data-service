package com.webservice.userdataservice.model;

import java.io.Serializable;

public class UserData implements Serializable {

	private static final long serialVersionUID = 8972804317173347238L;

	private int userId;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + "]";
	}

}
