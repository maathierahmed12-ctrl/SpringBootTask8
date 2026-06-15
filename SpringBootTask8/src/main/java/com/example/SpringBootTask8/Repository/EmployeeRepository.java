package com.example.SpringBootTask8.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public class EmployeeRepository {

    public interface Employee extends JpaRepository<Employee, Long> {
    }
}
