package com.afs.parkinglot;

import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carNumber, car.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carNumber);
    }
}
