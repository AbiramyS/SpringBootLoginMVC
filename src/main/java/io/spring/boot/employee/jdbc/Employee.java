package io.spring.boot.employee.jdbc;

public class Employee {
	
	int empId;
	String fname;
	String mname;
	String lname;
	int age;
	static String uname="SNHU";
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
	public static String getUname() {
		return uname;
	}
	public static void setUname(String uname) {
		Employee.uname = uname;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String fname, String mname, String lname, int age) {
		super();
		this.empId = empId;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fname=" + fname + ", mname=" + mname + ", lname=" + lname + ", age="
				+ age + "]";
	}


}
