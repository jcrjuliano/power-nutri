package com.powershot.power_nutri.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "meals")
public class MealEntity {
    @Id
    private Long id;

    private String name;

    private String hour;

    private String observation;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MealFoodEntity> mealFoods = new HashSet<>();

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "nutrition_program_id")
    private NutritionProgramEntity nutritionProgram;

}
