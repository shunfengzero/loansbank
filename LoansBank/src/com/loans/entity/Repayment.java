package com.loans.entity;

/**
 * 计划还款表
 * @author Administrator
 *
 */
public class Repayment {
	
	private String userName; //用户名
	private Integer period;//周期
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	
	
	
}
