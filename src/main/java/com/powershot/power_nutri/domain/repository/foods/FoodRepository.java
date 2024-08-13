package com.powershot.power_nutri.domain.repository.foods;


import com.powershot.power_nutri.domain.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {

    public List<FoodEntity> findAllByIds(List<Long> foodIds);
}
