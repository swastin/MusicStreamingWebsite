package com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.Artistgener;
import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.ArtistgenerId;

import org.springframework.data.repository.CrudRepository;

public interface ArtistgenreRepository extends CrudRepository<Artistgener, ArtistgenerId> {
}