package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Dto.PreferenceDto;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.Preference;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Repositories.PreferenceRepository;

public class PreferenceService {
	@Autowired
	 private PreferenceRepository preferenceRepository;
	   @Autowired
	 private  ModelMapper modelMapper;
	    
	    private PreferenceDto PreferenceEntityToDto(Preference preference) {
	    	return modelMapper.map(preference,PreferenceDto.class);
	    }
	    private Preference PreferenceDtoToEntity(PreferenceDto preferenceDto) {
	    	return modelMapper.map(preferenceDto,Preference.class);
	    }
}
