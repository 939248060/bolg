package com.yungame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String username;
	
	private String password;
	
	private Integer jurisdiction; //0 管理员    1 普通用户
	
	private String motto; //座右铭
	
	private Integer integral; //积分
	
	private String tel;
	
	private Integer sex;
	
	private String mail;
	
	private String job;
	
	private String address;
	
	private String inetName;//网名
	
	private String headUrl;//头像

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(Integer jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInetName() {
		return inetName;
	}

	public void setInetName(String inetName) {
		this.inetName = inetName;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", jurisdiction="
				+ jurisdiction + ", motto=" + motto + ", integral=" + integral + ", tel=" + tel + ", sex=" + sex
				+ ", mail=" + mail + ", job=" + job + ", address=" + address + ", inetName=" + inetName + ", headUrl="
				+ headUrl + "]";
	}
	
	
	
}
