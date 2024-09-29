package com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Dto;

import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Models.Subscriptionplan;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for {@link Subscriptionplan}
 */
@Data
public class SubscriptionplanDto implements Serializable {
    Integer id;
    String planName;
    BigDecimal price;
    Integer durationMonths;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}