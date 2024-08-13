package com.powershot.power_nutri.application.domain.meal;

import com.powershot.power_nutri.application.domain.foods.FoodRequestEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealRequestDto {

    @NotNull
    private String name;

    @NotNull
    private String hour;

    private String observation;

    private List<FoodRequestEntity> foods;
}
