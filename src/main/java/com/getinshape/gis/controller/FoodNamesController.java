package com.getinshape.gis.controller;

import com.getinshape.gis.domain.FoodNames;
import com.getinshape.gis.service.FoodNamesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> getByHebrewName(@RequestParam String hebrewName) {
        log.info("get data from FoodNames With Hebrew name");
        String allFoodNamesData = foodNamesService.getByHebrewName(hebrewName);
        return ResponseEntity.ok(allFoodNamesData);
    }
}