package com.example.demo.dao;

import com.example.demo.model.Emoloyee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeDao {
    int insertEmployee(UUID id, Emoloyee emoloyee);

    default int insertEmployee(Emoloyee emoloyee){
     UUID id = UUID.randomUUID();
     return insertEmployee(id, emoloyee);
    }
    List<Emoloyee> selectAll();

    Optional<Emoloyee> selectEmployee(UUID id);
    int deleteEmployee(UUID id);
    int updateEmployee(UUID id, Emoloyee emoloyee);
}
