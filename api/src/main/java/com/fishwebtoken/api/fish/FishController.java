package com.fishwebtoken.api.fish;

import com.fishwebtoken.api.fish.models.Fish;
import com.fishwebtoken.api.fish.models.FishDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fishes")
@RequiredArgsConstructor
public class FishController {
    private final FishService fishService;

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<Fish> addFish(@RequestBody FishDto fish) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(fishService.addFish(fish));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<Fish> updateFish(@PathVariable Integer id, @RequestBody FishDto fish) {
        return ResponseEntity.ok(fishService.updateFish(id, fish));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<String> deleteFish(@PathVariable Integer id) {
        fishService.deleteFish(id);
        return ResponseEntity.ok("Fish deleted successfully with ID: " + id);
    }
}
