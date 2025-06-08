package com.fishwebtoken.api.aquarium.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Aquarium {
    @Id
    @SequenceGenerator(
            name = "aquarium_id_sequence",
            sequenceName = "aquarium_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "aquarium_id_sequence"
    )
    private Integer id;
    private String name;
    private float volume;
    private boolean isFreshwater;
}
