package io.spring.boot.employee.jdbc.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Employee {
	
	//If we need to show the user readable validations we can use JSR303 and JSR 309 annotation is used in validation
	
	int empId;
	@NotEmpty(message = "{e.fname.empty}")
	//@Size--length of the String or characters
	@Size( max=30,min=1, message="{e.fname.invalid}")
	String fname;
	String mname;
	String lname;
	@Min(value=12, message="{e.age.minvalue}")
	@Max(value=100, message="{e.age.maxvalue}")
	int age;
	static String uname="SNHU";
	@Email(message="{e.email.invalid}")
	String email;
	@NotNull(message="{e.password.empty}")
	String password;

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public  String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		Employee.uname = uname;
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
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String fname, String mname, String lname, int age, String email, String password) {
		super();
		this.empId = empId;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.age = age;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fname=" + fname + ", mname=" + mname + ", lname=" + lname + ", age="
				+ age + ", email=" + email + ", password=" + password + "]";
	}
	


}
