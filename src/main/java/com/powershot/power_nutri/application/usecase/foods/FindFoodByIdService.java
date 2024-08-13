package com.powershot.power_nutri.application.usecase.foods;

import com.powershot.power_nutri.application.domain.exception.EntityNotFoundException;
import com.powershot.power_nutri.application.domain.foods.FoodDto;
import com.powershot.power_nutri.domain.repository.foods.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindFoodByIdService {

    @Autowired
    private FoodRepository foodRepository;

    public FoodDto execute(Long foodId) {
        return foodRepository.findById(foodId)
                .map(FoodDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Food not found"));
    }
}
