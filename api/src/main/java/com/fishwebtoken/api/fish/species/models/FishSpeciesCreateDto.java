package com.fishwebtoken.api.fish.species.models;

import java.util.List;

public record FishSpeciesCreateDto(String name, boolean isFreshwater, List<Integer> feedTypesIds) {
}
