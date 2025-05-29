package com.fishwebtoken.api.fish;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/fish")
public class FishController {

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    public String getFishById(@PathVariable String id) {
        return "Fish details for ID: " + id;
    }

    @GetMapping("/{id}/cached")
    @PreAuthorize("hasAuthority('user:read')")
    @Cacheable("fishes")
    public String getFishByIdCached(@PathVariable String id) {
        return "Cached Fish, time: " + LocalDateTime.now() + " details for ID: " + id;
    }
}
