package com.manmohan.systemdesign.parkingLot.strategy.allocation;

import com.manmohan.systemdesign.parkingLot.model.*;
import java.util.List;

public class VipSpotStrategy implements SpotAllocationStrategy {

    @Override
    public ParkingSpot findSpot(Vehicle vehicle, List<Floor> floors) {

        if (floors == null || floors.isEmpty()) {
            return null;
        }

        // Step 1: Try first floor (VIP preference)
        Floor firstFloor = floors.get(0);
        ParkingSpot spot = firstFloor.findAvailableSpot(vehicle);

        if (spot != null) {
            return spot;
        }

        // Step 2: Fallback to other floors
        for (int i = 1; i < floors.size(); i++) {
            spot = floors.get(i).findAvailableSpot(vehicle);
            if (spot != null) {
                return spot;
            }
        }

        return null;
    }
}