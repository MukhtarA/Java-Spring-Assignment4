package com.example.demo.service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(@Qualifier("dataBaseAccess") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void addEmployee(Employee employee){
        employeeDao.insertEmployee(employee);
    }

    public List<Employee> getAll(){
        return employeeDao.selectAll();
    }

    public Optional<Employee> getEmployeeById(int id){
        return employeeDao.selectEmployee(id);
    }

    public int deleteEmployee(int id) {
        return employeeDao.deleteEmployee(id);
    }

    public int updateEmployee(int id, Employee newEmployee){
        return employeeDao.updateEmployee(id, newEmployee);
    }
}
