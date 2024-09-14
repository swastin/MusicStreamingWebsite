package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
  }