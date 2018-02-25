package com.loans.entity;


/**
 * 登录
 * 	用户名
 *	密码
 *	权限
 * @author shunfeng
 *
 */
public class Login {
	
	private String userName; //用户名
	private String passWord; //密码
	private Integer role; //权限
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	
}
