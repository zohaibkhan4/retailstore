package com.assignment.retailstore.repository;

import com.assignment.retailstore.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository  extends CrudRepository<Employee, Long> {
}
