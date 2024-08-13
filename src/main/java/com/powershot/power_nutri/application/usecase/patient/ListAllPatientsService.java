package com.powershot.power_nutri.application.usecase.patient;

import com.powershot.power_nutri.application.domain.patient.PatientDto;
import com.powershot.power_nutri.domain.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllPatientsService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientDto> execute(){
        return patientRepository.findAll().stream().map(PatientDto::fromEntity).toList();
    }

}
