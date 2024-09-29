package com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "couponcodes")
public class Couponcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id", nullable = false)
    private Integer id;

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "discount_percentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal discountPercentage;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void beforeSave() {
        log.info("Attempting to add coupon code with code {}", code);
    }

    @PostPersist
    public void afterSave() {
        log.info("Coupon code {} with ID {} added successfully at {}", code, id, createdAt);
    }

    @PostUpdate
    public void afterUpdate() {
        log.info("Coupon code {} with ID {} updated successfully at {}", code, id, updatedAt);
    }

    @PreUpdate
    public void beforeUpdate() {
        log.info("Attempting to update coupon code with code {}", code);
    }

    @PreRemove
    public void beforeDelete() {
        log.info("Attempting to delete coupon code with code {}", code);
    }

    @PostRemove
    public void afterDelete() {
        log.info("Coupon code {} with ID {} deleted successfully at {}", code, id, updatedAt);
    }
}
