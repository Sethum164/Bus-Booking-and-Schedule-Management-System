package com.example.tripsystem.features.payment_strategy;

import java.math.BigDecimal;

public class CreditCardStrategy implements PaymentStrategy {
    @Override
    public String processPayment(BigDecimal amount) {
        // Simulate credit card processing (e.g., call Stripe API here in real app)
        System.out.println("Processing credit card payment of " + amount + ". Charging card...");
        // For demo, assume success
        return "COMPLETED";
    }
}