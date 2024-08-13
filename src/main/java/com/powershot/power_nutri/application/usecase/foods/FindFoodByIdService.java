package com.powershot.power_nutri.application.usecase.foods;

import com.powershot.power_nutri.application.domain.exception.EntityNotFoundException;
import com.powershot.power_nutri.application.domain.foods.FoodDto;
import com.powershot.power_nutri.domain.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindFoodByIdService {

    @Autowired
    private FoodRepository foodRepository;

    public FoodDto execute(Long foodId) {
        return
                FoodDto.fromEntity(foodRepository.findById(foodId)
                        .orElseThrow(() -> new EntityNotFoundException("Food not found")));
    }
}
