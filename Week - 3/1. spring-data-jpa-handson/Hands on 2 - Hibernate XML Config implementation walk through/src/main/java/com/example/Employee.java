package com.example;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // No-arg constructor is REQUIRED
    public Employee() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {         // <-- REQUIRED
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {   // <-- REQUIRED
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {       // <-- REQUIRED
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
