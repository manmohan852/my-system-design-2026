package com.manmohan.systemdesign.parkingLot.app;

import com.manmohan.systemdesign.parkingLot.constants.SpotType;
import com.manmohan.systemdesign.parkingLot.model.*;
import com.manmohan.systemdesign.parkingLot.service.ParkingLot;
import com.manmohan.systemdesign.parkingLot.strategy.allocation.NearestSpotStrategy;
import com.manmohan.systemdesign.parkingLot.strategy.allocation.SpotAllocationStrategy;
import com.manmohan.systemdesign.parkingLot.strategy.allocation.VipSpotStrategy;
import com.manmohan.systemdesign.parkingLot.strategy.pricing.HourlyPricingStrategy;
import com.manmohan.systemdesign.parkingLot.strategy.pricing.PricingStrategy;

import java.util.ArrayList;
import java.util.List;

public class parkingLotApp {
    public static void main(String[] args) {

        List<ParkingSpot> spots = new ArrayList<>();
        spots.add(new ParkingSpot(1, SpotType.CAR));
        spots.add(new ParkingSpot(2, SpotType.BIKE));

        List<Floor> floors = new ArrayList<>();
        floors.add( new Floor(1, spots));

        PricingStrategy pricingStrategy = new HourlyPricingStrategy();

        User user = new User("Manmohan", true);

        SpotAllocationStrategy allocationStrategy;

        if (user.isVip()) {
            allocationStrategy = new VipSpotStrategy();
        } else {
            allocationStrategy = new NearestSpotStrategy();
        }

        ParkingLot lot = new ParkingLot(
                floors,
                pricingStrategy,
                allocationStrategy
        );

        Vehicle car = new Car("KA-01-1234");

        Ticket ticket = lot.parkVehicle(car);

        lot.removeVehicle(ticket.getTicketId());
    }
}
