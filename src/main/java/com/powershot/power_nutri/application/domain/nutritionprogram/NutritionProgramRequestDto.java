package com.powershot.power_nutri.application.domain.nutritionprogram;

import com.powershot.power_nutri.application.domain.patient.PatientDto;
import com.powershot.power_nutri.domain.entity.NutritionProgramEntity;
import com.powershot.power_nutri.domain.enums.DaysOfWeekEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionProgramRequestDto {
    private String name;
    private List<String> daysOfWeek;

    public NutritionProgramEntity toEntity(PatientDto patientDto) {

        List<DaysOfWeekEnum> daysOfWeekList = daysOfWeek.stream().map(DaysOfWeekEnum::getValue).toList();

        return new NutritionProgramEntity(
                null,
                this.name,
                daysOfWeekList,
                null,
                patientDto.toEntity(),
                true);
    }
}
