package com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.models;
import com.MusicStreamingBackend.MusicStreamingBackend.AlbumManagment.models.Album;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Models.Genre;
import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.Artist;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.User;
import com.MusicStreamingBackend.MusicStreamingBackend.playlistManagment.Models.Playlist;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Song", indexes = {
        @Index(name = "idx_song_artistid", columnList = "artistId")
})
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;

    private String title;
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "albumId")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "artistId")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "genreId")
    private Genre genre;

    private String fileUrl;
    private String lyrics;
    private String language;
    private LocalDate releaseDate;
    private Long playCount;
    private Long likeCount;

    @ManyToMany(mappedBy = "songs")
    private List<Playlist> playlists;

    @ManyToMany(mappedBy = "favorites")
    private List<User> usersWhoFavorited;

//    @ManyToMany
//    @JoinTable(
//            name = "song_tag",
//            joinColumns = @JoinColumn(name = "songId"),
//            inverseJoinColumns = @JoinColumn(name = "tagId"))
//    //private List<Tag> tags;
//
//    // Getters and setters
}
