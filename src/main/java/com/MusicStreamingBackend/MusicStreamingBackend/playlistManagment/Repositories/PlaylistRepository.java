package com.MusicStreamingBackend.MusicStreamingBackend.playlistManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.playlistManagment.Models.Playlist;
import org.springframework.data.repository.CrudRepository;

public interface PlaylistRepository extends CrudRepository<Playlist, Integer> {
}