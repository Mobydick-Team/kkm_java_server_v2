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

    private Long post_owner_id;
    private String title;
    private String image_1;
    private String image_2;
    private String image_3;
    private String description;
    private LocalDateTime write_time = LocalDateTime.now();
    private long cost;
    private long state;
    private long type;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private Users user;



}
