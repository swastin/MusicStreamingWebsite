package com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.models.Songartist;
import com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.models.SongartistId;
import org.springframework.data.repository.CrudRepository;

public interface SongartistRepository extends CrudRepository<Songartist, SongartistId> {
}