package com.powershot.power_nutri.application.domain.foods;

import com.powershot.power_nutri.domain.entity.FoodEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {

    private Long id;

    private String group;

    private String description;

    private String slug;

    private String moisture;


    private Long energyKcal;

    private Long energyKj;

    private String proteinG;

    private String carbohydrateG;

    private String groupSlug;

    public static FoodDto fromEntity(FoodEntity entity) {
        return new FoodDto(entity.getId(), entity.getGroup(), entity.getDescription(), entity.getSlug(), entity.getMoisture(), entity.getEnergyKcal(), entity.getEnergyKj(), entity.getProteinG(), entity.getCarbohydrateG(), entity.getGroupSlug());
    }

    public static List<FoodDto> fromEntity(List<FoodEntity> entities) {
        return entities.stream().map(FoodDto::fromEntity).toList();
    }

    public FoodEntity toEntity() {
        return new FoodEntity(id, group, description, slug, moisture, energyKcal, energyKj, proteinG, carbohydrateG, groupSlug);
    }

}
