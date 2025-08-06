package com.cloudvendor.cloudvendorcompleteservice.Service;

import com.cloudvendor.cloudvendorcompleteservice.Model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    public void createEmployee(Employee employee);
    public Employee getEmployeeDetails(String employeeId);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(String employeeId);
    public Page<Employee> getAllEmployees(Pageable pageable);
}
