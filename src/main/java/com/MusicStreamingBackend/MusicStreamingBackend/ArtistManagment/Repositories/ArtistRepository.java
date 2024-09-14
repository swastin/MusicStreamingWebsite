package com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {
}