package com.powershot.power_nutri.application.usecase.nutritionprogram;

import com.powershot.power_nutri.application.domain.nutritionprogram.NutritionProgramDto;
import com.powershot.power_nutri.application.domain.nutritionprogram.NutritionProgramRequestDto;
import com.powershot.power_nutri.application.domain.patient.PatientDto;
import com.powershot.power_nutri.application.usecase.patient.FindPatientByIdService;
import com.powershot.power_nutri.domain.entity.NutritionProgramEntity;
import com.powershot.power_nutri.domain.repository.NutritionProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveNutritionProgramService {

    @Autowired
    private NutritionProgramRepository nutritionProgramRepository;

    @Autowired
    private FindPatientByIdService findPatientByIdService;

    public NutritionProgramDto execute(NutritionProgramRequestDto dto, Long patientId) {
        PatientDto foundPatient = findPatientByIdService.execute(patientId);

        NutritionProgramEntity savedNutritionProgram = nutritionProgramRepository.save(dto.toEntity(foundPatient));

        return NutritionProgramDto.fromEntity(savedNutritionProgram);

    }
}
