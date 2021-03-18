package com.example.demo.api;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void addEmployee(@Validated @NonNull @RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllPeople(){
        return employeeService.getAll();
    }

    @GetMapping(path = "{id}")
    public Employee getEmployeeById(@PathVariable("id") int id){
        return employeeService.getEmployeeById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "{id}")
    public void updateEmployee(@PathVariable("id") int id, @Validated @NonNull @RequestBody Employee employee){
        employeeService.updateEmployee(id, employee);
    }
}

