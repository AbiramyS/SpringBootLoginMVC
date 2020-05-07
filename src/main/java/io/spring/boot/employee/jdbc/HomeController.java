package io.spring.boot.employee.jdbc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public ModelAndView viewHome() {
		return new ModelAndView("home", "view Home page", "view Model Object");	
	}

}
