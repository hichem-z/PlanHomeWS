package com.planthome.planthome.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ProprietePurificationAir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proprieteId;
    private String nom;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "plant_propriete",
            joinColumns = @JoinColumn(name = "propriete_id"),
            inverseJoinColumns = @JoinColumn(name = "plant_id")
    )
    private Set<Plant> plants = new HashSet<>();

}
