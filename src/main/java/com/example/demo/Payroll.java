package com.example.demo;

import com.example.demo.api.EmployeeController;
import com.example.demo.model.Employee;
import com.example.demo.service.SalaryCalculationService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Payroll {
    private final Scanner scanner = new Scanner(System.in);
    private SalaryCalculationService salaryCalculationService;
    private EmployeeController employeeController;

    public void menu() {
        boolean m = true;
        while (m) {
            System.out.println("[1] Basic salary employee ");
            System.out.println("[2] Hourly salary employee");
            System.out.println("[3] Commission salary employee");
            System.out.println("[4] Salaried-Commission salary employee");
            System.out.println("[0] Exit");
            System.out.print("Enter: ");
            int n = scanner.nextInt();

            switch (n) {
                case 1:
                    changeBaseSalary();
                    break;
                case 2:
                    changeHourlySalary();
                    break;
                case 3:
                    changeCommissionSalary();
                    break;
                case 4:
                    changeCommissionBaseSalary();
                    break;
                case 0:
                    m = false;
                    break;

            }
        }
    }

    private void changeBaseSalary() {
        employeeController.getAllPeople();
        Employee employee = employeeController.getEmployeeById(scanner.nextInt());
        double newSalary = scanner.nextDouble();
        employee.setSalary(newSalary);
    }

    private void changeHourlySalary() {
        employeeController.getAllPeople();
        Employee employee = employeeController.getEmployeeById(scanner.nextInt());
        employee.setHours(scanner.nextDouble());
        salaryCalculationService.hourlySalary(employee);
    }

    private void changeCommissionSalary(){
        employeeController.getAllPeople();
        Employee employee = employeeController.getEmployeeById(scanner.nextInt());
        double sales = scanner.nextDouble();
        salaryCalculationService.commissionSalary(employee, sales);
    }

    private void changeCommissionBaseSalary(){
        employeeController.getAllPeople();
        Employee employee = employeeController.getEmployeeById(scanner.nextInt());
        double sales = scanner.nextDouble();
        salaryCalculationService.baseSalaryWithBonus(employee, sales);
    }

}
