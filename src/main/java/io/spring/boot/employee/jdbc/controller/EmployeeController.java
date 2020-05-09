package io.spring.boot.employee.jdbc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.spring.boot.employee.jdbc.custom.editor.binder.EmployeeCustomEditor;
import io.spring.boot.employee.jdbc.impl.EmployeeImpl;
import io.spring.boot.employee.jdbc.model.Employee;
import io.spring.boot.employee.jdbc.model.LoginModel;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeImpl employeeImpl;
	

	@GetMapping("/home")
	public ModelAndView viewHome() {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	
	@GetMapping("/empForm")
	public ModelAndView viewEmployeeForm() {
		ModelAndView mv=new ModelAndView("empForm");
		Employee e=new Employee();
		mv.addObject("e", e);
		return mv;
	}
	
	//While using spring form tag we need to use the @ModelAttribute
	//If we are binding data with the normal form we need to use the @RequestParam
	
	//Before updating or saving the data in the database we have to validate the data ---so we are using BindingResult
	//BindingResult helps to show the errors in the jsp page
	
	@PostMapping("/empForm")
	public ModelAndView handleRegistration(@Valid @ModelAttribute("e") Employee e, BindingResult result) {
		ModelAndView mv=new ModelAndView();
		System.out.println(result);
		if(result.hasErrors()) {
			mv.setViewName("empForm");
		}
		else {
			int status=employeeImpl.saveEmployee(e);
			if(status>0) {
				System.out.println("successfully inserted");
				mv.setViewName("redirect:login");
				
			}else {
				mv.setViewName("empForm");
			}
		}
		return mv;
	}
	
	//With out using the form tags for creating the jsp form in the spring
	//how to create the handleRegistration
	
	/*
	 * 	@PostMapping("/empForm")
		public ModelAndView handleRegistration(@RequestParam("empId") int empId, @RequestParam("fname") String fname,@RequestParam("mname") String lname,
		@RequestParam("age") int age, @RequestParam("uname") String uname, @RequestParam("email") String email,@RequestParam("password") String password,) {
		Employee e=new Employee(empId, fname, mname, lname, age, uname, email, password);
		int status=employeeImpl.saveEmployee(e);
		ModelAndView mv=new ModelAndView();//mv.addObject("e", e);
		if(status>0) {
			System.out.println("successfully inserted");
			mv.setViewName("redirect:login");
		}else {
			mv.setViewName("empForm");
		}
		return mv;
	}
	 * 
	 * 
	 */
	
	@GetMapping("/login")
	public ModelAndView employeeLogin() {
		ModelAndView mv=new ModelAndView("login");
		mv.addObject("loginModel", new LoginModel());
		return mv;
	}
	

	@PostMapping("/login")
	public ModelAndView employeeLoginSuccess(@Valid @ModelAttribute("loginModel") LoginModel loginModel, BindingResult result) {
		ModelAndView mv=new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("redirect:home");
		}else {
			System.out.println("redicting");
			mv.setViewName("redirect:empView");
		}
		return mv;
	}
	
    /*It saves object into database. The @ModelAttribute puts request data  
     *  into model object. You need to mention RequestMethod.POST method or PostMapping  
     *  because default request is GET */ 
	@PostMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute("e") Employee e) {
		employeeImpl.saveEmployee(e);
		ModelAndView mv=new ModelAndView("redirect:/empView");
		return mv;
	}
	
	@GetMapping("/empView")
	public ModelAndView getAllEmployee() {
		ModelAndView mv=new ModelAndView("empView");
		System.out.println("inside empView GetMapping "+mv.getViewName());
		List<Employee> list=employeeImpl.getAllEmployee();
		mv.addObject("list", list);
		return mv;
	}

	
	@GetMapping("/empView/{empId}")
	public ModelAndView edit(@PathVariable int empId, Model m) {
		Employee e=employeeImpl.getEmployeeById(empId);
		ModelAndView mv =new ModelAndView("empEdit");
		m.addAttribute("command", e);
		return mv;
	}
	
	@GetMapping("/empView/{empId}/{fname}")
	public ModelAndView pathVariableExam(@PathVariable("empId") int empId, @PathVariable("fname") String fname, @RequestParam("lname") String lname) {
		return new ModelAndView("home", "welcome message", "hello "+empId+" you are "+fname+" lastname "+lname+ "");
	}

	
	//@RequestParam is used to collect the query param----we need to type it as 
	//http://localhost/8080/empView/10/abi?lname=siva&couuntry=sri lanka
	
	//@PathVariable---To get the varaibale values from URI
	//@RequestParam ----helps in quesry parameters
	
	  /* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/   
	@PostMapping("/editsave")
	public ModelAndView update(@ModelAttribute("e") Employee e) {
		employeeImpl.updateEmployee(e);
		ModelAndView mv=new ModelAndView("redirect:/empView");
		return mv;
	}
	
	@DeleteMapping("/delete/{empId}")
	public ModelAndView delete(@PathVariable int empId) {
		employeeImpl.deleteEmployee(empId);
		ModelAndView mv=new ModelAndView("redirect:/empView");
		return mv;	
	}
	//Code for Rest API
	@GetMapping(path="/listAll" ,produces = "application/json")
	public List<Employee> findAllEmployee(){
		return employeeImpl.getAllEmployee();
		}
	
	//The @RequestBody annotation maps body of the web request to the method parameter. 
	@PostMapping(path="/addAll",produces = "application/json", consumes= "application/json" )
	public int addEmployee(@RequestBody Employee e) {
		return employeeImpl.saveEmployee(e);
	}
	
	@DeleteMapping(path="/dropEmployee/{empId}", produces = "application/json", consumes= "application/json")
	public int dropEmployee(@PathVariable("empId") int empId) {
		return employeeImpl.deleteEmployee(empId);
	}
	
	@PutMapping(path="/updateEmployee/{empId}", produces = "application/json", consumes= "application/json")
	public int editSave(@PathVariable int empId, @RequestBody Employee e) {
		return employeeImpl.updateEmployee(e);
	}
	
	@GetMapping(path="/getSingleEmployee/{empId}/{fname}/{lname}")
	public Employee getAnEmployee(@PathVariable("empId") int empId, @PathVariable("fname") String fname,  @PathVariable("lname") String lname){
		return employeeImpl.getAnEmployee(empId, fname, lname);
		
	}
	//This kind of exceptionhandling come with some draw backs thats why we have to go with the global exception 
	//If we mention here only this class will be accessible---if we need to access all the other classes we have to go with global
	//@ExceptionHandler(value=RuntimeException.class)//RunTimeException--ArrayIndexOutOfBoundException, 
	//public ModelAndView exceptionHandler() {
	//	ModelAndView mv=new ModelAndView("error");
	//	return mv;
	//}
	
	//If there is a an attribute dateofbirth  it is in the form user need to enter it
	//To get the format--what ever we like we need to mention the SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	//@InitBinder
	//We can get all the information from spring website---Built-in-properties editor
	//we can also write the custom property editors
	
	@InitBinder
	public 	void initBinder(WebDataBinder binder) {
		//SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(String.class, "fname", new EmployeeCustomEditor());
		//if we need we can disallowed the field
		//binder.setDisallowedFields("mane" ,"fname");
	}
	
	
}

