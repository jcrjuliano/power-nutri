package com.powershot.power_nutri.application.usecase.foods;

import com.powershot.power_nutri.application.domain.foods.FoodDto;
import com.powershot.power_nutri.domain.entity.FoodEntity;
import com.powershot.power_nutri.domain.repository.foods.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindFoodsByIdsService {

    @Autowired
    private FoodRepository foodRepository;

    public List<FoodDto> execute(List<Long> foodIds) {
        return FoodDto.fromEntity(foodRepository.findAllByIds(foodIds));
    }
}
