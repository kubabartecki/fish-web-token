package com.fishwebtoken.api.store;

import com.fishwebtoken.api.store.feed.Feed;
import com.fishwebtoken.api.store.feed.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final FeedService feedService;

    public List<Feed> getAllFeed() {
        return feedService.getAllFeed();
    }

    public void supplyFeed(int feedTypeId, float amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        Feed feed = feedService.getFeedByTypeId(feedTypeId);
        feed.setWeight(feed.getWeight() + amount);
        feedService.updateFeed(feed);
    }
}
