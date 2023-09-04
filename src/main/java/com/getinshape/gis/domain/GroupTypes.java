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
@Table(name = "food_group_types")
public class GroupTypes {
    @Id
    private Integer typeId;

    private String typeName;
    private String typeHebrewName;
    private String typeRomanianId;
}
