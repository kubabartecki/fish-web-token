package com.fishwebtoken.api.fish.species;

import com.fishwebtoken.api.config.exception.ResourceNotFoundException;
import com.fishwebtoken.api.fish.species.models.FishSpecies;
import com.fishwebtoken.api.fish.species.models.FishSpeciesCreateDto;
import com.fishwebtoken.api.fish.species.models.FishSpeciesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FishSpeciesService {
    private static final String FISH_SPECIES_NOT_FOUND_MESSAGE_PREFIX = "Fish species not found with ID: ";
    private final FishSpeciesRepository fishSpeciesRepository;

    public FishSpecies getFishSpeciesById(Integer id) {
        return fishSpeciesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(FISH_SPECIES_NOT_FOUND_MESSAGE_PREFIX + id));
    }

    public List<FishSpeciesDto> getAllFishSpecies() {
        return fishSpeciesRepository.findAll()
                .stream()
                .map(fishSpecies -> new FishSpeciesDto(fishSpecies.getId(), fishSpecies.getName()))
                .toList();
    }

    public FishSpecies addFishSpecies(FishSpeciesCreateDto fishSpeciesCreateDto) {
        FishSpecies fishSpecies = new FishSpecies();
        fishSpecies.setName(fishSpeciesCreateDto.name());
        fishSpecies.setFreshwater(fishSpeciesCreateDto.isFreshwater());
        fishSpecies.setFeedTypesIds(fishSpeciesCreateDto.feedTypesIds());
        return fishSpeciesRepository.save(fishSpecies);
    }

    public FishSpecies updateFishSpecies(Integer id, FishSpeciesCreateDto fishSpeciesCreateDto) {
        FishSpecies fishSpecies = fishSpeciesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(FISH_SPECIES_NOT_FOUND_MESSAGE_PREFIX + id));

        fishSpecies.setName(fishSpeciesCreateDto.name());
        fishSpecies.setFreshwater(fishSpeciesCreateDto.isFreshwater());
        fishSpecies.setFeedTypesIds(fishSpeciesCreateDto.feedTypesIds());

        return fishSpeciesRepository.save(fishSpecies);
    }

    public void deleteFishSpecies(Integer id) {
        FishSpecies fishSpecies = fishSpeciesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(FISH_SPECIES_NOT_FOUND_MESSAGE_PREFIX + id));
        fishSpeciesRepository.delete(fishSpecies);
    }
}
