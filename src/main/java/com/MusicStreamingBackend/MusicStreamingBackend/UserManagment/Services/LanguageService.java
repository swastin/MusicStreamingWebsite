package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Services;
import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Exception.CouponCodeNotFound;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Dto.LanguageDto;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Exceptions.LanguageNameNotFound;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Exceptions.LanguageNotDeletedException;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Exceptions.LanguageNotSavedException;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Exceptions.LanguageNotUpdatedException;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Exceptions.languageCodeNotFound;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.Language;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Repositories.LanguageRepository;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class LanguageService {
	@Autowired
	private LanguageRepository languageRepository;
	@Autowired
	private  ModelMapper modelMapper;    
	private LanguageDto LanguageEntityToDto(Language language) {
		return modelMapper.map(language,LanguageDto.class);
	}
	private Language LanguageDtoToEntity(LanguageDto languageDto) {
		return modelMapper.map(languageDto,Language.class);
	}
	public List<LanguageDto> getAllLanguages() {
		List<Language> languages=languageRepository.findAll();

		if (languages.isEmpty()) {
			log.error("Error occurred, no languages found!");
			throw new LanguageNameNotFound("Language name not found");
		}      
		return languages.stream()
				.map(this::LanguageEntityToDto)
				.collect(Collectors.toList());
	}
	public LanguageDto getlanguage(String name) {
		log.info("Fetching language name  with code: {}", name);
		Optional<Language> LanguageName = languageRepository.findByLanguageName(name);
		return LanguageName.map(this::LanguageEntityToDto).orElseThrow(()->{
			log.error("Error occured ,Language Name not found !!");
			return new  LanguageNameNotFound("LanguageName not found");
		});
	}

	public LanguageDto saveLanguage(LanguageDto languageDto ) {
		try {
			log.info("Saving language  {}",languageDto.getLanguageName() );
			Language language = LanguageDtoToEntity( languageDto);
			Language savedLanguage = languageRepository.save(language);
			log.info("Language saved successfully with id {}",savedLanguage.getId()); 
			return  LanguageEntityToDto( language);  
		}
		catch(LanguageNotSavedException exception ) {
			
				log.error("Language is not saved :{} ",exception);
			throw new LanguageNotSavedException("Language is not saved");		   
		}

	}
	public LanguageDto updateLanguage(LanguageDto languageDto ) {
		try {
			log.info("Updating the language  {}",languageDto.getLanguageName() );
			Language language = languageRepository
					.findByLanguageName(languageDto.getLanguageName())
					.orElseThrow(()->
						 new  LanguageNameNotFound("LanguageName not found")
					);

			language.setId(languageDto.getId());
			language.setLanguageName(languageDto.getLanguageName());
			language.setCreatedAt(language.getCreatedAt());
			language.setUpdatedAt(language.getUpdatedAt());
			Language updateddLanguage = languageRepository.save(language);
			log.info("Language updated successfully with id {}",updateddLanguage.getId()); 
			return  LanguageEntityToDto( updateddLanguage);  
		}
		catch(LanguageNotUpdatedException exception ) {
			log.error("Language is not saved :{} ",exception);
			throw new LanguageNotUpdatedException("Language is not saved");		   
		}
	}
	public void deleteLanguage(LanguageDto languageDto ) {
		try {
			log.info("Deleting the language  {}",languageDto.getLanguageName() );
			Language language = languageRepository
					.findByLanguageName(languageDto.getLanguageName())
					.orElseThrow(() -> new LanguageNameNotFound("LanguageName not found")
					);

			languageRepository.delete(language);
		}
		catch(LanguageNotDeletedException exception ) {
			log.error("Language is not saved :{} ",exception);
			throw new LanguageNotDeletedException("Language is not saved");		   
		}   

	}
}

