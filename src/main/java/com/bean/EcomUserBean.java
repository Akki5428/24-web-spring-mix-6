package com.bean;

import org.springframework.web.multipart.MultipartFile;

public class EcomUserBean {
	private int userId;
	private String firstName;
	private String email;
	private String password;
	private MultipartFile profilepic;
	private String masterpath;
	
	public MultipartFile getProfilepic() {
		return profilepic;
	}
	public void setProfilepic(MultipartFile profilepic) {
		this.profilepic = profilepic;
	}
	public String getMasterpath() {
		return masterpath;
	}
	public void setMasterpath(String masterpath) {
		this.masterpath = masterpath;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
