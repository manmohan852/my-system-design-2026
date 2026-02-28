package com.manmohan.systemdesign.parkingLot.strategy.pricing;

import com.manmohan.systemdesign.parkingLot.model.Ticket;

public interface PricingStrategy {
    double calculatePrice(Ticket ticket);
}
