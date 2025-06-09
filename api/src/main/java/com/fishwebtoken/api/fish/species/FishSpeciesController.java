package com.fishwebtoken.api.fish.species;

import com.fishwebtoken.api.fish.species.models.FishSpecies;
import com.fishwebtoken.api.fish.species.models.FishSpeciesCreateDto;
import com.fishwebtoken.api.fish.species.models.FishSpeciesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/fishes/species")
@RequiredArgsConstructor
public class FishSpeciesController {
    private final FishSpeciesService fishSpeciesService;

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<List<FishSpeciesDto>> getAllFishSpecies() {
        return ResponseEntity.ok(fishSpeciesService.getAllFishSpecies());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('store_man:write')")
    public ResponseEntity<FishSpecies> addFishSpecies(@RequestBody FishSpeciesCreateDto fishSpeciesCreateDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(fishSpeciesService.addFishSpecies(fishSpeciesCreateDto));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('store_man:write')")
    public ResponseEntity<FishSpecies> updateFishSpecies(@PathVariable Integer id, @RequestBody FishSpeciesCreateDto fishSpeciesCreateDto) {
        return ResponseEntity.ok(fishSpeciesService.updateFishSpecies(id, fishSpeciesCreateDto));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('store_man:write')")
    public ResponseEntity<String> deleteFishSpecies(@PathVariable Integer id) {
        fishSpeciesService.deleteFishSpecies(id);
        return ResponseEntity.ok("Fish species deleted successfully with ID: " + id);
    }
}
