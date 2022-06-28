package com.openclassroomsproject.microserviceTripPricer.service.impl;

import com.openclassroomsproject.microserviceTripPricer.service.ITripPricerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tripPricer.Provider;
import tripPricer.TripPricer;
import java.util.List;
import java.util.UUID;

/**
 * This class contains the methods allowing to call the functions of the TripPricer library
 *
 * @author jonathan GOUVEIA
 * @version 1.0
 */
@Service
public class TripPricerImpl implements ITripPricerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TripPricerImpl.class);
    private final TripPricer tripPricer;

    /**
     * Constructor
     *
     * @param tripPricer The library used by the methods of this class
     */
    public TripPricerImpl(TripPricer tripPricer) {
        this.tripPricer = tripPricer;
    }

    /**
     * @param apiKey It's a unique identifier that authenticates requests
     * @param adults integer, number of adults
     * @return A String corresponding
     */
    @Override
    public String getProviderName(String apiKey, int adults) {
        LOGGER.info("#[MS-TripPricer]-> Call - SERVICE: getProviderName(String apiKey, int adults) method ");
        return tripPricer.getProviderName(apiKey, adults);
    }

    /**
     * This method allow you to calculate, for an attraction, the providers price according to the parameters requested:
     * number of adults, number of children, number of nights, reward points
     *
     * @param apiKey It's a unique identifier that authenticates requests
     * @param attractionId Unique identifier of an attraction
     * @param adults Integer, number of adults
     * @param children Integer, number of children
     * @param nightsStay Integer, number of nights required
     * @param rewardsPoints Integer corresponding to the number of reward points
     * @return A list of provider object from the TripPricer library. Each object contain an id, a name and a price
     */
    @Override
    public List<Provider> getPrice(String apiKey, UUID attractionId, int adults, int children, int nightsStay, int rewardsPoints) {
        LOGGER.info("#[MS-TripPricer]-> Call - SERVICE: getPrice(String apiKey, UUID attractionId, int adults, int children, int nightsStay, int rewardsPoints) method ");
        return tripPricer.getPrice(apiKey, attractionId, adults, children, nightsStay, rewardsPoints);
    }
}