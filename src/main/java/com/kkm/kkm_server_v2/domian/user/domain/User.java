package com.kkm.kkm_server_v2.domian.user.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tb_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(unique = true, nullable = false, length = 38)
    private String nickname;

    @Column(unique = true, nullable = false)
    private String userId;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private long kkm;

    @Column(name = "ROLE", length = 4, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Builder
    public User(String nickname, String userId, String imgUrl, double latitude, double longitude, String address, Role role) {
        this.nickname = nickname;
        this.userId = userId;
        this.imgUrl = imgUrl;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.role = role;
    }
}
