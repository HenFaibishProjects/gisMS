package com.getinshape.gis.domain;

public enum FoodTypes {
    Generic(1),
    SoftDrinks(2),
    Alcohol(3),
    Meat(4),
    Fruits(5),
    Vegetables(6),
    Nuts(7),
    Legumes(8),
    Flour(9),
    Dairy(10),
    FishAndSeaFood(11);


    private final int foodType;

    FoodTypes(int categoryNumber) {
        this.foodType = categoryNumber;
    }

    public int categoryNumber() {
        return foodType;
    }
}
