package com.powershot.power_nutri.application.usecase.nutritionprogram;

import com.powershot.power_nutri.application.domain.exception.EntityNotFoundException;
import com.powershot.power_nutri.application.domain.nutritionprogram.NutritionProgramDto;
import com.powershot.power_nutri.domain.repository.NutritionProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindNutritionProgramByIdService {

    @Autowired
    private NutritionProgramRepository nutritionProgramRepository;

    public NutritionProgramDto execute(Long nutritionProgramId) {
        return NutritionProgramDto.fromEntity(
                nutritionProgramRepository.findById(nutritionProgramId)
                        .orElseThrow(() -> new EntityNotFoundException("Nutrition Program not found.")));
    }
}
