package com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.models.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Integer> {
  }