package com.kkm.kkm_server_v2.domain.review.domain;

import com.kkm.kkm_server_v2.domain.review.domain.enums.RecieveKkomak;
import com.kkm.kkm_server_v2.domain.trade.domain.Trade;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_review")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private RecieveKkomak kkm;
    private String content;
    @OneToOne
    @JoinColumn(name = "fk_trade")
    private Trade source;
    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User owner;

    @Builder
    public Review(RecieveKkomak kkm, String content, Trade source, User owner){
        this.kkm = kkm;
        this.content = content;
        this.source = source;
        this.owner = owner;
    }
}
