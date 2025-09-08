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

    @Test
    public void should_return_two_tickets_when_customer_parked_two_car(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ABC100");
        Ticket ticket = parkingLot.park(car);

        Car fetchCar = parkingLot.fetch(ticket);
        assertEquals(car, fetchCar);


        Car car2 = new Car("ABC200");
        Ticket ticket2 = parkingLot.park(car2);

        Car fetchCar2 = parkingLot.fetch(ticket2);
        assertEquals(car2, fetchCar2);
    }

    @Test
    public void should_return_nothing_when_customer_give_the_wrong_ticket(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ABC100");
        Ticket ticket = parkingLot.park(car);

        Ticket wrongTicket = new Ticket(new Car("ABC200"), 10, parkingLot);
        Car fetchCar = parkingLot.fetch(wrongTicket);
        assertFalse(car.equals(fetchCar));
    }

    @Test
    public void should_return_nothing_when_customer_give_the_used_ticket(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ABC100");
        Ticket ticket = parkingLot.park(car);
        Car fetchCar = parkingLot.fetch(ticket);

        Car fetchCarTwice = parkingLot.fetch(ticket);

        assertFalse(car.equals(fetchCarTwice));
    }

    @Test
    public void should_return_nothing_when_no_position(){
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("ABC100");
        Ticket ticket = parkingLot.park(car);

        Car car2 = new Car("ABC200");
        Ticket ticket2 = parkingLot.park(car2);

        assertNull(ticket2);
    }


}
