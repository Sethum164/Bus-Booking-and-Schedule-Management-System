package com.example.tripsystem.features.payment_strategy;

import java.math.BigDecimal;

public interface PaymentStrategy {
    /**
     * Processes the payment for the given amount.
     * @param amount The amount to process.
     * @return The new status after processing (e.g., "COMPLETED" or "FAILED").
     */
    String processPayment(BigDecimal amount);
}