package com.fishwebtoken.api.store;

import com.fishwebtoken.api.store.feed.Feed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/feed/supply")
    @PreAuthorize("hasAuthority('store_man:write')")
    public ResponseEntity<String> supplyFeed(@RequestBody FeedSupplyDto feedSupply) {
        storeService.supplyFeed(feedSupply.feedTypeId(), feedSupply.amount());
        return ResponseEntity.ok("Feed supplied successfully for feedTypeId: " + feedSupply.feedTypeId());
    }

    @GetMapping
    @PreAuthorize("hasAuthority('store_man:read')")
    public ResponseEntity<List<Feed>> getAllFeed() {
        return ResponseEntity.ok(storeService.getAllFeed());
    }
}
