package com.kkm.kkm_server_v2.domian.category.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private CategoryType type;
    public enum CategoryType {
        상의, 치마, 바지, 악세사리, 신발, 가방, 원피스, 패션소품, 기타
    }
}
