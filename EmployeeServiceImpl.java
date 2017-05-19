package de.nath.spring4hibernate.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.nath.spring4hibernate.dao.EmployeeDAO;
import de.nath.spring4hibernate.entity.Employee;
import de.nath.spring4hibernate.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	// The constructor
	public EmployeeServiceImpl(){
		System.out.println("Employee service implementation");;
	}
	
	@Autowired
	private EmployeeDAO employeeDAO;
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployees();
	}

	@Override
	public long createEmployee(Employee employee) {
		// Create the employee
		return employeeDAO.createEmployee(employee);
	}

	@Override
	public void deleteEmployee(long id) {
		// Delete the employee from database
		employeeDAO.deleteEmployee(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// Perform update using supplied info
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public Employee getEmployee(long id) {
		// Get the requested employee using supplied id
		return employeeDAO.getEmployee(id);
	}

	@Override
	public List<Employee> getAllEmployees(String employeeName) {
		// Return list of all employees
		return employeeDAO.getAllEmployees(employeeName);
	}
	
}
