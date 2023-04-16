package com.kkm.kkm_server_v2.domain.post.domain;

import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.global.entity.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "tb_post")
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;

    private String content;

    @ColumnDefault("0")
    private int price;

    private String process; // 거래 방법 추후 변경 예정

    @Enumerated(EnumType.STRING)
    private PostCategory category;

    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User author;
    public void setAuthor(User author) {
        this.author = author;
    }

    public void updatePost(String title, String content, int price, String process, PostCategory category) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.process = process;
        this.category = category;
    }

    @Builder
    public Post(String title, String content, int price, String process, PostCategory category) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.process = process;
        this.category = category;
    }
}
