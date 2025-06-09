package com.fishwebtoken.api.aquarium;

import com.fishwebtoken.api.aquarium.model.Aquarium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AquariumRepository extends JpaRepository<Aquarium, Integer> {
    List<Aquarium> findByUserId(Integer userId);
}
