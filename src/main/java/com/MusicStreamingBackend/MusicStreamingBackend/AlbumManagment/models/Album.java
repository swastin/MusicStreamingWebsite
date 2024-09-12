package com.MusicStreamingBackend.MusicStreamingBackend.AlbumManagment.models;

import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Models.Genre;
import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.Artist;
import com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.models.Song;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;

    private String title;
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "genreId")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "artistId")
    private Artist artist;

    private String coverImageUrl;
    private String label;
    private Integer totalTracks;
    private Integer duration;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

//    @ManyToMany
//    @JoinTable(
//            name = "album_tag",
//            joinColumns = @JoinColumn(name = "albumId"),
//            inverseJoinColumns = @JoinColumn(name = "tagId"))
//    private List<Tag> tags;

    // Getters and setters
}