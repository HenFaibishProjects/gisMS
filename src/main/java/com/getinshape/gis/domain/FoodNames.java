package com.getinshape.gis.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "food_names")
public class FoodNames {
    @Id
    private Integer foodNameId;

    private Integer foodType;
    private String foodName;
    private String foodNameHebrew;
    private String foodNameRomanian;
}
