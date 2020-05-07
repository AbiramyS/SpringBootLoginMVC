package io.spring.boot.employee.jdbc;

import java.util.List;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int empId);
	public int saveEmployee(Employee e);
	public int deleteEmployee(int id);
	public int updateEmployee(Employee e);
	public Employee getAnEmployee(int empId, String fname, String lname);


}
