package com.manmohan.systemdesign.parkingLot.model;

import com.manmohan.systemdesign.parkingLot.constants.VehicleType;

public class Truck extends Vehicle {
    public Truck(String licenseNumber) {
        super(licenseNumber, VehicleType.TRUCK);
    }
}
