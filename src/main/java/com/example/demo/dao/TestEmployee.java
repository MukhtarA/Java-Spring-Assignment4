package com.example.demo.dao;

import com.example.demo.model.Emoloyee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("test")
public class TestEmployee implements EmployeeDao{

    private static List<Emoloyee> DB = new ArrayList<>();


    @Override
    public int insertEmployee(UUID id, Emoloyee emoloyee) {
        DB.add(new Emoloyee(id, emoloyee.getFullName()));
        return 1;
    }

    @Override
    public List<Emoloyee> selectAll() {
        return DB;
    }

    @Override
    public Optional<Emoloyee> selectEmployee(UUID id) {
        return DB.stream().filter(employee -> employee.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteEmployee(UUID id) {
        Optional<Emoloyee> emp = selectEmployee(id);
        if(emp.isEmpty()) {
            return 0;
        }
        DB.remove(emp.get());
        return 1;
    }

    @Override
    public int updateEmployee(UUID id, Emoloyee emoloyee) {
        return selectEmployee(id).map(e -> {
            int indexOfDeleteEmployee = DB.indexOf(e);
            if(indexOfDeleteEmployee >= 0){
                DB.set(indexOfDeleteEmployee, new Emoloyee(id, emoloyee.getFullName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
