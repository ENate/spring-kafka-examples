package de.nath.spring4hibernate.service;

import java.util.List;

import de.nath.spring4hibernate.entity.Employee;
//Service interface design
public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public long createEmployee(Employee employee);
	public void deleteEmployee(long id);
	public Employee updateEmployee(Employee employee);
	public Employee getEmployee(long id);
	public List<Employee> getAllEmployees(String employeename);
}
