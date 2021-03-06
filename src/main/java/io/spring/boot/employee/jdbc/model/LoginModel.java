package io.spring.boot.employee.jdbc.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;



public class LoginModel {
	@NotNull
	@Email
	private String email;
	@NotNull
	private String password;
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
	public LoginModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginModel [email=" + email + ", password=" + password + "]";
	}
	
	
	
}
