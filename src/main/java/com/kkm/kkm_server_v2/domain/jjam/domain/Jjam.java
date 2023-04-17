package com.kkm.kkm_server_v2.domain.jjam.domain;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.global.entity.BaseTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_jjam")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Jjam extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 38)
    private String post_id;
    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User agent;

    public void setAgent(User agent) {
        this.agent = agent;
    }

    @ManyToOne
    @JoinColumn(name = "fk_post")
    private User post;

    public void setPost(User post) {
        this.agent = post;
    }


}