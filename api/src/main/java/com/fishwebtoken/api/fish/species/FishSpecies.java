package com.fishwebtoken.api.fish.species;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class FishSpecies {
    @Id
    @SequenceGenerator(
            name = "fish_species_id_sequence",
            sequenceName = "fish_species_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fish_species_id_sequence"
    )
    @Column(name = "fish_species_id")
    private Integer id;
    private String name;
    private boolean isFreshwater;
    private List<Integer> feedTypesIds;
}
