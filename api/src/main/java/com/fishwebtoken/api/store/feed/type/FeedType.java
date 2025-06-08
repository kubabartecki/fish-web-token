package com.fishwebtoken.api.store.feed.type;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FeedType {
    @Id
    @SequenceGenerator(
            name = "feed_type_id_sequence",
            sequenceName = "feed_type_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "feed_type_id_sequence"
    )
    @Column(name = "feed_type_id")
    private Integer id;
    private String name;
}
