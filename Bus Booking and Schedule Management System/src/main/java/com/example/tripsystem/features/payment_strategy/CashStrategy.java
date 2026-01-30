package com.example.tripsystem.features.payment_strategy;

import java.math.BigDecimal;

public class CashStrategy implements PaymentStrategy {
    @Override
    public String processPayment(BigDecimal amount) {
        // Simulate cash payment processing (e.g., mark as pending for verification)
        System.out.println("Processing cash payment of " + amount + ". Marked as pending for verification...");
        return "PENDING"; // Cash might require manual confirmation
    }
}