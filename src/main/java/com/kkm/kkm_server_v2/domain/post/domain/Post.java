package com.kkm.kkm_server_v2.domain.post.domain;

import com.kkm.kkm_server_v2.domain.jjam.domain.Jjam;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostStatus;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.global.entity.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_post")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;

    private String content;

    @ColumnDefault("0")
    private int price;

    @ColumnDefault("0")
    private int deposit;

    private String process; // 거래 방법 추후 변경 예정

    @Enumerated(EnumType.STRING)
    private PostCategory category;

    @Enumerated(EnumType.STRING)
    private PostStatus status;

    public void updateStatus(PostStatus status) {
        this.status = status;
    }

    private boolean crumpled; // 구겨짐

    private boolean discoloration; // 변색

    private boolean pollution; // 오염

    private boolean ripped; // 찢어짐

    private LocalDateTime pullDate;
    public void pull() {
        this.pullDate = LocalDateTime.now();
    }


    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User author;

    public void setAuthor(User author) {
        this.author = author;
    }

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> imageList;

    public void addImage(List<Image> images) {
        images.stream().map(item ->
                getImageList().add(item)
        ).close();
    }

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Jjam> jjamList;

    public void addJjam(Jjam jjam) {
        getJjamList().add(jjam);
    }

    public void updatePost(String title, String content, int price, int deposit, String process, PostCategory category,
                           boolean crumpled, boolean discoloration, boolean pollution, boolean ripped) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.deposit = deposit;
        this.process = process;
        this.category = category;
        this.crumpled = crumpled;
        this.discoloration = discoloration;
        this.pollution = pollution;
        this.ripped = ripped;
    }

    @Builder
    public Post(String title, String content, int price, int deposit, String process, PostCategory category,
                boolean crumpled, boolean discoloration, boolean pollution, boolean ripped) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.deposit = deposit;
        this.process = process;
        this.category = category;
        this.crumpled = crumpled;
        this.discoloration = discoloration;
        this.pollution = pollution;
        this.ripped = ripped;
        this.pullDate = LocalDateTime.now();
        this.status = PostStatus.ACTIVE;
        this.imageList = new ArrayList<>();
    }
}
