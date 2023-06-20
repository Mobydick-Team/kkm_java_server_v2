package com.kkm.kkm_server_v2.domain.location.domain;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_location")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user")
    private User userLocation;

    @Column(nullable = false)
    private boolean selected;

    public void updateLocation(String address, double latitude, double longitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public void updateSelected(boolean selected) {
        this.selected = selected;
    }

    @Builder
    public Location(String address, double latitude, double longitude, User userLocation, boolean selected) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.userLocation = userLocation;
        this.selected = selected;
    }
}
