package com.manmohan.systemdesign.parkingLot.strategy.pricing;

import com.manmohan.systemdesign.parkingLot.model.Ticket;

public class HourlyPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(Ticket ticket) {
        long duration = System.currentTimeMillis() - ticket.getEntryTime();
        long hours = Math.max(1, duration / (1000 * 60 * 60));

        switch (ticket.getVehicle().getType()) {
            case BIKE: return hours * 5;
            case CAR: return hours * 10;
            case TRUCK: return hours * 20;
            default: return 0;
        }
    }
}