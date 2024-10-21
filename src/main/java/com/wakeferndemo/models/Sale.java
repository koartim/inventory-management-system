package com.wakeferndemo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    private int quantitySold;
    private BigDecimal totalPrice;

    @Column(updatable = false)
    private LocalDateTime soldAt;

    @PrePersist
    protected void onCreate() {
        this.soldAt = LocalDateTime.now();
    }
}
