package com.example.demo.api;

import com.example.demo.model.Emoloyee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void addEmployee(@Validated @NonNull @RequestBody Emoloyee emoloyee){
        employeeService.addEmployee(emoloyee);
    }

    @GetMapping
    public List<Emoloyee> getAllPeople(){
        return employeeService.getAll();
    }

    @GetMapping(path = "{id}")
    public Emoloyee getEmployeeById(@PathVariable("id") UUID id){
        return employeeService.getEmployeeById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "{id}")
    public void updateEmployee(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody Emoloyee emoloyee){
        employeeService.updateEmployee(id, emoloyee);
    }
}

