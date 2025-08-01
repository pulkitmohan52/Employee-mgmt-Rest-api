package com.cloudvendor.cloudvendorcompleteservice.Service;

import com.cloudvendor.cloudvendorcompleteservice.Model.Employee;

import java.util.List;

public interface EmployeeService {
    public void createEmployee(Employee employee);
    public Employee getEmployeeDetails(String employeeId);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(String employeeId);
    public List<Employee> getAllEmployees();
}
