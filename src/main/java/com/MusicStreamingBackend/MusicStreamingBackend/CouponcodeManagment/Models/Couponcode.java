package com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "couponcodes")
public class Couponcode {
    @Id
    @Column(name = "coupon_id", nullable = false)
    private Integer id;

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "discount_percentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal discountPercentage;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

//    @ColumnDefault("CURRENT_TIMESTAMP")
//    @Column(name = "created_at")
//    private Instant createdAt;
//
//    @ColumnDefault("CURRENT_TIMESTAMP")
//    @Column(name = "updated_at")
//    private Instant updatedAt;
@Column(name = "CreatedAt", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
private LocalDateTime createdAt;

    @Column(name = "UpdateAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;


}