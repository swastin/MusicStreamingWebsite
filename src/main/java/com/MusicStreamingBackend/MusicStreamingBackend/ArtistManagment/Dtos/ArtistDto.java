package com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Dtos;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.Artist}
 */
@Value
public class ArtistDto implements Serializable {
    Integer id;
    String artistName;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}