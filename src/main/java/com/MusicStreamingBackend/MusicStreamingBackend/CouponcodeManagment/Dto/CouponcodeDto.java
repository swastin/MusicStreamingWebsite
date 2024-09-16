package com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Models.Couponcode}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponcodeDto implements Serializable {
    public Integer id;
    public String code;
   public  BigDecimal discountPercentage;
    public LocalDate expiryDate;

    public LocalDateTime createdAt;

    public LocalDateTime updatedAt;
}