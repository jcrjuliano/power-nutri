package com.powershot.power_nutri.application.usecase.patient;

import com.powershot.power_nutri.application.domain.patient.PatientDto;
import com.powershot.power_nutri.application.domain.patient.SavePatientRequestDto;
import com.powershot.power_nutri.domain.entity.PatientEntity;
import com.powershot.power_nutri.domain.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class SavePatientService {
    private PatientRepository patientRepository;

    public SavePatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientDto execute(SavePatientRequestDto patient){
        PatientEntity foundPatient = patientRepository.findByEmail(patient.getEmail()).orElse(null);

        if (foundPatient != null) {
            throw new RuntimeException("E-mail already registered.");
        }

        PatientEntity savedPatient = patientRepository.save(patient.toEntity());

        return PatientDto.fromEntity(savedPatient);
    }
}
