package com.powershot.power_nutri.domain.entity;

import com.powershot.power_nutri.domain.enums.DaysOfWeekEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "nutrition_programs")
public class NutritionProgramEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private List<DaysOfWeekEnum> daysOfWeek;

    @OneToMany(mappedBy = "nutritionProgram", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MealEntity> meals;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    private Boolean active;
}
