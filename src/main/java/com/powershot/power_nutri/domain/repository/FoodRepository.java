package com.powershot.power_nutri.domain.repository;

import com.powershot.power_nutri.domain.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
}
