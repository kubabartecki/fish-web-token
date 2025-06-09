package com.fishwebtoken.api.fish.models;

import com.fishwebtoken.api.fish.species.models.FishSpecies;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Fish {
    @Id
    @SequenceGenerator(
            name = "fish_id_sequence",
            sequenceName = "fish_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fish_id_sequence"
    )
    private Integer id;
    private String name;
    private float weight;
    @ManyToOne
    @JoinColumn(name = "fish_species_id")
    private FishSpecies species;
    private int aquariumId;
}
