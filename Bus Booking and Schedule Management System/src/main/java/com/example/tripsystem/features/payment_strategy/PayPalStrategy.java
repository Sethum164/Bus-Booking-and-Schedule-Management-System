package com.example.tripsystem.features.payment_strategy;

import java.math.BigDecimal;

public class PayPalStrategy implements PaymentStrategy {
    @Override
    public String processPayment(BigDecimal amount) {
        // Simulate PayPal processing (e.g., redirect to PayPal API)
        System.out.println("Processing PayPal payment of " + amount + ". Redirecting to PayPal...");
        // For demo, assume success
        return "COMPLETED";
    }
}