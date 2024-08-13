package com.powershot.power_nutri.application.usecase.patient;

import com.powershot.power_nutri.application.domain.exception.EntityNotFoundException;
import com.powershot.power_nutri.application.domain.patient.PatientDto;
import com.powershot.power_nutri.domain.entity.PatientEntity;
import com.powershot.power_nutri.domain.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindPatientByIdService {
    @Autowired
    private PatientRepository patientRepository;

    public PatientDto execute(Long id){
        PatientEntity foundPatient = patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        return PatientDto.fromEntity(foundPatient);
    }
}
