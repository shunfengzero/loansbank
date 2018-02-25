package com.loans.entity;

/**
 * 投资表
 * @author Administrator
 *
 */
public class Invest {
	private Integer id;
	private String userName; //用户名
	private String iMoney; //投资金额
	private String investTime; //投资时间
	private String investDate;//投资日期
	private String investMethod;//投资方式
	private String withDrawMethod;//提现方式
	private String investstatus;//投资状态
	
		
	public String getInveststatus() {
		return investstatus;
	}
	public void setInveststatus(String investstatus) {
		this.investstatus = investstatus;
	}
	public String getInvestMethod() {
		return investMethod;
	}
	public void setInvestMethod(String investMethod) {
		this.investMethod = investMethod;
	}
	public String getWithDrawMethod() {
		return withDrawMethod;
	}
	public void setWithDrawMethod(String withDrawMethod) {
		this.withDrawMethod = withDrawMethod;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getiMoney() {
		return iMoney;
	}
	public void setiMoney(String iMoney) {
		this.iMoney = iMoney;
	}
	public String getInvestTime() {
		return investTime;
	}
	public void setInvestTime(String investTime) {
		this.investTime = investTime;
	}
	public String getInvestDate() {
		return investDate;
	}
	public void setInvestDate(String investDate) {
		this.investDate = investDate;
	}
	
	
	
}
