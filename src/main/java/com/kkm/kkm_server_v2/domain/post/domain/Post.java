package com.kkm.kkm_server_v2.domain.post.domain;

import com.kkm.kkm_server_v2.domain.jjam.domain.Jjam;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostStatus;
import com.kkm.kkm_server_v2.domain.post.exception.AlreadyPullPostException;
import com.kkm.kkm_server_v2.domain.post.exception.PostAccessWrongException;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.request.UpdatePostRequest;
import com.kkm.kkm_server_v2.domain.trade.domain.Trade;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.global.entity.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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

    @Enumerated(EnumType.STRING)
    private PostCategory category;

    @Enumerated(EnumType.STRING)
    private PostStatus status;
    private double longitude;
    private double latitude;
    private String address;

    public void updateStatus(PostStatus status) {
        this.status = status;
    }

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
    private List<PostImage> imageList;

    public void addImage(List<PostImage> images) {
        images.stream().map(item ->
                getImageList().add(item)
        ).close();
    }
    public void addAddress(double latitude, double longitude, String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Jjam> jjamList;

    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trade> tradeList;

    public void addJjam(Jjam jjam) {
        getJjamList().add(jjam);
    }

    public void updatePost(UpdatePostRequest data) {
        this.title = data.getTitle();
        this.content = data.getContent();
        this.price = data.getPrice();
        this.deposit = data.getDeposit();
        this.category = data.getCategory();
    }

    public void validatePermission(User author) {
        if (author.equals(this.author))
            throw PostAccessWrongException.EXCEPTION;
    }

    public void validateDate() {
        if (LocalDateTime.now().isAfter(this.pullDate.plusDays(3)))
            throw AlreadyPullPostException.EXCEPTION;
    }

    @Builder
    public Post(String title, String content, int price, int deposit, PostCategory category, double longitude, double latitude) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.deposit = deposit;
        this.category = category;
        this.pullDate = LocalDateTime.now();
        this.status = PostStatus.ACTIVE;
        this.imageList = new ArrayList<>();
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
