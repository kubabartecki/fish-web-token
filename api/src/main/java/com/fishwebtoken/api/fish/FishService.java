package com.fishwebtoken.api.fish;

import com.fishwebtoken.api.fish.models.Fish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishService {
    public List<Fish> getAquariumFishes(Integer aquariumId) {
        // todo
        return List.of();
    }
}
