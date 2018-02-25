package com.loans.entity;

/**
 * 利率表
 * @author Administrator
 *
 */
public class Interest {
	
	private Double iDay; //日利率
	private Double iMonth; //月利率
	private Double iYear; //年利率
	public Double getiDay() {
		return iDay;
	}
	public void setiDay(Double iDay) {
		this.iDay = iDay;
	}
	public Double getiMonth() {
		return iMonth;
	}
	public void setiMonth(Double iMonth) {
		this.iMonth = iMonth;
	}
	public Double getiYear() {
		return iYear;
	}
	public void setiYear(Double iYear) {
		this.iYear = iYear;
	}
	
	
}
