package com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Exceptions;

public class subscriptionplanNotFound extends RuntimeException {
    public subscriptionplanNotFound(String languageNameNotFound) {
    super(languageNameNotFound);
    }
}
