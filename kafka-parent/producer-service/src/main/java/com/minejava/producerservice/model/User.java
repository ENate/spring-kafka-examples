package com.minejava.producerservice.model;

public class User {
    // Define user fields
    private String name;
    private String department;
    private Long Salary;

    public User(String name, String department, Long salary) {
        this.name = name;
        this.department = department;
        Salary = salary;
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
        return Salary;
    }

    public void setSalary(Long salary) {
        Salary = salary;
    }
}
