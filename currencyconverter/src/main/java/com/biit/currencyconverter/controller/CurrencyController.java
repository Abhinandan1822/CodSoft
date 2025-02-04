package com.biit.currencyconverter.controller;

import com.biit.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Marks this class as a Spring MVC controller
public class CurrencyController {

    @Autowired // Injects the CurrencyService for currency conversion logic
    private CurrencyService currencyService;

    // Handles GET requests for the home page (displays the currency converter form)
    @GetMapping("/")
    public String showConverterPage() {

        return "converter"; // Returns the name of the JSP file (converter.jsp)
    }

    // Handles POST requests when the user submits the form
    @PostMapping("/convert")
    public String convertCurrency(
            @RequestParam String baseCurrency,     // Base currency selected by the user (e.g., USD)
            @RequestParam String targetCurrency,   // Target currency selected by the user (e.g., INR)
            @RequestParam double amount,           // Amount entered by the user
            Model model) {                         // Model to pass data to the JSP page

        try {
            // Converts the currency using the service
            double convertedAmount = currencyService.convertCurrency(baseCurrency, targetCurrency, amount);
            model.addAttribute("convertedAmount", convertedAmount); // Adds the converted amount to the model
            model.addAttribute("currencySymbol", getCurrencySymbol(targetCurrency)); // Adds the target currency symbol
        } catch (Exception e) {
            // Handles errors (e.g., invalid currency codes)
            model.addAttribute("error", "Invalid currency code or API issue.");
        }

        // Adds form data back to the model to retain user selections
        model.addAttribute("baseCurrency", baseCurrency);
        model.addAttribute("targetCurrency", targetCurrency);
        model.addAttribute("amount", amount);

        return "converter"; // Returns the JSP page to display the result
    }

    // Helper method to get the currency symbol based on the currency code
    private String getCurrencySymbol(String currencyCode) {
        return switch (currencyCode) {
            case "USD" -> "$";
            case "EUR" -> "€";
            case "GBP" -> "£";
            case "INR" -> "₹";
            case "JPY" -> "¥";
            default -> currencyCode; // Returns the code itself if the symbol is not defined
        };
    }
}
