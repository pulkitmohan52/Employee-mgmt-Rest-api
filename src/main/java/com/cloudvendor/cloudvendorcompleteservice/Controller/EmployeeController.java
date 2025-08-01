package com.cloudvendor.cloudvendorcompleteservice.Controller;

import com.cloudvendor.cloudvendorcompleteservice.Model.Employee;
import com.cloudvendor.cloudvendorcompleteservice.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:5173/")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee gottenEmployee) {
        employeeService.createEmployee(gottenEmployee);
        return ResponseEntity.ok("Employee added successfully");
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeDetails(@PathVariable String employeeId) {
        return employeeService.getEmployeeDetails(employeeId);
    }

    @PutMapping()
    public Employee updateEmployeeDetails(@RequestBody Employee gottenEmployee) {
        return employeeService.updateEmployee(gottenEmployee);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployeeDetails(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully.");
    }

    @GetMapping()
    public List<Employee> getAllEmployeeDetails() {
        return employeeService.getAllEmployees();
        // return "Here are all employee details";
    }

}
