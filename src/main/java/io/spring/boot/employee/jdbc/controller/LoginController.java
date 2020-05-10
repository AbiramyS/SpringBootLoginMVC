package io.spring.boot.employee.jdbc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.spring.boot.employee.jdbc.impl.EmployeeImpl;

@RestController
public class LoginController {
	@Autowired
	private EmployeeImpl employeeImpl;
	@Autowired
	HttpServletRequest request;
	
	/*
	 * Home URL
	 */
	@GetMapping("/home")
	public ModelAndView homePage() {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}

}
