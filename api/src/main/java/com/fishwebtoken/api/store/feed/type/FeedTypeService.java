package com.fishwebtoken.api.store.feed.type;

import com.fishwebtoken.api.config.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedTypeService {
    private final FeedTypeRepository feedTypeRepository;

    public FeedType getFeedTypeById(int id) {
        return feedTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feed type not found with ID: " + id));
    }

    public List<FeedType> getFeedTypes() {
        return feedTypeRepository.findAll();
    }

    public FeedType addFeedType(String name) {
        FeedType feedType = new FeedType();
        feedType.setName(name);
        return feedTypeRepository.save(feedType);
    }

    public FeedType updateFeedType(Integer id, String name) {
        FeedType feedType = feedTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feed type not found with ID: " + id));

        feedType.setName(name);
        return feedTypeRepository.save(feedType);
    }

    public void deleteFeedType(Integer id) {
        FeedType feedType = feedTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feed type not found with ID: " + id));
        feedTypeRepository.delete(feedType);
    }
}
