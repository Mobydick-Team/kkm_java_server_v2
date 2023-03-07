package com.kkm.kkm_server_v2.domian.trade.entity;

import com.kkm.kkm_server_v2.domian.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User lender;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User borrower;

    @Column
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime time;

}
