package com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Dto.GenerDto;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Exception.GenernamenotfoundException;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Exception.GenernotSavedException;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Exception.GenernotUpdatedException;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Exception.GenernotdeletedException;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Exception.GenernotfoundException;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Models.Gener;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Repositories.GenerRepository;

import lombok.extern.slf4j.Slf4j;

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


					return new GenernamenotfoundException("rror on Fetching gener with name:");
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
					return new GenernamenotfoundException("Error on Fetching gener with name");
				});
	}

	public GenerDto saveGener(GenerDto generDto) {
		try {
			Gener gener = generdtotoEntity(generDto);	
			Gener savedgener = genreRepository.save(gener);
			log.info("Gener is saved successfully with id:{} at {}",savedgener.getId(),savedgener.getCreatedAt());
			GenerDto generentitytoDto = generentitytoDto(savedgener);
			return generentitytoDto;
		}
		catch(GenernotSavedException exception){
			log.error("Error saving  gener name: Gener name  not found - {}",generDto.getGenerName(), exception);
			throw new GenernotSavedException("Gener is not saved try again!!");
		}
	}
	public GenerDto updateGener(GenerDto generDto) throws GenernotUpdatedException {
		Gener existingGener = genreRepository.findByGenerName(generDto.getGenerName()).orElseThrow(()->new GenernotfoundException("Gener is not found"));	
		existingGener.setGenerName(generDto.getGenerName());
		existingGener.setId(generDto.getId());
		existingGener.setCreatedAt(generDto.getCreatedAt());
		existingGener.setUpdatedAt(generDto.getUpdatedAt());
		Gener updatedGener = genreRepository.save(existingGener);
		
		log.info("Gener is updated successfully with id:{} at {}",updatedGener.getId(),updatedGener.getUpdatedAt());

		return generentitytoDto(updatedGener);
	}
	public void deleteGener(GenerDto generDto) {
		try {
			Gener existingGener = genreRepository.findByGenerName(generDto.getGenerName()).orElseThrow(()->new GenernotfoundException("Gener is not found"));	
			genreRepository.delete(existingGener);
			 log.info("Deleted Gener name: {}", generDto.getGenerName());
		}
	catch(GenernotdeletedException exception ) {   
		log.error("Error deleting gener name: {}", generDto.getGenerName(),exception);
		throw new GenernotdeletedException("Gener not deleted");
	}	
		
	}
}
