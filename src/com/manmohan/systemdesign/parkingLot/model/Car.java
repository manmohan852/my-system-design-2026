package com.manmohan.systemdesign.parkingLot.model;

import com.manmohan.systemdesign.parkingLot.constants.VehicleType;

public class Car extends Vehicle {
    public Car(String licenseNumber) {
        super(licenseNumber, VehicleType.CAR);
    }
}
