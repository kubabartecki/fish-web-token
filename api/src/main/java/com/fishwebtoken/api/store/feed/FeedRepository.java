package com.fishwebtoken.api.store.feed;

import com.fishwebtoken.api.store.feed.type.FeedType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeedRepository extends JpaRepository<Feed, Integer> {
    Optional<Feed> findByFeedType(FeedType feedType);
}
