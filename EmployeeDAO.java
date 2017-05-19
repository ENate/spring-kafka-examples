package de.nath.spring4hibernate.dao;

import java.util.List;

import de.nath.spring4hibernate.entity.Employee;
//Define methods to perform CRUD operations
public interface EmployeeDAO {
	public long createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(long id);
    public List<Employee> getAllEmployees();
    public Employee getEmployee(long id);   
    public List<Employee> getAllEmployees(String employeeName);
}
