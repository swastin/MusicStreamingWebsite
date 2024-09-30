package com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {
    Optional<Artist> findByArtistName(String artistName);

    List<Artist> findAll();

}