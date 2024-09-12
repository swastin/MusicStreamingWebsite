package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models;

import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.Artist;
import com.MusicStreamingBackend.MusicStreamingBackend.FavouriteMnagment.Model.Favorites;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.models.SubscriptionPlan;
import com.MusicStreamingBackend.MusicStreamingBackend.playlistManagment.Models.Playlist;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
    @Data
@NoArgsConstructor
@AllArgsConstructor
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long userId;

        private String username;
        private String email;
        private String passwordHash;
        private LocalDate dateOfBirth;
        private String country;

        @ManyToOne
        @JoinColumn(name = "subscriptionPlanId")
        private SubscriptionPlan subscriptionPlan;

        private LocalDate joinDate;
        private String profilePictureUrl;

        @Column(columnDefinition = "TEXT")
        private String preferences; // stored as JSON

        @OneToMany(mappedBy = "user")
        private List<Playlist> playlists;

        @OneToMany(mappedBy = "user")
        private List<Favorites> favorites;

        @OneToMany(mappedBy = "user")
        @JoinTable(
                name = "user_artist",
                joinColumns = @JoinColumn(name = "userId"),
                inverseJoinColumns = @JoinColumn(name = "artistId"))
        private List<Artist> followedArtists;

        @ManyToMany
        @JoinTable(
                name = "user_playlist_follow",
                joinColumns = @JoinColumn(name = "userId"),
                inverseJoinColumns = @JoinColumn(name = "playlistId"))
        private List<Playlist> followedPlaylists;


    }


