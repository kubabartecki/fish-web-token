package com.fishwebtoken.api.store;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {
    @PostMapping("/feed/supply")
    @PreAuthorize("hasAuthority('store_man:write')")
    public ResponseEntity<String> supplyFeed(@RequestBody FeedSupplyDto feedSupply) {
        // todo
        return ResponseEntity.ok("Feed supplied successfully for feedTypeId: " + feedSupply.feedTypeId());
    }
}
