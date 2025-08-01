package com.cloudvendor.cloudvendorcompleteservice.Service.Implementation;

import com.cloudvendor.cloudvendorcompleteservice.Exception.EmployeeAlreadyPresentException;
import com.cloudvendor.cloudvendorcompleteservice.Exception.EmployeeNotFoundException;
import com.cloudvendor.cloudvendorcompleteservice.Model.Employee;
import com.cloudvendor.cloudvendorcompleteservice.Repository.EmployeeRepository;
import com.cloudvendor.cloudvendorcompleteservice.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void createEmployee(Employee employee) {
        /*if (employeeRepository.findByEmployeeEmail(employee.getEmployeeEmail()).isPresent()) {
            return "An employee with following email is already present.";
        }
        if (employeeRepository.findById(employee.getEmployeeId()).isPresent()) {
            return "An employee with following employee id is already present!";
        }
        employeeRepository.save(employee);*/
        if (employeeRepository.findByEmployeeEmail(employee.getEmployeeEmail()).isPresent()) {
            throw new EmployeeAlreadyPresentException("Employee with this email is already found in our records.");
        }

        if (employeeRepository.findById(employee.getEmployeeId()).isPresent()) {
            throw new EmployeeAlreadyPresentException("Employee with following employee id is already present in our records.");
        }
        employeeRepository.save(employee);
        // return "Employee created";
    }

    @Override
    public Employee getEmployeeDetails(String employeeId) {
        if (employeeRepository.findById(employeeId).isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found in our records.");
        }
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employeeRepository.save(employee);
        String employeeId = employee.getEmployeeId();
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public void deleteEmployee(String employeeId) {
        if (employeeRepository.findById(employeeId).isEmpty()) {
            throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
