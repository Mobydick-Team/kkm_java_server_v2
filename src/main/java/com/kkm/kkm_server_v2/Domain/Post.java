package com.kkm.kkm_server_v2.Domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;
    private String title;
    private String image_1;
    private String image_2;
    private String image_3;
    private String description;
    private LocalDateTime write_time = LocalDateTime.now();
    private long cost;
    private long state;
    private long type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_owner_id")
    private Users user;

    public Post( String title, String image_1, String image_2, String image_3, String description, long cost, long state, long type) {
        this.title = title;
        this.image_1 = image_1;
        this.image_2 = image_2;
        this.image_3 = image_3;
        this.description = description;
        this.cost = cost;
        this.state = state;
        this.type = type;
    }
}
