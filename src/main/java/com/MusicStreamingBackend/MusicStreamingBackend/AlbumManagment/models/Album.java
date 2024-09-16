package com.MusicStreamingBackend.MusicStreamingBackend.AlbumManagment.models;

import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.Artist;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Models.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "albums")
public class Album {
    @Id
    @Column(name = "album_id", nullable = false)
    private Integer id;

    @Column(name = "album_name", nullable = false)
    private String albumName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

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