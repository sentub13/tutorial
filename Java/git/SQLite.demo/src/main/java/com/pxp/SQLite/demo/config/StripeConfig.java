package com.pxp.SQLite.demo.config;

import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {

    @Value("{stripe.apikey}")
    private String stripeApiKey;

    @Bean
    public void initializeStripe(){
        Stripe.apiKey = stripeApiKey;
    }
}
