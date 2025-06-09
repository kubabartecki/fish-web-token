package com.fishwebtoken.api.fish;

import com.fishwebtoken.api.fish.models.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FishRepository extends JpaRepository<Fish, Integer> {
    List<Fish> findByAquariumId(Integer aquariumId);
}
