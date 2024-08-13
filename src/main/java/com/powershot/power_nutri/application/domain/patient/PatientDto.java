package com.powershot.power_nutri.application.domain.patient;

import com.powershot.power_nutri.domain.entity.NutritionProgramEntity;
import com.powershot.power_nutri.domain.entity.PatientEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String birthdate;

    private List<NutritionProgramEntity> nutritionPrograms;


    public static PatientDto fromEntity(PatientEntity patient) {
        return new PatientDto(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(), patient.getAddress(), patient.getBirthdate(), patient.getNutritionPrograms());
    }

    public PatientEntity toEntity() {
        return new PatientEntity(id, name, email, phone, address, birthdate, nutritionPrograms);
    }
}
