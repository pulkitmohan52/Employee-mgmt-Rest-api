package com.cloudvendor.cloudvendorcompleteservice.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_info")
public class Employee {

    @Id
    private String employeeId;
    private String employeeName;
    @Column(unique = true, nullable = false)
    private String employeeEmail;
    private Long employeePhoneNumber;

    public Employee(Long phoneNumber, String employeeEmail, String employeeName, String employeeId) {
        this.employeePhoneNumber = phoneNumber;
        this.employeeEmail = employeeEmail;
        this.employeeName = employeeName;
        this.employeeId = employeeId;
    }
    public Employee() {

    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Long getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(Long employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }
}
