package com.powershot.power_nutri.application.domain.meal;

import com.powershot.power_nutri.application.domain.foods.FoodDto;
import com.powershot.power_nutri.domain.entity.MealEntity;
import com.powershot.power_nutri.domain.entity.MealFoodEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
        return new MealDto(
                entity.getId(),
                entity.getName(),
                entity.getHour(),
                entity.getObservation(),
                FoodDto.fromEntities(entity.getMealFoods().stream().map(MealFoodEntity::getFood).toList())
        );
    }
}
