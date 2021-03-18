package com.example.demo.dao;

import com.example.demo.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeDao {
    int insertEmployee(int id, Employee employee);

    default int insertEmployee(Employee employee){
     int id = 0;
     return insertEmployee(id, employee);
    }
    List<Employee> selectAll();

    Optional<Employee> selectEmployee(int id);
    int deleteEmployee(int id);
    int updateEmployee(int id, Employee employee);
}
