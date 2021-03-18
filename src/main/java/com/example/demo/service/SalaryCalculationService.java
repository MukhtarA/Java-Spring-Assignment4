package com.example.demo.service;

import com.example.demo.model.Employee;

public class SalaryCalculationService {

    public Employee hourlySalary(Employee employee) {
        double salary;

        if (employee.getPassedHours() > 40) {
            salary = (40 * employee.getHours()) + (employee.getPassedHours() - 40) * 1.5 * employee.getHours();
        } else {
            salary = employee.getHours() * employee.getPassedHours();
        }
        employee.setSalary(salary);

        return employee;
    }

    public Employee baseSalaryWithBonus(Employee employee, double sales) {
        double candy = employee.getCommission() * sales / 100;
        employee.setSalary(employee.getSalary() + candy);

        return employee;
    }

    public Employee commissionSalary(Employee employee, double sales){
        double candy = employee.getCommission() * sales / 100;
        employee.setSalary(candy);

        return employee;
    }
}
