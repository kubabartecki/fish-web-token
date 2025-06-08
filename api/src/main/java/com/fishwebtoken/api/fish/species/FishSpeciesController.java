package com.fishwebtoken.api.fish.species;

import com.fishwebtoken.api.fish.species.models.FishSpeciesCreateDto;
import com.fishwebtoken.api.fish.species.models.FishSpeciesDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/fishes/species")
public class FishSpeciesController {
    @GetMapping("all")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<List<FishSpeciesDto>> getAllFishSpecies() {
        // todo
        return ResponseEntity.ok(List.of());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('store_man:write')")
    public ResponseEntity<FishSpeciesDto> addFishSpecies(@RequestBody FishSpeciesCreateDto fishSpeciesCreateDto) {
        // todo
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new FishSpeciesDto(1, "okon"));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('store_man:write')")
    public ResponseEntity<FishSpeciesDto> updateFishSpecies(@PathVariable Integer id, @RequestBody FishSpeciesCreateDto fishSpeciesCreateDto) {
        // todo
        return ResponseEntity.ok(new FishSpeciesDto(1, "okon"));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('store_man:write')")
    public ResponseEntity<String> deleteFishSpecies(@PathVariable Integer id) {
        // todo
        return ResponseEntity.ok("Fish species deleted successfully with ID: " + id);
    }
}
