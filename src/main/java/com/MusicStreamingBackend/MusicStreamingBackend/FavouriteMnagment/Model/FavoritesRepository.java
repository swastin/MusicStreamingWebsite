package com.MusicStreamingBackend.MusicStreamingBackend.FavouriteMnagment.Model;

import org.springframework.data.repository.CrudRepository;

public interface FavoritesRepository extends CrudRepository<Favorites, Long> {
  }