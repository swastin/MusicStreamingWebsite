package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, Integer> {
}