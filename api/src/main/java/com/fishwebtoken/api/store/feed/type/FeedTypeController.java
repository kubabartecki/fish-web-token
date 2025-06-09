package com.fishwebtoken.api.store.feed.type;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store/feed/types")
@RequiredArgsConstructor
public class FeedTypeController {
    private final FeedTypeService feedTypeService;

    @GetMapping
    @PreAuthorize("hasAuthority('store_man:read')")
    public ResponseEntity<List<FeedType>> getAllFeedTypes() {
        return ResponseEntity.ok(feedTypeService.getFeedTypes());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('store_man:write')")
    public ResponseEntity<FeedType> addFeedType(@RequestParam("name") String name) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(feedTypeService.addFeedType(name));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('store_man:write')")
    public ResponseEntity<FeedType> updateFeedType(@PathVariable Integer id, @RequestParam("name") String name) {
        return ResponseEntity.ok(feedTypeService.updateFeedType(id, name));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('store_man:write')")
    public ResponseEntity<String> deleteFeedType(@PathVariable Integer id) {
        feedTypeService.deleteFeedType(id);
        return ResponseEntity.ok("Feed type deleted successfully with ID: " + id);
    }
}
