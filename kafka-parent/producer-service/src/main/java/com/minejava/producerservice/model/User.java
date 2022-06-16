package com.minejava.producerservice.model;

public class User {
    // Define user fields
    private String name;
    private String department;
    private Long salary;

    
    public User() {
    }

    public User(String name, String department, Long salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User [department=" + department + ", name=" + name + ", salary=" + salary + "]";
    }

    
}
