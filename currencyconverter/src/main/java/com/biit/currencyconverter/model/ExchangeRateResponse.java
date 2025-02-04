package com.biit.currencyconverter.model;

import java.util.Map;

// This class represents the structure of the API response for exchange rates
public class ExchangeRateResponse {
    private String base; // Base currency (e.g., USD)
    private Map<String, Double> rates; // Map of currency codes and their corresponding exchange rates

    // Getter for the base currency
    public String getBase() {
        return base;
    }

    // Setter for the base currency
    public void setBase(String base) {
        this.base = base;
    }

    // Getter for the exchange rates map
    public Map<String, Double> getRates() {
        return rates;
    }

    // Setter for the exchange rates map
    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
