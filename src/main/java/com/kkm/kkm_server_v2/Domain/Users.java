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
    private Long user_id;
    private String nickname;
    private String k_id;
    private String k_img_url;
    private double lat;
    private double lon;
    private String address;
    private long kkm;
    @OneToMany(mappedBy = "user")
    private List<Post> post = new ArrayList<Post>();


    public Users( Long user_id,String nickname, String k_id, String k_img_url, double lat, double lon, String address, long kkm) {
        this.user_id=user_id;
        this.k_id = k_id;
        this.nickname = nickname;
        this.k_img_url = k_img_url;
        this.lat = lat;
        this.lon = lon;
        this.address = address;
        this.kkm=kkm;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getK_id() {
        return k_id;
    }

    public String getK_img_url() {
        return k_img_url;
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
