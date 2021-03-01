package com.example.demo.dao;

import com.example.demo.model.Emoloyee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class EmployeeDataAccess implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertEmployee(UUID id, Emoloyee emoloyee) {
        return 0;
    }

    @Override
    public List<Emoloyee> selectAll() {
        String sql = "SELECT id, name FROM employee";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("fullName");
            return new Emoloyee(id, name);
        });
    }

    @Override
    public Optional<Emoloyee> selectEmployee(UUID id) {
        final String sql = "SELECT id, name FROM employee WHERE id = ?";

        Emoloyee emoloyee = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID personId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("fullName");
            return new Emoloyee(personId, name);
        });
        return Optional.ofNullable(emoloyee);
    }

    @Override
    public int deleteEmployee(UUID id) {
        return 0;
    }

    @Override
    public int updateEmployee(UUID id, Emoloyee emoloyee) {
        return 0;
    }
}
