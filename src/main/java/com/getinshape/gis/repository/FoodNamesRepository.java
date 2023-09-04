package com.getinshape.gis.repository;

import com.getinshape.gis.domain.FoodNames;
import com.getinshape.gis.domain.GroupTypes;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodNamesRepository extends CrudRepository<FoodNames, Integer> {
    Iterable<FoodNames> findAll();
}
