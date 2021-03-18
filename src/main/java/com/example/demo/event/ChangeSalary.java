package com.example.demo.event;

import com.example.demo.model.Employee;
import org.springframework.context.ApplicationEvent;

public class ChangeSalary extends ApplicationEvent {
    private Employee employee;
    private double oldSalary;

    public ChangeSalary(Object source, Employee employee, double oldSalary) {
        super(source);
        this.employee = employee;
        this.oldSalary = oldSalary;
    }
}
