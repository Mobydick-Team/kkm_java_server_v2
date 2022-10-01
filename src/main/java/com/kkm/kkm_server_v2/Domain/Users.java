//package com.kkm.kkm_server_v2.Domain;
//
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//
//@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class Users {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long user_id;
//    private String nickname;
//    private String k_id;
//    private String k_img_url;
//    private double lat;
//    private double lon;
//    private String address;
//    private long kkm;
////    @OneToMany(mappedBy = "user")
////    private List<Post> post = new ArrayList<>();
//
//
////    public Users(Object user_id, String nickname, String k_id, String k_img_url, double lat, double lon, String address, long kkm) {
////
////        this.k_id = k_id;
////        this.nickname = nickname;
////        this.k_img_url = k_img_url;
////        this.lat = lat;
////        this.lon = lon;
////        this.address = address;
////        this.kkm=kkm;
////    }
//}
