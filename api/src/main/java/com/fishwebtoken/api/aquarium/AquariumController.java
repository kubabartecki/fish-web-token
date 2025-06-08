package com.fishwebtoken.api.aquarium;

import com.fishwebtoken.api.aquarium.model.AquariumCreateDto;
import com.fishwebtoken.api.aquarium.model.AquariumDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/aquariums")
public class AquariumController {

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<List<AquariumDto>> getAquarium(Authentication authentication) {
        String username = authentication.getName();
        // todo
        return ResponseEntity.ok(List.of());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<AquariumDto> createAquarium(@RequestBody AquariumCreateDto aquariumCreateDto) {
        // todo
        return ResponseEntity.status(HttpStatus.CREATED).body(new AquariumDto(1, "baniak"));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<AquariumDto> updateAquarium(@PathVariable Integer id, @RequestBody AquariumCreateDto aquariumCreateDto) {
        // todo
        return ResponseEntity.ok(new AquariumDto(1, "baniak"));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<String> deleteAquarium(@PathVariable Integer id) {
        // todo
        return ResponseEntity.ok("Aquarium deleted!");
    }

    @GetMapping("all")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<AquariumDto>> getAllAquariums() {
        // todo
        return ResponseEntity.ok(List.of());
    }

    @PostMapping("{id}/feed")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<String> feedFishes(@PathVariable String id) {
        // todo
        return ResponseEntity.ok("Fishes have been fed!");
    }
}
