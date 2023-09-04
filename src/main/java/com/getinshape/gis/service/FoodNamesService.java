package com.getinshape.gis.service;

import com.getinshape.gis.domain.FoodNames;
import com.getinshape.gis.repository.FoodNamesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class FoodNamesService {
    private final FoodNamesRepository foodNamesRepository;

    public Iterable<FoodNames>getAllFoodNames() {
        return foodNamesRepository.findAll();
    }

    public String getByHebrewName(String hebrewName) {
        FoodNames response = foodNamesRepository.findFoodNamesByFoodNameHebrew(hebrewName);
        return response.getFoodNameRomanian();
    }
}
