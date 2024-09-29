package com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Models.Subscriptionplan;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.Language;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionplanRepository extends CrudRepository<Subscriptionplan, Integer> {
    List<Subscriptionplan> findAll();
    Optional<Subscriptionplan> findByPlanName(String planname);

    @Transactional
    @Modifying
    @Query("delete from Subscriptionplan s")
    int deleteFirstBy();
}