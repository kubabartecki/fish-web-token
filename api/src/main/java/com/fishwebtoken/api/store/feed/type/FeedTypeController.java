package com.fishwebtoken.api.store.feed.type;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store/feed/types")
public class FeedTypeController {
    @PostMapping
    @PreAuthorize("hasAuthority('store_man:write')")
    public ResponseEntity<FeedType> addFeedType(@RequestParam("name") String name) {
        // todo
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new FeedType());
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('store_man:write')")
    public ResponseEntity<FeedType> updateFeedType(@PathVariable Integer id, @RequestParam("name") String name) {
        // todo
        return ResponseEntity.ok(new FeedType());
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('store_man:write')")
    public ResponseEntity<String> deleteFeedType(@PathVariable Integer id) {
        // todo
        return ResponseEntity.ok("Feed type deleted successfully with ID: " + id);
    }
}
