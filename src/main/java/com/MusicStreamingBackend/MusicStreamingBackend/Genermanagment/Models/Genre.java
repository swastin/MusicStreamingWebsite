package com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Models;

import com.MusicStreamingBackend.MusicStreamingBackend.AlbumManagment.models.Album;
import com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.models.Song;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "parentGenreId")
    private Genre parentGenre;

    @OneToMany(mappedBy = "genre")
    private List<Album> albums;

    @OneToMany(mappedBy = "genre")
    private List<Song> songs;

    // Getters and setters
}
