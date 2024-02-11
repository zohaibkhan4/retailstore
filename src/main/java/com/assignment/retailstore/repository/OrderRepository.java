package com.assignment.retailstore.repository;

import com.assignment.retailstore.entities.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Long> {
}
