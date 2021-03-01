package com.example.demo.service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Emoloyee;
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
    public EmployeeService(@Qualifier("postgres") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int addEmployee(Emoloyee emoloyee){
        return employeeDao.insertEmployee(emoloyee);
    }

    public List<Emoloyee> getAll(){
        return employeeDao.selectAll();
    }

    public Optional<Emoloyee> getEmployeeById(UUID id){
        return employeeDao.selectEmployee(id);
    }

    public int deleteEmployee(UUID id) {
        return employeeDao.deleteEmployee(id);
    }

    public int updateEmployee(UUID id, Emoloyee newEmployee){
        Object employee1;
        return employeeDao.updateEmployee(id, newEmployee);
    }
}
