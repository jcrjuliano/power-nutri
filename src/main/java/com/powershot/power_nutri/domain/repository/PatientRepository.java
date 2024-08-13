package com.powershot.power_nutri.domain.repository;

import com.powershot.power_nutri.domain.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<PatientEntity, Long>{

    public Optional<PatientEntity> findByEmail(String email);
}
