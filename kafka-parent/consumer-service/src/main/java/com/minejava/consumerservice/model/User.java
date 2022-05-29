package com.minejava.consumerservice.model;

public class User {
    private String name;
    private String department;

    public User() {
    }

    // define all args constructor
    public User(String name, String department) {
        this.name = name;
        this.department = department;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
