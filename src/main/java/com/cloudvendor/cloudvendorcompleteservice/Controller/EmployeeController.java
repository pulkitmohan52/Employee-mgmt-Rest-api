package com.cloudvendor.cloudvendorcompleteservice.Controller;

import com.cloudvendor.cloudvendorcompleteservice.Model.Employee;
import com.cloudvendor.cloudvendorcompleteservice.Service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
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

    @GetMapping("/getallemployees")
    public ResponseEntity<Page<Employee>> getAllEmployees(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "5") int size,
                                          @RequestParam(defaultValue = "employeeName") String sortBy,
                                          @RequestParam(defaultValue = "asc") String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Employee> employeePage = employeeService.getAllEmployees(pageable);

        return ResponseEntity.ok(employeePage);
    }

    @PostMapping()
    public ResponseEntity<String> addAllEmployees(@RequestBody Employee employee)  {
        employeeService.createEmployee(employee);
        return ResponseEntity.ok("Employee with name: " + employee.getEmployeeName() + " successfully added");
    }

}
