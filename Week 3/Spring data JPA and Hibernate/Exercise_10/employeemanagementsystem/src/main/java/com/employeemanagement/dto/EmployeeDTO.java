package com.employeemanagement.dto;

import org.springframework.beans.factory.annotation.Value;

public class EmployeeDTO {

    private String name;
    private String email;
    private String departmentName;

    @Value("#{target.name + ' (' + target.email + ')'}")
    private String nameWithEmail;

    public EmployeeDTO(String name, String email, String departmentName) {
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
    }

    // Getters and setters

    public String getNameWithEmail() {
        return nameWithEmail;
    }

    public void setNameWithEmail(String nameWithEmail) {
        this.nameWithEmail = nameWithEmail;
    }
}
