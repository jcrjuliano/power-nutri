package com.powershot.power_nutri.application.domain.nutritionprogram;

import com.powershot.power_nutri.domain.entity.MealEntity;
import com.powershot.power_nutri.domain.entity.NutritionProgramEntity;
import com.powershot.power_nutri.domain.entity.PatientEntity;
import com.powershot.power_nutri.domain.enums.DaysOfWeekEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NutritionProgramDto {
    private Long id;

    private String name;

    private List<DaysOfWeekEnum> daysOfWeek;

    private List<MealEntity> meals;

    private PatientEntity patient;

    private Boolean active;

    public static NutritionProgramDto fromEntity(NutritionProgramEntity entity) {
        return new NutritionProgramDto(entity.getId(), entity.getName(), entity.getDaysOfWeek(), entity.getMeals(), entity.getPatient(), entity.getActive());
    }

    public NutritionProgramEntity toEntity() {
        return new NutritionProgramEntity(id, name, daysOfWeek, meals, patient, active);
    }
}
