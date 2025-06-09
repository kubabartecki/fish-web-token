package com.fishwebtoken.api.aquarium;

import com.fishwebtoken.api.aquarium.model.Aquarium;
import com.fishwebtoken.api.aquarium.model.AquariumCreateDto;
import com.fishwebtoken.api.aquarium.model.AquariumDto;
import com.fishwebtoken.api.config.exception.ResourceNotFoundException;
import com.fishwebtoken.api.user.User;
import com.fishwebtoken.api.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AquariumService {
    private final AquariumRepository aquariumRepository;
    private final UserService userService;

    @Cacheable("allAquariums")
    public List<AquariumDto> getAllAquariums() {
        return aquariumRepository.findAll()
                .stream()
                .map(aquarium -> new AquariumDto(aquarium.getId(), aquarium.getName()))
                .toList();
    }

    public List<AquariumDto> getUserAquariums(String username) {
        User user = userService.getUserByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
        return aquariumRepository.findByUserId(user.getId())
                .stream()
                .map(aquarium -> new AquariumDto(aquarium.getId(), aquarium.getName()))
                .toList();
    }

    public Aquarium createAquarium(String username, AquariumCreateDto aquariumCreateDto) {
        User user = userService.getUserByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
        Aquarium aquarium = new Aquarium();
        aquarium.setName(aquariumCreateDto.name());
        aquarium.setVolume(aquariumCreateDto.volume());
        aquarium.setFreshwater(aquariumCreateDto.isFreshwater());
        aquarium.setUserId(user.getId());

        return aquariumRepository.save(aquarium);
    }

    public Aquarium updateAquarium(Integer id, AquariumCreateDto aquariumCreateDto) {
        Aquarium aquarium = aquariumRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aquarium not found with ID: " + id));

        aquarium.setName(aquariumCreateDto.name());
        aquarium.setVolume(aquariumCreateDto.volume());
        aquarium.setFreshwater(aquariumCreateDto.isFreshwater());

        return aquariumRepository.save(aquarium);
    }

    public void deleteAquarium(Integer id) {
        Aquarium aquarium = aquariumRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aquarium not found with ID: " + id));
        aquariumRepository.delete(aquarium);
    }

    public boolean feedFishes(Integer id) {
        // todo
        return true;
    }
}
