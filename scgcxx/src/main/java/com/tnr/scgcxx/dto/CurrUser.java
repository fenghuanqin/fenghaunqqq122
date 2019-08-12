package com.tnr.scgcxx.dto;
/**
 * 目的为了封装当前用户
 * @author Administrator
 *
 */
public class CurrUser {
	
	private String userId;
	private String userName;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "CurrUser [userId=" + userId + ", userName=" + userName + "]";
	}
	
	

}
