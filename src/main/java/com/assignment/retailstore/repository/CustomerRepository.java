package com.assignment.retailstore.repository;

import com.assignment.retailstore.entities.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customers, Long> {

    public Customers findByFirstName(String firstName);
}
