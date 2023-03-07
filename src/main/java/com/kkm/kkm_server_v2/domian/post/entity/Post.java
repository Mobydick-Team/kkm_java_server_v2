package com.kkm.kkm_server_v2.domian.post.entity;

import com.kkm.kkm_server_v2.domian.category.entity.Category;
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

    @ManyToOne
    @JoinColumn(nullable = false)
    private Category category;

    @Column(nullable = false)
    private Long cost;

    @Column(nullable = false)
    private Long state;

    @Column(nullable = false)
    private boolean pollution;

    @Column(nullable = false)
    private boolean discoloration;

    @Column(nullable = false)
    private boolean ripped;

    @Column(nullable = false)
    private boolean crumpled;


}
