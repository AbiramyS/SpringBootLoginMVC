package io.spring.boot.employee.jdbc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.spring.boot.employee.jdbc.impl.EmployeeImpl;
import io.spring.boot.employee.jdbc.model.Employee;

@RestController
public class LoginController {
	@Autowired
	private EmployeeImpl employeeImpl;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	
	/*
	 * Home URLSSS 
	 */
	@GetMapping("/home")
	public ModelAndView homePage() {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	//store the employee in the session
	public void storedLoginEmployee() {
		HttpSession session= request.getSession();
		Employee employee=new Employee();
		//we can get the session on JSP ${EMPLOYEESESSION}
		session.setAttribute("EMPLOYEESESSION", employee);		
	}
	
	//get the employee information from the session
	public Employee getStoredLoginEmployee() {
		HttpSession session=request.getSession(false);
		Employee employee=(Employee) session.getAttribute("EMPLOYEESESSION");
		return employee;
	}
	
	//store info in cookie
	public void makeCookieForEmployee() {
		Employee employee=new Employee();
		 Cookie ck=new Cookie("COOKIE", "employee");
		 ck.setMaxAge(60*60);
		 response.addCookie(ck);	
	}
	
	public void getCookie() {
		Cookie ck[]= request.getCookies();
		if(ck !=null) {
			for(Cookie cookie: ck) {
			 System.out.println(ck[0].getValue());
		}
	}
	}
		
		// Delete cookie.
	    public void deleteCookie() {
	        Cookie cookieRemove = new Cookie("COOKIE", "");
	        // 0 seconds (This cookie will expire immediately)
	        cookieRemove.setMaxAge(0);
	        response.addCookie(cookieRemove);
	    }
	}



