package com.loans.entity;


/**
 * 用户注册
 * @author Administrator
 *
 */
public class Users {
	private Integer id; //id
	private String userName; //用户名
	private String passWord; //密码
	private String realName; //真实姓名
	private String gender; //性别
	private String email; //邮箱
	private String telePhone; //电话
	private String address; //家庭地址
	private String introduce; //介绍
	private String activeCode; //激活码
	private Integer state; //状态码
	private String role; //权限
	private String registTime; //注册时间
	
	private String idType;//证件类型
	private String idNumber;//证件号码
	private String idImg;//证件路径
	private String addressWork;//工作单位
	private String bankType;//绑定银行卡类型
	private String bankNumber;//绑定银行卡号
	private String accountBalance; //账户余额
	
	
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getIdImg() {
		return idImg;
	}
	public void setIdImg(String idImg) {
		this.idImg = idImg;
	}
	public String getAddressWork() {
		return addressWork;
	}
	public void setAddressWork(String addressWork) {
		this.addressWork = addressWork;
	}
	public String getBankType() {
		return bankType;
	}
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	public String getBankNumber() {
		return bankNumber;
	}
	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
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
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getActiveCode() {
		return activeCode;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRegistTime() {
		return registTime;
	}
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	
}
