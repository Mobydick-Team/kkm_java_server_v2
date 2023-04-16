package com.kkm.kkm_server_v2.domain.post.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_image")
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    private String url;

    @ManyToOne
    @JoinColumn(name = "fk_post")
    private Post post;
    public void setPost(Post post) {
        this.post = post;
    }

    @Builder
    public Image(String url) {
        this.url = url;
    }
}
