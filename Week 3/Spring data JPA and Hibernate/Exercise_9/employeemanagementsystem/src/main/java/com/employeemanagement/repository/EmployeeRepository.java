package com.employeemanagement.repository;

import com.employeemanagement.dto.EmployeeDTO;
import com.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new com.employeemanagementsystem.dto.EmployeeDTO(e.name, e.email, d.name) " +
           "FROM Employee e JOIN e.department d WHERE d.id = :departmentId")
    List<EmployeeDTO> findEmployeeDetailsByDepartmentId(@Param("departmentId") Long departmentId);
}
