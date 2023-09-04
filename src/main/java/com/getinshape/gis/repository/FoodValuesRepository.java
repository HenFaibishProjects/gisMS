package com.getinshape.gis.repository;

import com.getinshape.gis.domain.FoodValues;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface FoodValuesRepository extends CrudRepository<FoodValues, Integer> {
    Iterable<FoodValues> findAll();
}
