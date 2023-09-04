package com.getinshape.gis.controller;

import com.getinshape.gis.domain.GroupTypes;
import com.getinshape.gis.service.FoodTypesService;
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
@RequestMapping(value = "/v1/FoodTypes", produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodTypesController {
    private final FoodTypesService foodTypesService;


    @GetMapping("/getAll")
    public ResponseEntity<Iterable<GroupTypes>> getAll() {
        log.info("get All data from FoodNames");
        Iterable<GroupTypes> allFoodTypes = foodTypesService.getAllFoodTypes();
        return ResponseEntity.ok(allFoodTypes);
    }
}
