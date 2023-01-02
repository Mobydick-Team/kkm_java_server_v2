package com.kkm.kkm_server_v2.Domain;

import jdk.jfr.Name;
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
    private Long postId;
    private String title;
    private String image1;
    private String image2;
    private String image3;
    private String description;
    private LocalDateTime writeTime = LocalDateTime.now();
    private long cost;
    private long state;
    private long type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_owner_id")
    private Users user;

    public Post( String title, String image1, String image2, String image3, String description, long cost, long state, long type) {
        this.title = title;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.description = description;
        this.cost = cost;
        this.state = state;
        this.type = type;
    }
}
