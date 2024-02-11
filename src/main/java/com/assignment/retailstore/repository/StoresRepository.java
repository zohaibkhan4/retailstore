package com.assignment.retailstore.repository;

import com.assignment.retailstore.entities.Stores;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoresRepository extends CrudRepository<Stores, Long> {
    public List<Stores> findByStoreCode(String storeCode);
}
