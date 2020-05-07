package io.spring.boot.employee.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeImpl implements EmployeeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Override
	public List<Employee> getAllEmployee() {
		String sql="select * from employee";
		return jdbcTemplate.query(sql, new EmployeeRowMapper());		
	}

	@Override
	public Employee getEmployeeById(int empId) {
		String query = "select * from employee where empId=?";
		return jdbcTemplate.queryForObject(query, new EmployeeRowMapper(), empId);
	}
	
	@Override
	public int saveEmployee(Employee e) {
		String query = "insert into employee values('" + e.getEmpId() + "','" + e.getFname() + "','" + e.getMname()
				+ "','" + e.getLname() + "','" + e.getAge() + "','" + e.getEmail() + "','" + e.getPassword() + "')";
		System.out.println(query);
		return jdbcTemplate.update(query);
	}

	@Override
	public int deleteEmployee(int empId) {
		String query = "delete from employee where empId=?";
		return jdbcTemplate.update(query, empId);
	}

	@Override
	public int updateEmployee(Employee e) {
		String query = "update employee set fname= '" + e.getFname() + "', mname= '" + e.getMname() + "', lname= '"
				+ e.getLname() + "', age= '" + e.getAge() +"','" + e.getEmail() + "','" + e.getPassword() + "' where empId=  '"+ e.getEmpId()+"' ";
		return jdbcTemplate.update(query);
	}
	
	@Override
	public Employee getAnEmployee(int empId, String fname, String lname) {
		String sql= "select * from employee where empId=? and fname=? and lname=?";
		return jdbcTemplate.queryForObject(sql,new EmployeeRowMapper(), empId, fname,lname);
	}	

}
 class EmployeeRowMapper implements RowMapper<Employee> {
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee e=new Employee();
		e.setEmpId(rs.getInt("empId"));
		e.setFname(rs.getString("fname"));
		e.setMname(rs.getString("mname"));
		e.setLname(rs.getString("lname"));
		e.setAge(rs.getInt("age"));
		e.setEmail(rs.getString("email"));
		e.setPassword(rs.getString("password"));
		return e;	
}
}
	 
 
 
