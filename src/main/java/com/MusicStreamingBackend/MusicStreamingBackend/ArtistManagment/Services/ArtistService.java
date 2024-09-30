package com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Services;

import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Dtos.ArtistDto;
import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Exceptions.ArtistNotDeletedException;
import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Exceptions.ArtistNotFoundException;
import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models.Artist;
import com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Repositories.ArtistRepository;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Exceptions.LanguageNameNotFound;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Exceptions.LanguageNotDeletedException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Converts Artist to ArtistDto
    public ArtistDto ArtistToArtistDto(Artist artist) {
        return modelMapper.map(artist, ArtistDto.class);
    }

    // Converts ArtistDto to Artist
    public Artist ArtistDtoToArtist(ArtistDto artistDto) {
        return modelMapper.map(artistDto, Artist.class);
    }

    // Fetch all artists
    public List<ArtistDto> getAllArtists() {
        log.info("Fetching all artists");
        List<Artist> artists = artistRepository.findAll();
        if (artists.isEmpty()) {
            log.warn("No artists found");
            throw new ArtistNotFoundException("No artists found");
        }
        log.info("Found {} artists", artists.size());
        return artists.stream()
                .map(this::ArtistToArtistDto)
                .collect(Collectors.toList());
    }

    // Fetch artist by artistName
    public ArtistDto getArtistByArtistName(String artistName) {
        log.info("Fetching artist by name: {}", artistName);
        Optional<Artist> artist = artistRepository.findByArtistName(artistName);
        return artist.map(this::ArtistToArtistDto)
                .orElseThrow(() -> {
                    log.warn("Artist not found with name: {}", artistName);
                    return new ArtistNotFoundException("Artist not found with name: " + artistName);
                });
    }

    // Create a new artist
    public ArtistDto createArtist(ArtistDto artistDto) {
        log.info("Creating new artist with name: {}", artistDto.getArtistName());
        Artist savedArtist = artistRepository.save(ArtistDtoToArtist(artistDto));
        log.info("Artist created successfully with ID: {}", savedArtist.getId());
        return ArtistToArtistDto(savedArtist);
    }

    // Update an existing artist
    public ArtistDto updateArtist(ArtistDto artistDto) {
        log.info("Updating artist with name: {}", artistDto.getArtistName());
        Artist artist = artistRepository.findByArtistName(artistDto.getArtistName())
                .orElseThrow(() -> {
                    log.warn("Artist not found with name: {}", artistDto.getArtistName());
                    return new ArtistNotFoundException("Artist not found with name: " + artistDto.getArtistName());
                });
        artist.setArtistName(artistDto.getArtistName());
        Artist updatedArtist = artistRepository.save(artist);
        log.info("Artist updated successfully with name: {}", updatedArtist.getArtistName());
        return ArtistToArtistDto(updatedArtist);
    }

    // Delete an artist
    public void deleteArtist(ArtistDto artistDto) throws ArtistNotDeletedException {
        log.info("Attempting to delete artist with name: {}", artistDto.getArtistName());
        Artist artist = artistRepository.findByArtistName(artistDto.getArtistName())
                .orElseThrow(() -> {
                    log.warn("Artist not found with name: {}", artistDto.getArtistName());
                    return new ArtistNotFoundException("Artist not found with name: " + artistDto.getArtistName());
                });

        try {
            artistRepository.delete(artist);
            log.info("Artist deleted successfully with name: {}", artistDto.getArtistName());
        } catch (Exception e) {
            log.error("Failed to delete artist with name: {}. Error: {}", artistDto.getArtistName(), e.getMessage());
            throw new ArtistNotDeletedException("Artist could not be deleted with name: " + artistDto.getArtistName());
        }
    }
}
