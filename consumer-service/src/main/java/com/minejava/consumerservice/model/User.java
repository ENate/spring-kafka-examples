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
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", dept='").append(department).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
