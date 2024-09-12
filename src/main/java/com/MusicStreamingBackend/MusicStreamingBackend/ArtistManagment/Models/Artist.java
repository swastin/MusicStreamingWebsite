package com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models;

import com.MusicStreamingBackend.MusicStreamingBackend.AlbumManagment.models.Album;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.User;
import com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.models.Song;
import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistId;

    private String name;
    private String country;

    @Column(columnDefinition = "TEXT")
    private String bio;

    private String profilePictureUrl;

    @Column(columnDefinition = "TEXT")
    private String socialLinks; // stored as JSON

    private Boolean isVerified;

    @OneToMany(mappedBy = "artist")
    private List<Album> albums;

    @OneToMany(mappedBy = "artist")
    private List<Song> songs;

    @ManyToMany(mappedBy = "followedArtists")
    private List<User> followers;

//    @ManyToMany
//    @JoinTable(
//            name = "artist_collaboration",
//            joinColumns = @JoinColumn(name = "artistId"),
//            inverseJoinColumns = @JoinColumn(name = "songId"))
//    private List<Song> collaborations;

    // Getters and setters

}