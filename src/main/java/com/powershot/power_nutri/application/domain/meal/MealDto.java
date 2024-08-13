package com.powershot.power_nutri.application.domain.meal;

import com.powershot.power_nutri.application.domain.foods.FoodDto;
import com.powershot.power_nutri.domain.entity.FoodEntity;
import com.powershot.power_nutri.domain.entity.MealEntity;
import com.powershot.power_nutri.domain.entity.MealFoodEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String hour;

    private String observation;

    private List<FoodDto> foods;

    public static MealDto fromEntity(MealEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.hour = entity.getHour();
        this.observation = entity.getObservation();
        this.foods = entity.getMealFoods().stream().map(MealFoodEntity::getFood).map(FoodDto::fromEntity).toList();
        return this;
    }
}
