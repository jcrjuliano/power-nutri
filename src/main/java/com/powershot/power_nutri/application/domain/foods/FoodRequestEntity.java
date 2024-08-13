package com.powershot.power_nutri.application.domain.foods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequestEntity {
    @NotNull
    private Long id;

    @NotNull
    private Double quantity;

}
