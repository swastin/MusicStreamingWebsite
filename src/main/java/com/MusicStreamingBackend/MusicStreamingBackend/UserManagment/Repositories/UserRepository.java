package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
