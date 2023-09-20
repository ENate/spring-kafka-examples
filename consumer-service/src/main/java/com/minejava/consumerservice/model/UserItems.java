package com.minejava.consumerservice.model;


public class UserItems {
    private String name;
    private String department;
    private Long salary;

    public UserItems() {
    }

    // define all args constructor
    public UserItems(String name, String department, Long salary) {
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

    

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    
    public Long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", dept='").append(department).append('\'');
        sb.append(", salary='").append(salary).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

