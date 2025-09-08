package com.afs.parkinglot;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    public void should_return_ticket_when_customer_parking_the_car(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ABC100");
        Ticket ticket = parkingLot.park(car);
        assertNotNull(ticket);
    }

    @Test
    public void should_return_ticket_when_customer_parked_the_car(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ABC100");
        Ticket ticket = parkingLot.park(car);
        Car fetchCar = parkingLot.fetch(ticket);
        assertEquals(car, fetchCar);
    }

}
