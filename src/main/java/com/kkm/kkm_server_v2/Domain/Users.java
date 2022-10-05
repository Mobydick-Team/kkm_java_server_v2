package com.kkm.kkm_server_v2.Domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String nickname;
    @Column(name = "k_id")
    private String kId;
    @Column(name = "k_img_url")
    private String kImgUrl;
    private double lat;
    private double lon;
    private String address;
    private long kkm;
    @OneToMany(mappedBy = "user")
    private List<Post> post = new ArrayList<Post>();


    public Users( Long userId,String nickname, String kId, String kImgUrl, double lat, double lon, String address, long kkm) {
        this.userId=userId;
        this.kId = kId;
        this.nickname = nickname;
        this.kImgUrl = kImgUrl;
        this.lat = lat;
        this.lon = lon;
        this.address = address;
        this.kkm=kkm;
    }

    public Long getUserId() {
        return userId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getKId() {
        return kId;
    }

    public String getKImgUrl() {
        return kImgUrl;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getAddress() {
        return address;
    }

    public long getKkm() {
        return kkm;
    }

    public List<Post> getPost() {
        return post;
    }
}
