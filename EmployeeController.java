package de.nath.spring4hibernate.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.nath.spring4hibernate.entity.Employee;
import de.nath.spring4hibernate.service.EmployeeService;

//Anotate class here
@Controller
public class EmployeeController {
	//Define Logger
	private static final Logger logger = Logger.getLogger("EmployeeController.class");
	public EmployeeController() {
		System.out.println("EmployeeController()");
	}
	@Autowired
	private EmployeeService employeeService;
	//Request mapping to create update
	@RequestMapping("createEmployee")
	public ModelAndView createEmployee(@ModelAttribute Employee employee) {
		logger.info("Creating Employee. Data: "+employee);
		return new ModelAndView("employeeForm");
	}
	//Request mapping to edit employee

	@RequestMapping("editEmployee")
	public ModelAndView editEmployee(@RequestParam long id, @ModelAttribute Employee employee) {
		logger.info("Updating the Employee with Id "+id);
		employee = employeeService.getEmployee(id);
		return new ModelAndView("employeeForm", "employeeObject", employee);
	}
	//saving an employee with attributes
	@RequestMapping("saveEmployee")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		logger.info("Saving the Employee with data : "+employee);
		if(employee.getId() == 0){ 
	// if employee id is 0 then creating the employee other updating the employee
			employeeService.createEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:getAllEmployees");
	}
	@RequestMapping("deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam long id) {
		logger.info("Deleting the Employee with Id : "+id);
		employeeService.deleteEmployee(id);
		return new ModelAndView("redirect:getAllEmployees");
	}

	@RequestMapping(value = {"getAllEmployees", "/"})
	public ModelAndView getAllEmployees() {
		logger.info("Getting the all Employees.");
		List<Employee> employeeList = employeeService.getAllEmployees();
		return new ModelAndView("employeeList", "employeeList", employeeList);
	}

	@RequestMapping("searchEmployee")
	public ModelAndView searchEmployee(@RequestParam("searchName") String searchName) {  
		logger.info("Searching the Employee. Employee Names: "+searchName);
		List<Employee> employeeList = employeeService.getAllEmployees(searchName);
		return new ModelAndView("employeeList", "employeeList", employeeList);      
	}
}
