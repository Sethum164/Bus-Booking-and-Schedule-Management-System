package com.example.tripsystem.features.payment_strategy;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentStrategyFactory {
    private final Map<String, PaymentStrategy> strategies;

    public PaymentStrategyFactory() {
        strategies = new HashMap<>();
        strategies.put("CREDIT_CARD", new CreditCardStrategy());
        strategies.put("PAYPAL", new PayPalStrategy());
        strategies.put("BANK_TRANSFER", new BankTransferStrategy()); // If implemented
        strategies.put("CASH", new CashStrategy()); // NEW: Add CASH strategy
        // Add more methods here as needed
    }

    public PaymentStrategy getStrategy(String method) {
        String key = method.toUpperCase(); // Normalize to uppercase
        PaymentStrategy strategy = strategies.get(key);
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid payment method: " + method);
        }
        return strategy;
    }
}