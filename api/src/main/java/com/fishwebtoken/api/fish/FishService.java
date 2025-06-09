package com.fishwebtoken.api.fish;

import com.fishwebtoken.api.config.exception.ResourceNotFoundException;
import com.fishwebtoken.api.fish.models.Fish;
import com.fishwebtoken.api.fish.models.FishDto;
import com.fishwebtoken.api.fish.species.FishSpeciesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FishService {
    private final FishRepository fishRepository;
    private final FishSpeciesService fishSpeciesService;

    public List<Fish> getAquariumFishes(Integer aquariumId) {
        return fishRepository.findByAquariumId(aquariumId);
    }

    public Fish addFish(FishDto fish) {
        Fish newFish = new Fish();
        newFish.setWeight(fish.weight());
        newFish.setSpecies(fishSpeciesService.getFishSpeciesById(fish.speciesId()));
        newFish.setAquariumId(fish.aquariumId());
        return fishRepository.save(newFish);
    }

    public Fish updateFish(Integer id, FishDto fish) {
        Fish existingFish = fishRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fish not found with ID: " + id));

        existingFish.setWeight(fish.weight());
        existingFish.setSpecies(fishSpeciesService.getFishSpeciesById(fish.speciesId()));
        existingFish.setAquariumId(fish.aquariumId());

        return fishRepository.save(existingFish);
    }

    public void deleteFish(Integer id) {
        Fish fish = fishRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fish not found with ID: " + id));
        fishRepository.delete(fish);
    }
}
