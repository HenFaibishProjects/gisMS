package com.getinshape.gis.controller;

import com.getinshape.gis.domain.FoodValues;
import com.getinshape.gis.service.FoodValuesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@Validated
@RequestMapping(value = "/v1/FoodValues", produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodValuesController {
    private final FoodValuesService foodValuesService;


    @GetMapping("/getAll")
    public ResponseEntity<Iterable<FoodValues>> getAll() {
        log.info("get All data from FoodNames");
        Iterable<FoodValues> allFoodValues = foodValuesService.getAllFoodValues();
        return ResponseEntity.ok(allFoodValues);
    }
}
