package io.spring.boot.employee.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeImpl employeeImpl;
	
	@GetMapping("/empForm")
	public ModelAndView viewEmployeeForm() {
		ModelAndView mv=new ModelAndView("empForm");
		mv.addObject("e", new Employee());
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
	
}

