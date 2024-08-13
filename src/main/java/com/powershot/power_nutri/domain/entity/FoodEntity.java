package com.powershot.power_nutri.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "foods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "grupo")
    private String group;

    @Column(name = "descricao")
    private String description;

    private String slug;

    private String moisture;

    @Column(name = "energia_kcal")
    private Long energyKcal;

    @Column(name = "energia_kj")
    private Long energyKj;

    @Column(name = "proteina_g")
    private String proteinG;

    @Column(name = "carboidrato_g")
    private String carbohydrateG;

    @Column(name = "grupo_slug")
    private String groupSlug;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MealFoodEntity> mealFoods = new HashSet<>();

    public FoodEntity(Long id, String group, String description, String slug, String moisture, Long energyKcal, Long energyKj, String proteinG, String carbohydrateG, String groupSlug) {
        this.id = id;
        this.group = group;
        this.description = description;
        this.slug = slug;
        this.moisture = moisture;
        this.energyKcal = energyKcal;
        this.energyKj = energyKj;
        this.proteinG = proteinG;
        this.carbohydrateG = carbohydrateG;
        this.groupSlug = groupSlug;
    }
}
