package com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}