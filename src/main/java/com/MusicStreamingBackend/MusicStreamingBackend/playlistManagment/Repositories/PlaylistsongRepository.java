package com.MusicStreamingBackend.MusicStreamingBackend.playlistManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.playlistManagment.Models.Playlistsong;
import com.MusicStreamingBackend.MusicStreamingBackend.playlistManagment.Models.PlaylistsongId;
import org.springframework.data.repository.CrudRepository;

public interface PlaylistsongRepository extends CrudRepository<Playlistsong, PlaylistsongId> {
}