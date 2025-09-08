package com.afs.parkinglot;

import java.util.Objects;

public class Ticket {
    private Integer position;
    private Car car;
    private ParkingLot parkingLot;

    public Ticket(Car car, Integer position, ParkingLot parkingLot) {
        this.position = position;
        this.car = car;
        this.parkingLot = parkingLot;
    }



    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
