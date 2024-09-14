package com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.Artistgenre;
import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.ArtistgenreId;
import org.springframework.data.repository.CrudRepository;

public interface ArtistgenreRepository extends CrudRepository<Artistgenre, ArtistgenreId> {
}