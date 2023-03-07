package com.kkm.kkm_server_v2.domian.report.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(unique = true,nullable = false)
    private int type;

    @Column(unique = true,nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private String details;

}
