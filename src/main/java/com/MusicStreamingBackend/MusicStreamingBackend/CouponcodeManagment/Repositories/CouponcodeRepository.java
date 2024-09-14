package com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Models.Couponcode;
import org.springframework.data.repository.CrudRepository;

public interface CouponcodeRepository extends CrudRepository<Couponcode, Integer> {
}