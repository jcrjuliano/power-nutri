package com.powershot.power_nutri.application.controller.meal;

import com.powershot.power_nutri.application.domain.meal.MealDto;
import com.powershot.power_nutri.application.domain.meal.MealRequestDto;
import com.powershot.power_nutri.application.usecase.meal.SaveMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients/{patientId}/nutrition-programs/{nutritionProgramId}/meals")
public class MealController {

    @Autowired
    private SaveMealService saveMealService;

    @PostMapping("/")
    public ResponseEntity<MealDto> save(@RequestBody MealRequestDto meal, @PathVariable Long patientId, @PathVariable Long nutritionProgramId) {
        return ResponseEntity.ok(saveMealService.execute(meal, patientId, nutritionProgramId));
    }
}
