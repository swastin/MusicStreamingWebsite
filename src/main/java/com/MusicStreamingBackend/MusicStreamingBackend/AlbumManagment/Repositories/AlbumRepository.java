package com.MusicStreamingBackend.MusicStreamingBackend.AlbumManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.AlbumManagment.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}