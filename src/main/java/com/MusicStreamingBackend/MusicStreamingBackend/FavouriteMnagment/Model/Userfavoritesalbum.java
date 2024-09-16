package com.MusicStreamingBackend.MusicStreamingBackend.FavouriteMnagment.Model;

import com.MusicStreamingBackend.MusicStreamingBackend.AlbumManagment.models.Album;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "userfavoritesalbum")
public class Userfavoritesalbum {
    @Id
    @Column(name = "favorite_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

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