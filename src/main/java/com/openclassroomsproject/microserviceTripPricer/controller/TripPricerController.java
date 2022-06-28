package com.openclassroomsproject.microserviceTripPricer.controller;

import com.openclassroomsproject.microserviceTripPricer.service.ITripPricerService;
import com.openclassroomsproject.microserviceTripPricer.utils.CustomRequestLoggingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tripPricer.Provider;
import java.util.List;
import java.util.UUID;

/**
 * This is the controller of this microService
 *
 * @author jonathan GOUVEIA
 * @version 1.0
 */
@RestController
public class TripPricerController extends CustomRequestLoggingFilter {

    @Autowired
    private ITripPricerService tripPricerService;

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
    @GetMapping("/price")
    public List<Provider> getPrice(@RequestParam String apiKey,
                                   @RequestParam UUID attractionId,
                                   @RequestParam int adults,
                                   @RequestParam int children,
                                   @RequestParam int nightsStay,
                                   @RequestParam int rewardsPoints) {
        return tripPricerService.getPrice(apiKey, attractionId, adults, children, nightsStay, rewardsPoints);
    }

    /**
     *
     * @param apiKey It's a unique identifier that authenticates requests
     * @param adults integer, number of adults
     * @return A String corresponding
     */
    @GetMapping("/provider-name")
    public String getProviderName(@RequestParam String apiKey,
                                  @RequestParam int adults) {
        return tripPricerService.getProviderName(apiKey, adults);
    }
}