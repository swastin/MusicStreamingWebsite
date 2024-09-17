package com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Services;

import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Exception.CouponCodeNotFound;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Dto.GenerDto;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Exception.GenernamenotfoundException;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Exception.GenernotfoundException;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Models.Gener;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Repositories.GenerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GenerService {
    @Autowired
    private GenerRepository genreRepository;

    private Gener generdtotoEntity(GenerDto generdto) {
        Gener gener = new Gener();
        gener.setId(generdto.getId());
        gener.setGenerName(generdto.getGenerName());
        gener.setCreatedAt(generdto.getCreatedAt());
        gener.setUpdatedAt(generdto.getUpdatedAt());
        return gener;
    }

    private GenerDto generentitytoDto(Gener gener) {
        return new GenerDto(gener.getId(), gener.getGenerName(), gener.getCreatedAt(), gener.getUpdatedAt());
    }

    public GenerDto getGenreById(int id) {
        log.info("Fetching gener with id: {}", id);
        return genreRepository.findById(id)
                .map(this::generentitytoDto)
                .orElseThrow(() -> {
                    log.error("Error on Fetching gener with id: {}", id);
                    return new GenernotfoundException("Gener is not found");
                });
    }

    public GenerDto getGenreByName(String name) {
        log.info("Fetching gener with name: {}", name);
        return genreRepository.findByGenerName(name)
                .map(this::generentitytoDto)
                .orElseThrow(() -> {
                    log.error("Error on Fetching gener with name: {}", name);
                    return new GenernamenotfoundException();
                });


    }

    public List<GenerDto> getAllGenre(String name) {
        log.info("Fetching  All gener with name");
        List<GenerDto> allgener = Optional.ofNullable(genreRepository.findAll())
                .filter(names -> !names.isEmpty())
                .map(
                        names -> names
                                .stream()
                                .map(this::generentitytoDto)
                                .collect(Collectors.toList())
                ).orElseThrow(() -> {
                    log.error("Error occured ,Gener is not found !!");
                    return new GenernotfoundException("Gener is not found");
                });
        log.info("total gener  found{}", allgener.size());
        return allgener;

    }

    public GenerDto searchGenreByName(String name) {
        log.info("Fetching gener with name: {}", name);
        return genreRepository.findByGenerNameContaining(name)
                .map(this::generentitytoDto)
                .orElseThrow(() -> {
                    log.error("Error on Fetching gener with name: {}", name);
                    return new GenernamenotfoundException();
                });
    }
}
