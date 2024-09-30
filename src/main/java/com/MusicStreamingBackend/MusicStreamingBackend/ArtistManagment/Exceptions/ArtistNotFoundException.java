package com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Exceptions;

import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Dtos.ArtistDto;

import java.util.List;

public class ArtistNotFoundException extends RuntimeException{
    public ArtistNotFoundException(String artistNotFoundException) {
        super(artistNotFoundException);
    }
}
