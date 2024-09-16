package com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.models;

import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.Artist;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "songartists")
public class Songartist {
    @EmbeddedId
    private SongartistId id;

    @MapsId("songId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

    @MapsId("artistId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @Column(name = "CreatedAt", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "UpdateAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;


}