package com.fishwebtoken.api.aquarium;

import com.fishwebtoken.api.aquarium.model.Aquarium;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AquariumService {
    @Cacheable("allAquariums")
    public List<Aquarium> getAllAquariums() {
        // todo
        return List.of();
    }
}
