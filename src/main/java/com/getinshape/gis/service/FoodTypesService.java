package com.getinshape.gis.service;

import com.getinshape.gis.domain.GroupTypes;
import com.getinshape.gis.repository.FoodTypesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class FoodTypesService {
    private final FoodTypesRepository foodTypesRepository;

    public Iterable<GroupTypes>getAllFoodTypes() {
        return foodTypesRepository.findAll();
    }
}
