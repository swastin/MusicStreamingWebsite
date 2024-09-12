package com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}