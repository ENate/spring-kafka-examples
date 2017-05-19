package de.nath.spring4hibernate.dao.Impl;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.nath.spring4hibernate.dao.EmployeeDAO;
import de.nath.spring4hibernate.entity.Employee;
import de.nath.spring4hibernate.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	public EmployeeDAOImpl(){
		System.out.println("The Implementation of DAO");
	}
	@Autowired
	private HibernateUtil hibernateUtil;
	@Override
	public long createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return (Long)hibernateUtil.create(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return hibernateUtil.update(employee);
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setId(id);
		hibernateUtil.delete(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return hibernateUtil.fetchAll(Employee.class);
	}

	@Override
	public Employee getEmployee(long id) {
		// TODO Auto-generated method stub
		return hibernateUtil.fetchById(id, Employee.class);
	}
	
	 @SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees(String employeeName) {
		// Define string query
		String query = "SELECT e.* FROM employees e WHERE e.name like '%'"+ employeeName;
		// fetch and populate a list
		List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
		List<Employee> employees = new ArrayList<Employee>();
		//setting names of field to return as in prepared statement in a JDBC senario
		for (Object[] employeeObject: employeeObjects){
			//define an employee object
			Employee employee = new Employee();
			//Populate the objects after casting to the types in the dbase.
            long id = ((BigInteger) employeeObject[0]).longValue();         
            int age = (int) employeeObject[1];
            String name = (String) employeeObject[2];
            float salary = (float) employeeObject[3];
            //set resulting array with corresponding type in fields
            employee.setId(id);
            employee.setName(name);
            employee.setAge(age);
            employee.setSalary(salary);
            employees.add(employee);
		}
		System.out.println(employees);
		return employees;
	}
	
}
