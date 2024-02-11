package com.assignment.retailstore.repository;

import com.assignment.retailstore.entities.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Products, Long> {
}
