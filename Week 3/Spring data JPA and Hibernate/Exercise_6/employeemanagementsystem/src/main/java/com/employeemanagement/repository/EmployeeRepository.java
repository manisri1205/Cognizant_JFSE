package com.employeemanagement.repository;

import com.employeemanagement.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Paginated and sorted query for all employees
    Page<Employee> findAll(Pageable pageable);

    // Custom query method with pagination
    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);

    // Custom query method with pagination and sorting by name
    Page<Employee> findByNameContaining(String keyword, Pageable pageable);
}