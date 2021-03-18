package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final int id;
    private String fullName;
    private double salary;
    private double hours;
    private int passedHours;
    private float commission;
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;


    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public int getPassedHours() {
        return passedHours;
    }

    public void setPassedHours(int passedHours) {
        this.passedHours = passedHours;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public Employee(@JsonProperty("id") int id, @JsonProperty("name") String fullName,
                    @JsonProperty("salary") double salary, @JsonProperty("hours") double hours,
                    @JsonProperty("passedHours") int passedHours, float commission, @JsonProperty("employeeType") EmployeeType employeeType) {
        this.id = id;
        this.fullName = fullName;
        this.salary = salary;
        this.hours = hours;
        this.passedHours = passedHours;
        this.commission = commission;
        this.employeeType = employeeType;
    }

}












