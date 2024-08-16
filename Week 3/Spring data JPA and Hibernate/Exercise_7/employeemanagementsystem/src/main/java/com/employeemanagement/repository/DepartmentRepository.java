package com.employeemanagement.repository;

import com.employeemanagement.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Using named query to find department by name
    Department findDepartmentByName(String name);
}