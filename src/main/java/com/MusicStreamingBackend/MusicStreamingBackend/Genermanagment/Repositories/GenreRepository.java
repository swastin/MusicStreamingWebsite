package com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Models.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
}