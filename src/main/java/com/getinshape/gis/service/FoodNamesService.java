package com.getinshape.gis.service;

import com.getinshape.gis.domain.FoodNames;
import com.getinshape.gis.domain.FoodTypes;
import com.getinshape.gis.model.response.ResponseFromEnglish;
import com.getinshape.gis.model.response.ResponseFromHebrew;
import com.getinshape.gis.model.response.ResponseFromRomanian;
import com.getinshape.gis.repository.FoodNamesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class FoodNamesService {
    private final FoodNamesRepository foodNamesRepository;

    public Iterable<FoodNames> getAllFoodNames() {
        return foodNamesRepository.findAll();
    }

    public ResponseFromHebrew getByHebrewName(String hebrewName) {
        FoodNames response = foodNamesRepository.findFoodNamesByFoodNameHebrew(hebrewName);
        return ResponseFromHebrew.builder()
                .englishName(response.getFoodName())
                .romanianName(response.getFoodNameRomanian())
                .build();
    }

    public ResponseFromRomanian getByRomanianName(String hebrewName) {
        FoodNames response = foodNamesRepository.findFoodNamesByFoodNameRomanian(hebrewName);
        return ResponseFromRomanian.builder()
                .englishName(response.getFoodName())
                .hebrewName(response.getFoodNameHebrew())
                .build();
    }

    public ResponseFromEnglish getByEnglish(String hebrewName) {
        FoodNames response = foodNamesRepository.findFoodNamesByFoodName(hebrewName);
        return ResponseFromEnglish.builder()
                .hebrewName(response.getFoodNameHebrew())
                .romanianName(response.getFoodNameRomanian())
                .build();
    }

    public Iterable<FoodNames> getAllNamesFromCategory(List<FoodTypes> foodTypesList) {
        List<FoodNames> foodNamesResponseList = new java.util.ArrayList<>(List.of());

        List<Integer> foodTypesListValue = foodTypesList.stream()
                .map(FoodTypes::categoryNumber)
                .toList();

        foodTypesListValue.forEach(value ->
                foodNamesResponseList.add(foodNamesRepository.findFoodNamesByFoodType(value)));
        return foodNamesResponseList;
    }


}
