package com.powershot.power_nutri.domain.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MealFoodId implements Serializable {

    @Column(name = "meal_id")
    private Long mealId;

    @Column(name = "food_id")
    private Long foodId;
}
