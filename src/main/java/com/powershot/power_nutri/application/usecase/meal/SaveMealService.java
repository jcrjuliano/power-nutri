package com.powershot.power_nutri.application.usecase.meal;

import com.powershot.power_nutri.application.domain.exception.ForbiddenException;
import com.powershot.power_nutri.application.domain.foods.FoodDto;
import com.powershot.power_nutri.application.domain.foods.FoodRequestEntity;
import com.powershot.power_nutri.application.domain.meal.MealDto;
import com.powershot.power_nutri.application.domain.meal.MealRequestDto;
import com.powershot.power_nutri.application.domain.nutritionprogram.NutritionProgramDto;
import com.powershot.power_nutri.application.usecase.foods.FindFoodByIdService;
import com.powershot.power_nutri.application.usecase.nutritionprogram.FindNutritionProgramByIdService;
import com.powershot.power_nutri.domain.entity.MealEntity;
import com.powershot.power_nutri.domain.entity.MealFoodEntity;
import com.powershot.power_nutri.domain.entity.embeddable.MealFoodId;
import com.powershot.power_nutri.domain.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveMealService {
    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private FindFoodByIdService findFoodByIdService;

    @Autowired
    private FindNutritionProgramByIdService findNutritionProgramByIdService;

    public MealDto execute(MealRequestDto meal, Long patientId, Long nutritionProgramId) {
        NutritionProgramDto nutritionProgram = findNutritionProgramByIdService.execute(nutritionProgramId);
        if(!nutritionProgram.getPatient().getId().equals(patientId)) {
            throw new ForbiddenException("Nutrition program does not belong to patient");
        }

        MealEntity mealEntity = new MealEntity();
        mealEntity.setName(meal.getName());
        mealEntity.setHour(meal.getHour());
        mealEntity.setObservation(meal.getObservation());
        mealEntity.setNutritionProgram(nutritionProgram.toEntity());

        for(FoodRequestEntity food : meal.getFoods()) {
            MealFoodEntity mealFood = new MealFoodEntity();

            MealFoodId mealFoodId = new MealFoodId();
            mealFoodId.setMealId(mealEntity.getId());
            mealFoodId.setFoodId(food.getId());

            mealFood.setId(mealFoodId);

            FoodDto foundFood = findFoodByIdService.execute(food.getId());

            mealFood.setFood(foundFood.toEntity());
            mealFood.setMeal(mealEntity);
            mealFood.setQuantity(food.getQuantity());

            mealEntity.getMealFoods().add(mealFood);

        }

        MealEntity savedMeal = mealRepository.save(mealEntity);

        return MealDto.fromEntity(savedMeal);
    }
}
