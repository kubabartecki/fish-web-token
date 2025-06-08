package com.fishwebtoken.api.store.feed;

import com.fishwebtoken.api.store.feed.type.FeedType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Feed {
    @Id
    @SequenceGenerator(
            name = "feed_id_sequence",
            sequenceName = "feed_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "feed_id_sequence"
    )
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "feed_type_id")
    private FeedType feedType;
    private float weight;
}
