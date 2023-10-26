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
@Table
public class Piece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pieceId;
    private String name;
    private String description;
    private int etage;

    @ManyToMany(mappedBy = "pieces")
    private Set<Plant> plants = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
