package com.manmohan.systemdesign.parkingLot.strategy.allocation;

import com.manmohan.systemdesign.parkingLot.model.Floor;
import com.manmohan.systemdesign.parkingLot.model.ParkingSpot;
import com.manmohan.systemdesign.parkingLot.model.Vehicle;

import java.util.List;

public class NearestSpotStrategy implements SpotAllocationStrategy {

    @Override
    public ParkingSpot findSpot(Vehicle vehicle, List<Floor> floors) {
        for (Floor floor : floors) {
            ParkingSpot spot = floor.findAvailableSpot(vehicle);
            if (spot != null) return spot;
        }
        return null;
    }
}