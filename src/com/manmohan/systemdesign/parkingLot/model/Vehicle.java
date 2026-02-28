package com.manmohan.systemdesign.parkingLot.model;

import com.manmohan.systemdesign.parkingLot.constants.VehicleType;

public class Vehicle {
    String licenseNumber;
    VehicleType type;

    public Vehicle(String licenseNumber, VehicleType type) {
        this.licenseNumber = licenseNumber;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }
}


