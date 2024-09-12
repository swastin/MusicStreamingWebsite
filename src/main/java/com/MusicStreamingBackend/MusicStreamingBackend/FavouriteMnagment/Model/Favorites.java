package com.MusicStreamingBackend.MusicStreamingBackend.FavouriteMnagment.Model;

import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.Artist;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.User;
import com.MusicStreamingBackend.MusicStreamingBackend.playlistManagment.Models.Playlist;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "favorites")
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followId;

    @ManyToOne
    @JoinColumn(name = "followerUserId")
    private User follower;

    @ManyToOne
    @JoinColumn(name = "followedArtistId", nullable = true)
    private Artist followedArtist;

    @ManyToOne
    @JoinColumn(name = "followedPlaylistId", nullable = true)
    private Playlist followedPlaylist;

    private LocalDate dateFollowed;

    // Getters and setters
}