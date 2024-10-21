package com.wakeferndemo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "restocking_requests")
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

    public RestockingRequest() {
    }

    public RestockingRequest(Item item, int requested_quantity, String requestStatus, LocalDateTime requestedAt) {
        this.item = item;
        this.requested_quantity = requested_quantity;
        this.requestStatus = requestStatus;
        this.requestedAt = requestedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getRequested_quantity() {
        return requested_quantity;
    }

    public void setRequested_quantity(int requested_quantity) {
        this.requested_quantity = requested_quantity;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    @PrePersist
    protected void onCreate() {
        this.requestedAt = LocalDateTime.now();
    }
}
