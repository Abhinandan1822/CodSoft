package com.biit.currencyconverter.service;

import com.biit.currencyconverter.model.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service // Marks this class as a service component in Spring
public class CurrencyService {

    @Value("${exchange.api.url}") // Injects the API URL from application.properties
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate(); // RestTemplate is used to make HTTP requests

    // Method to fetch real-time exchange rates for a given base currency
    public ExchangeRateResponse getExchangeRates(String baseCurrency) {
        String url = apiUrl + baseCurrency; // Constructs the API URL with the selected base currency
        return restTemplate.getForObject(url, ExchangeRateResponse.class); // Makes a GET request and maps the response to ExchangeRateResponse
    }

    // Method to convert currency based on the fetched exchange rate
    public double convertCurrency(String baseCurrency, String targetCurrency, double amount) {
        ExchangeRateResponse response = getExchangeRates(baseCurrency); // Fetches exchange rates
        if (response != null && response.getRates().containsKey(targetCurrency)) {
            double rate = response.getRates().get(targetCurrency); // Retrieves the exchange rate for the target currency
            return amount * rate; // Calculates the converted amount
        }
        // Throws an error if the currency code is invalid
        throw new IllegalArgumentException("Invalid currency code provided.");
    }
}
