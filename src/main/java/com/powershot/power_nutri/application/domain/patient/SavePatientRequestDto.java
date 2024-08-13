package com.powershot.power_nutri.application.domain.patient;

import com.powershot.power_nutri.domain.entity.PatientEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavePatientRequestDto {

    private String name;

    private String email;

    private String phone;

    private String address;

    private String birthdate;

    public PatientEntity toEntity() {
        return new PatientEntity(null, name, email, phone, address, birthdate, null);
    }
}
