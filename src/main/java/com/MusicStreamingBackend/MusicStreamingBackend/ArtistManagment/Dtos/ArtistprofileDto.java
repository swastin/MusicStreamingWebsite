package com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Dtos;

import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Dto.GenerDto;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.Artistprofile}
 */
@Value
public class ArtistprofileDto implements Serializable {
    Integer id;
    ArtistDto artist;
    String bio;
    String profilePicture;
    GenerDto gener;
    String location;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}