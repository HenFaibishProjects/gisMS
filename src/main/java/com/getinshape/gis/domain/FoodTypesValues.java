package com.getinshape.gis.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "food_values")
public class FoodTypesValues {
    @Id
    private Integer valuesId;

    private Integer groupType;
    private Integer foodName;
    private Integer carbTotal;
    private Integer fat;
    private Integer protein;
    private Integer fiberExtra;
    private Integer sugarInclude;
    private Integer gi;
    private Integer gl;

}
