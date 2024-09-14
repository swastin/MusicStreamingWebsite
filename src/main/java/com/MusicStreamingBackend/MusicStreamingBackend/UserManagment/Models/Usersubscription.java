package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models;

import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.models.Subscriptionplan;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "usersubscriptions")
public class Usersubscription {
    @EmbeddedId
    private UsersubscriptionId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @MapsId("planId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plan_id", nullable = false)
    private Subscriptionplan plan;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

}