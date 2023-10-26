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
@Table(name = "plant")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantId;
    private String name;
    private String description;
    private String conseils_soins;

    @ManyToMany
    @JoinTable(
            name = "piece_plant",
            joinColumns = @JoinColumn(name = "plant_id"),
            inverseJoinColumns = @JoinColumn(name = "piece_id")
    )
    private Set<Piece> pieces = new HashSet<>();

    @ManyToMany(mappedBy = "plants")
    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "plants")
    private Set<ProprietePurificationAir> proprietes = new HashSet<>();

}
