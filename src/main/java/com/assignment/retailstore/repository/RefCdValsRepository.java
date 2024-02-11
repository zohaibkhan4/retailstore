package com.assignment.retailstore.repository;

import com.assignment.retailstore.entities.RefCdVals;
import org.springframework.data.repository.CrudRepository;

public interface RefCdValsRepository extends CrudRepository<RefCdVals, Long> {

    public RefCdVals findByIsActiveAndGrpCodeAndValCode(Boolean isActive, String grpCode, String valCode);
}
