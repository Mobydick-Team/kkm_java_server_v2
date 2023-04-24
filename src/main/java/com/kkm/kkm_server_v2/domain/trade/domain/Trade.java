package com.kkm.kkm_server_v2.domain.trade.domain;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.global.entity.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_trade")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Trade extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long giverId;

    private Long receiverId;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tradeTime;

    @ManyToOne
    @JoinColumn(name = "fk_post")
    private Post postId;

    @Builder
    public Trade(Long giverId, Long receiverId, LocalDateTime tradeTime, Post postId) {
        this.giverId = giverId;
        this.receiverId = receiverId;
        this.tradeTime = tradeTime;
        this.postId = postId;
    }
}