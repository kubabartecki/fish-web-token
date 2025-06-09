package com.fishwebtoken.api.fish.species;

import com.fishwebtoken.api.fish.species.models.FishSpecies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishSpeciesRepository extends JpaRepository<FishSpecies, Integer> {
}
