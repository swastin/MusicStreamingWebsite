package com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}