package com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Models.Couponcode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CouponcodeRepository extends JpaRepository<Couponcode, Integer> {
    List<Couponcode> findAll();
    Optional<Couponcode> findByCode(String code);
}