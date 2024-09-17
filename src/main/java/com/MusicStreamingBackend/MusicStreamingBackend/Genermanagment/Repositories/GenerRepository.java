package com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Models.Couponcode;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Models.Gener;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenerRepository extends CrudRepository<Gener, Integer> {
   List<Gener> findAll();
    Optional<Gener> findByGenerName(String GenreName);
    Optional<Gener> findByGenerNameContaining(String GenreName);
}
