package com.cloudvendor.cloudvendorcompleteservice.Repository;

import com.cloudvendor.cloudvendorcompleteservice.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Optional<Employee> findByEmployeeEmail(String employeeEmail);
}
