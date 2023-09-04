package com.getinshape.gis.repository;

import com.getinshape.gis.domain.GroupTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupTypesRepository extends CrudRepository<GroupTypes, Integer> {
    Iterable<GroupTypes> findAll();

    Optional<GroupTypes> findAllByTypeId(Integer id);

    Optional<GroupTypes> findDistinctByTypeHebrewName(String hebrewName);

}


