package com.manmohan.systemdesign.parkingLot.strategy.allocation;

import com.manmohan.systemdesign.parkingLot.model.Floor;
import com.manmohan.systemdesign.parkingLot.model.ParkingSpot;
import com.manmohan.systemdesign.parkingLot.model.Vehicle;

import java.util.List;

public interface SpotAllocationStrategy {
    ParkingSpot findSpot(Vehicle vehicle, List<Floor> floors);
}