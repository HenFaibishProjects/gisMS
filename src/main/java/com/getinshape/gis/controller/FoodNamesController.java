package com.getinshape.gis.controller;

import com.getinshape.gis.domain.FoodNames;
import com.getinshape.gis.domain.FoodTypes;
import com.getinshape.gis.model.response.ResponseFromEnglish;
import com.getinshape.gis.model.response.ResponseFromHebrew;
import com.getinshape.gis.model.response.ResponseFromRomanian;
import com.getinshape.gis.service.FoodNamesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@Validated
@RequestMapping(value = "/v1/FoodNames", produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodNamesController {
    private final FoodNamesService foodNamesService;

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<FoodNames>> getAll() {
        log.info("get All data from FoodNames");
        Iterable<FoodNames> allFoodNamesData = foodNamesService.getAllFoodNames();
        return ResponseEntity.ok(allFoodNamesData);
    }

    @GetMapping("/getByHebrewName")
    public ResponseEntity<ResponseFromHebrew> getByHebrewName(@RequestParam String hebrewName) {
        log.info("get data from FoodNames With Hebrew name");
        ResponseFromHebrew responseFromHebrew = foodNamesService.getByHebrewName(hebrewName);
        return ResponseEntity.ok(responseFromHebrew);
    }

    @GetMapping("/getByEnglishName")
    public ResponseEntity<ResponseFromEnglish> getByEnglishName(@RequestParam String englishName) {
        log.info("get data from FoodNames With English name");
        ResponseFromEnglish responseFromEnglish = foodNamesService.getByEnglish(englishName);
        return ResponseEntity.ok(responseFromEnglish);
    }

    @GetMapping("/getByRomanianName")
    public ResponseEntity<ResponseFromRomanian> getByRomanianName(@RequestParam String romanianName) {
        log.info("get data from FoodNames With Romanian name");
        ResponseFromRomanian responseFromRomanian = foodNamesService.getByRomanianName(romanianName);
        return ResponseEntity.ok(responseFromRomanian);
    }

    @GetMapping("/getAllNamesFromCategory")
    public ResponseEntity<Iterable<FoodNames>> getAllNamesFromCategory(@RequestParam List<FoodTypes> foodTypesList) {
        log.info("get data from FoodNames By Food Type");
        Iterable<FoodNames> allFoodNamesByType = foodNamesService.getAllNamesFromCategory(foodTypesList);
        return ResponseEntity.ok(allFoodNamesByType);
    }
}