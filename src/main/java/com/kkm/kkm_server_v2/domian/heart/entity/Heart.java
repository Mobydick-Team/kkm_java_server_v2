package com.kkm.kkm_server_v2.domian.heart.entity;

import com.kkm.kkm_server_v2.domian.post.entity.Post;
import com.kkm.kkm_server_v2.domian.user.entity.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Heart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "giverId" , nullable = false)
    private User giver;

    @ManyToOne
    @JoinColumn(name = "receiverId", nullable = false)
    private User receiver;

    @Column
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime pressed_time;

    @Column(nullable = false)
    private boolean isPressing;

}
