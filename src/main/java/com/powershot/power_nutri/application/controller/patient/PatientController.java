package com.powershot.power_nutri.application.controller.patient;

import com.powershot.power_nutri.application.domain.patient.PatientDto;
import com.powershot.power_nutri.application.domain.patient.SavePatientRequestDto;
import com.powershot.power_nutri.application.usecase.patient.FindPatientByIdService;
import com.powershot.power_nutri.application.usecase.patient.ListAllPatientsService;
import com.powershot.power_nutri.application.usecase.patient.SavePatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private SavePatientService savePatientService;

    @Autowired
    private ListAllPatientsService listAllPatientsService;

    @Autowired
    private FindPatientByIdService findPatientByIdService;


    @Operation(summary = "Save a patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient saved successfully"),
            @ApiResponse(responseCode = "404", description = "Patient not found")
            })
    @PostMapping("/")
    public ResponseEntity<PatientDto> save(@RequestBody SavePatientRequestDto patient){
        try {
            return ResponseEntity.ok(savePatientService.execute(patient));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<PatientDto>> listAll(){
        return ResponseEntity.ok(listAllPatientsService.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(findPatientByIdService.execute(id));
    }
}
