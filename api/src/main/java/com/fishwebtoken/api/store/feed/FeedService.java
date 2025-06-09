package com.fishwebtoken.api.store.feed;

import com.fishwebtoken.api.store.feed.type.FeedType;
import com.fishwebtoken.api.store.feed.type.FeedTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedRepository feedRepository;
    private final FeedTypeService feedTypeService;

    public List<Feed> getAllFeed() {
        return feedRepository.findAll();
    }

    public Feed getFeedByTypeId(int feedTypeId) {
        FeedType feedType = feedTypeService.getFeedTypeById(feedTypeId);
        return feedRepository.findByFeedType(feedType)
                .orElse(createFeed(feedType));
    }

    public Feed updateFeed(Feed feed) {
        return feedRepository.save(feed);
    }

    private Feed createFeed(FeedType feedType) {
        Feed feed = new Feed();
        feed.setFeedType(feedType);
        return feedRepository.save(feed);
    }
}
