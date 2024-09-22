package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Models.Couponcode;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Dto.LanguageDto;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.Language;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
	  List<Language> findAll();
	  Optional<Language>  findByLanguageName(String Languagename);

}