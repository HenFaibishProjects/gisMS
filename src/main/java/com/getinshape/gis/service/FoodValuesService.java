package com.getinshape.gis.service;

import com.getinshape.gis.domain.FoodValues;
import com.getinshape.gis.repository.FoodValuesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class FoodValuesService {
    private final FoodValuesRepository foodValuesRepository;

    public Iterable<FoodValues>getAllFoodValues() {
        return foodValuesRepository.findAll();
    }
}
