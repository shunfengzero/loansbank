package com.loans.entity;

public class HistoryBill {
	
	private Integer historyBillId;//id
	private String money;//金额
	private String borrowPerson;//借款人
	private String returnPerson;//贷款人
	private String timeStamp; //时间
	public Integer getHistoryBillId() {
		return historyBillId;
	}
	public void setHistoryBillId(Integer historyBillId) {
		this.historyBillId = historyBillId;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getBorrowPerson() {
		return borrowPerson;
	}
	public void setBorrowPerson(String borrowPerson) {
		this.borrowPerson = borrowPerson;
	}
	public String getReturnPerson() {
		return returnPerson;
	}
	public void setReturnPerson(String returnPerson) {
		this.returnPerson = returnPerson;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
}
