package com.powershot.power_nutri.domain.entity;

import com.powershot.power_nutri.domain.entity.embeddable.MealFoodId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "meal_food")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealFoodEntity {

    @EmbeddedId
    private MealFoodId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("mealId")
    @JoinColumn(name = "meal_id")
    private MealEntity meal;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("foodId")
    @JoinColumn(name = "food_id")
    private FoodEntity food;

    @Column(name = "quantity")
    private Double quantity;
}
