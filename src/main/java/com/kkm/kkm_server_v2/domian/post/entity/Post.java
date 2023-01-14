package com.kkm.kkm_server_v2.domian.post.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false,length = 38)
    private String title;

    @Column
    private String image_1;

    @Column
    private String image_2;

    @Column
    private String image_3;

    @Column
    private String description;

    @Column
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime write_time;

//    @Column
//    private Long category
//    카테고리 테이블을 만들어야할까!?!?!?!??!
    @Column(nullable = false)
    private Long cost;

    @Column(nullable = false)
    private Long state;

}
