package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.Preference;
import org.springframework.data.repository.CrudRepository;

public interface PreferenceRepository extends CrudRepository<Preference, Integer> {
}