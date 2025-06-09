package com.fishwebtoken.api.aquarium;

import com.fishwebtoken.api.aquarium.model.Aquarium;
import com.fishwebtoken.api.aquarium.model.AquariumCreateDto;
import com.fishwebtoken.api.aquarium.model.AquariumDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/aquariums")
@RequiredArgsConstructor
public class AquariumController {
    private final AquariumService aquariumService;

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<List<AquariumDto>> getAquarium(Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok(aquariumService.getUserAquariums(username));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<Aquarium> createAquarium(Authentication authentication, @RequestBody AquariumCreateDto aquariumCreateDto) {
        String username = authentication.getName();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(aquariumService.createAquarium(username, aquariumCreateDto));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<Aquarium> updateAquarium(@PathVariable Integer id, @RequestBody AquariumCreateDto aquariumCreateDto) {
        return ResponseEntity.ok(aquariumService.updateAquarium(id, aquariumCreateDto));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<String> deleteAquarium(@PathVariable Integer id) {
        aquariumService.deleteAquarium(id);
        return ResponseEntity.ok("Aquarium deleted successfully with ID: " + id);
    }

    @GetMapping("all")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<AquariumDto>> getAllAquariums() {
        return ResponseEntity.ok(aquariumService.getAllAquariums());
    }

    @PostMapping("{id}/feed")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<String> feedFishes(@PathVariable Integer id) {
        boolean areFeed = aquariumService.feedFishes(id);
        if (!areFeed) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Not enough food to feed the fishes.");
        }
        return ResponseEntity.ok("Fishes have been fed!");
    }
}
