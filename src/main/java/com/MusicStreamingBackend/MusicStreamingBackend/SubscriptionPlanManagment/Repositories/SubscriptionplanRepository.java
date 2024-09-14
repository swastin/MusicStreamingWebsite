package com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Repositories;

import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.models.Subscriptionplan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionplanRepository extends CrudRepository<Subscriptionplan, Integer> {
}