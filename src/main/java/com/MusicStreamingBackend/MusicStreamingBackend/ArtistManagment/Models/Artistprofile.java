package com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "artistprofiles")
public class Artistprofile {
    @Id
    @Column(name = "profile_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @Lob
    @Column(name = "bio")
    private String bio;

    @Column(name = "profile_picture")
    private String profilePicture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Column(name = "location")
    private String location;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

}