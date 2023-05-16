package com.kkm.kkm_server_v2.domain.user.domain;

import com.kkm.kkm_server_v2.domain.jjam.domain.Jjam;
import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.review.domain.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 38)
    private String nickname;

    @Column(unique = true, nullable = false)
    private String userId;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int kkm;

    @Enumerated(EnumType.STRING)
    private Role role;
    private int tradeCount;

    public void updateTradeCount(int tradeCount) {
        this.tradeCount = tradeCount;
    }

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> postList;

    public void addPost(Post post) {
        getPostList().add(post);
    }

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Jjam> jjamList;

    public List<Post> getJjamPostList() {
        return getJjamList().stream().map(Jjam::getPost).collect(Collectors.toList());
    }

    public void addJjam(Jjam jjam) {
        getJjamList().add(jjam);
    }

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList;

    public String getUsername() {
        return null;
    }

    public void updateKkm(int kkm) {
        this.kkm = kkm;
    }

    @Builder
    public User(String nickname, String userId, String imgUrl, double latitude, double longitude, String address, Role role, int kkm) {
        this.nickname = nickname;
        this.userId = userId;
        this.imgUrl = imgUrl;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.role = role;
        this.postList = new ArrayList<>();
        this.kkm = kkm;

    }
}
