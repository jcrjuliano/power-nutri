package com.powershot.power_nutri.domain.repository;

import com.powershot.power_nutri.domain.entity.NutritionProgramEntity;
import com.powershot.power_nutri.domain.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NutritionProgramRepository extends JpaRepository<NutritionProgramEntity, Long> {
    public List<NutritionProgramEntity> findByPatient(PatientEntity patient);
}