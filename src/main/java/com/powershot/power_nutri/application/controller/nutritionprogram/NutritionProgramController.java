package com.powershot.power_nutri.application.controller.nutritionprogram;

import com.powershot.power_nutri.application.domain.nutritionprogram.NutritionProgramDto;
import com.powershot.power_nutri.application.domain.nutritionprogram.NutritionProgramRequestDto;
import com.powershot.power_nutri.application.usecase.nutritionprogram.SaveNutritionProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients/{patientId}/nutrition-programs")
public class NutritionProgramController {
    @Autowired
    private SaveNutritionProgramService saveNutritionProgramService;

    @PostMapping("/")
    public ResponseEntity<NutritionProgramDto> save(@RequestBody NutritionProgramRequestDto nutritionProgram, @PathVariable Long patientId) {
        return ResponseEntity.ok(saveNutritionProgramService.execute(nutritionProgram, patientId));
    }
}
