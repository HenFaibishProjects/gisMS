package com.getinshape.gis.repository;

import com.getinshape.gis.domain.FoodNames;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface FoodNamesRepository extends CrudRepository<FoodNames, Integer> {
    Iterable<FoodNames> findAll();
}
