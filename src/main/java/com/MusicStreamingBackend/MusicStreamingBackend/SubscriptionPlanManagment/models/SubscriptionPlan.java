package com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.models;

import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionPlanId;

    private String name;
    private Double price;
    private String description;
    private Integer maxDevices;
    private Integer maxDownloads;
    private Boolean isPremium;

    @OneToMany(mappedBy = "subscriptionPlan")
    private List<User> users;

    // Getters and setters
}
