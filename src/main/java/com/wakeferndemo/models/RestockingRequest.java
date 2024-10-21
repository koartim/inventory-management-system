package com.wakeferndemo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RestockingRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    private int requested_quantity;

    private String requestStatus;

    @Column(updatable = false)
    private LocalDateTime requestedAt;

    @PrePersist
    protected void onCreate() {
        this.requestedAt = LocalDateTime.now();
    }
}
