package com.MusicStreamingBackend.MusicStreamingBackend.playlistManagment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}