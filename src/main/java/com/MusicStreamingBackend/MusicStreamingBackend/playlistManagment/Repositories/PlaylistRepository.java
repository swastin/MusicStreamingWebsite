package com.MusicStreamingBackend.MusicStreamingBackend.playlistManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.playlistManagment.Models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}