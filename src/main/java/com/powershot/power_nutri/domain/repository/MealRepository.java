package com.powershot.power_nutri.domain.repository;

import com.powershot.power_nutri.domain.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<MealEntity, Long> {

}
