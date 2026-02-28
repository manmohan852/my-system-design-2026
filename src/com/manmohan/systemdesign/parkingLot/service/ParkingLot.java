package com.manmohan.systemdesign.parkingLot.service;


import com.manmohan.systemdesign.parkingLot.model.Floor;
import com.manmohan.systemdesign.parkingLot.model.ParkingSpot;
import com.manmohan.systemdesign.parkingLot.model.Ticket;
import com.manmohan.systemdesign.parkingLot.model.Vehicle;
import com.manmohan.systemdesign.parkingLot.strategy.allocation.SpotAllocationStrategy;
import com.manmohan.systemdesign.parkingLot.strategy.pricing.PricingStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {

    private PricingStrategy pricingStrategy;
    private SpotAllocationStrategy allocationStrategy;


    List<Floor> floors;

    public ParkingLot(List<Floor> floors, PricingStrategy pricingStrategy) {
        this.floors = floors;
        this.pricingStrategy = pricingStrategy;
    }
    public ParkingLot(List<Floor> floors,
                      PricingStrategy pricingStrategy,
                      SpotAllocationStrategy allocationStrategy) {
        this.floors = floors;
        this.pricingStrategy = pricingStrategy;
        this.allocationStrategy = allocationStrategy;
    }

    Map<String, Ticket> activeTickets = new HashMap<>();

    public ParkingLot(List<Floor> floors) {
        this.floors = floors;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) {
        for (Floor floor : floors) {
            ParkingSpot spot = allocationStrategy.findSpot(vehicle, floors);
            if (spot != null) {
                spot.parkVehicle(vehicle);
                Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, spot);
                activeTickets.put(ticket.getTicketId(), ticket);
                return ticket;
            }
        }
        throw new RuntimeException("No spot available");
    }

    public void removeVehicle(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            throw new RuntimeException("Invalid ticket");
        }

        ticket.getSpot().removeVehicle();
        activeTickets.remove(ticketId);

        double price = pricingStrategy.calculatePrice(ticket);
        System.out.println("Parking fee: " + price);
    }
}