package com.afs.parkinglot;

import java.util.Date;

public class Car {
    private String carNumber;

    public Car(String number) {
        this.carNumber = number;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
