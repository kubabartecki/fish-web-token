package com.fishwebtoken.api.fish;

import com.fishwebtoken.api.fish.models.FishDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fishes")
public class FishController {
    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<FishDto> addFish(@RequestBody FishDto fish) {
        // todo
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new FishDto("ratatuj", 1, 1, 1));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<String> updateFish(@PathVariable Integer id, @RequestBody FishDto fish) {
        // todo
        return ResponseEntity.ok("Fish updated successfully: " + fish.name());
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<String> deleteFish(@PathVariable Integer id) {
        // todo
        return ResponseEntity.ok("Fish deleted successfully with ID: " + id);
    }
}
