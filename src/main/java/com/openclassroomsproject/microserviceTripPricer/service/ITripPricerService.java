package com.openclassroomsproject.microserviceTripPricer.service;

import tripPricer.Provider;
import java.util.List;
import java.util.UUID;

/**
 * @author jonathan GOUVEIA
 * @version 1.0
 */
public interface ITripPricerService {

    String getProviderName(String apiKey, int adults);

    List<Provider> getPrice(String apiKey, UUID attractionId, int adults, int children, int nightsStay, int rewardsPoints);
}