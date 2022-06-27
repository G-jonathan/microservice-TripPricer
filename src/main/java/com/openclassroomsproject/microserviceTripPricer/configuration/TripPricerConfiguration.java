package com.openclassroomsproject.microserviceTripPricer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tripPricer.TripPricer;

/**
 * Spring Configuration class
 *
 * @author jonathan GOUVEIA
 * @version 1.0
 */
@Configuration
public class TripPricerConfiguration {

    /**
     * Allows to load the library in the spring context
     *
     * @return The library used by this microservice
     */
    @Bean
    public TripPricer getTripPricer() {
        return new TripPricer();
    }
}