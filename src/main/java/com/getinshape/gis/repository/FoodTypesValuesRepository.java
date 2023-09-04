package com.getinshape.gis.repository;

import com.getinshape.gis.domain.FoodTypesValues;
import com.getinshape.gis.domain.GroupTypes;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodTypesValuesRepository extends CrudRepository<FoodTypesValues, Integer> {
}
