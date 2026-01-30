package com.example.tripsystem.features.payment_strategy;

import java.math.BigDecimal;

public class BankTransferStrategy implements PaymentStrategy {
    @Override
    public String processPayment(BigDecimal amount) {
        // Simulate bank transfer (e.g., generate IBAN instructions)
        System.out.println("Processing bank transfer of " + amount + ". Generating transfer details...");
        // For demo, assume pending
        return "PENDING";
    }
}