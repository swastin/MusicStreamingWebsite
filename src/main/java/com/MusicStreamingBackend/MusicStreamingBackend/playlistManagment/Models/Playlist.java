package com.MusicStreamingBackend.MusicStreamingBackend.playlistManagment.Models;

import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.User;
import com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.models.Song;
import jakarta.persistence.*;
import lombok.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playlistId;

    private String name;
    private String description;
    private LocalDate createdDate;
    private Boolean isPublic;
    private String coverImageUrl;
    private Long likeCount;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "playlist_song",
            joinColumns = @JoinColumn(name = "playlistId"),
            inverseJoinColumns = @JoinColumn(name = "songId"))
    private List<Song> songs;

    @ManyToMany(mappedBy = "followedPlaylists")
    private List<User> followers;

    // Getters and setters
}