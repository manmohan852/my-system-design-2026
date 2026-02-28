package com.manmohan.systemdesign.parkingLot.model;

import com.manmohan.systemdesign.parkingLot.constants.VehicleType;

public class Bike extends Vehicle {
    public Bike(String licenseNumber) {
        super(licenseNumber, VehicleType.BIKE);
    }
}
