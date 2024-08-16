package com.employeemanagement.repository;

import com.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Using named query to find employees by name
    List<Employee> findByName(String name);

    // Using named query to find employees by department name
    List<Employee> findByDepartmentName(String departmentName);
}

