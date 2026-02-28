package com.manmohan.systemdesign.parkingLot.model;

import com.manmohan.systemdesign.parkingLot.constants.SpotType;
import com.manmohan.systemdesign.parkingLot.constants.VehicleType;

public class ParkingSpot {
    int spotNumber;
    SpotType type;
    boolean isOccupied;
    Vehicle vehicle;

    public ParkingSpot(int spotNumber, SpotType type) {
        this.spotNumber = spotNumber;
        this.type = type;
        this.isOccupied = false;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        if (isOccupied) return false;

        if (vehicle.getType() == VehicleType.TRUCK && type == SpotType.TRUCK)
            return true;

        if (vehicle.getType() == VehicleType.CAR &&
                (type == SpotType.CAR || type == SpotType.ELECTRIC))
            return true;

        return vehicle.getType().name().equals(type.name());
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }
}
