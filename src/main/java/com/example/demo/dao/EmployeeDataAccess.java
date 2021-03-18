package com.example.demo.dao;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("dataBaseAccess")
public class EmployeeDataAccess implements EmployeeDao {
    private static List<Employee> DB = new ArrayList<>();


    @Override
    public int insertEmployee(int id, Employee employee) {
        DB.add(new Employee(id, employee.getFullName(), employee.getSalary(),
                employee.getHours(), employee.getPassedHours(), employee.getCommission(), employee.getEmployeeType()));
        return 1;
    }

    @Override
    public List<Employee> selectAll() {
        return DB;
    }

    @Override
    public Optional<Employee> selectEmployee(int id) {
        return Optional.ofNullable(DB.stream().filter(employee -> id == employee.getId()).findFirst().orElse(null));
    }

    @Override
    public int deleteEmployee(int id) {
        Optional<Employee> emp = selectEmployee(id);
        if(emp.isEmpty()){
            return 0;
        }
        DB.remove(emp.get());
        return 1;
    }

    @Override
    public int updateEmployee(int id, Employee employee) {

        return selectEmployee(id).map(emp -> {
            int indexOfEmp = DB.indexOf(emp);
            if(indexOfEmp >= 0){
                DB.set(indexOfEmp , new Employee(id, employee.getFullName(),
                        employee.getSalary(), employee.getHours(),
                        employee.getPassedHours(), employee.getCommission(), employee.getEmployeeType()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}