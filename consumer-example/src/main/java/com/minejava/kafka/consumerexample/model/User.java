package com.minejava.kafka.consumerexample.model;

public class User {
    private String name;
    private String dept;

    /**
     * @param name
     * @param dept
     */
    public User(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }

    /**
     * 
     */
    public User() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dept
     */
    public String getDept() {
        return dept;
    }

    /**
     * @param dept the dept to set
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "User [dept=" + dept + ", name=" + name + "]";
    }

}
