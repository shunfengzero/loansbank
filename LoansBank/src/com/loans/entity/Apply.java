package com.loans.entity;

/**
 * 贷款申请表
 * @author Administrator
 *
 */
public class Apply {
	
	private Integer id;
	private String userName; //用户登录名
	private String realName; //真实名
	private Integer limitMoney; //最高借款
	private String clazz; //贷款种类
	private String limitTime; //限制时间
	private String phone; //借款人电话
	private String address; //借款人所在省市
	private String status;//申请状态
	private String applyTime;//借款时间
	
	
	
	
	@Override
	public String toString() {
		return "Apply [id=" + id + ", userName=" + userName + ", limitMoney=" + limitMoney + ", clazz=" + clazz
				+ ", limitTime=" + limitTime + ", phone=" + phone + ", address=" + address + ", status=" + status + "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getLimitMoney() {
		return limitMoney;
	}
	public void setLimitMoney(Integer limitMoney) {
		this.limitMoney = limitMoney;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getLimitTime() {
		return limitTime;
	}
	public void setLimitTime(String limitTime) {
		this.limitTime = limitTime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	
	
	
}
