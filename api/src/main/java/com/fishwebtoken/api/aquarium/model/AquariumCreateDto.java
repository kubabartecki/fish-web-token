package com.fishwebtoken.api.aquarium.model;

public record AquariumCreateDto(String name, float volume, boolean isFreshwater) {
    public AquariumCreateDto {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (volume <= 0) {
            throw new IllegalArgumentException("Volume must be greater than zero");
        }
    }
}
