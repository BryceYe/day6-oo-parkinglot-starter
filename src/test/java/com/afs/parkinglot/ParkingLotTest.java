package com.afs.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    //Case 1 - Given a parking lot, and a car, When park the car, Then return a parking ticket.
    @Test
    public void should_return_ticket_when_customer_parking_the_car(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ABC100");
        Ticket ticket = ParkingBoy.park(parkingLot, car);
        assertNotNull(ticket);
    }

    //Case 2 - Given a parking lot with a parked car, and a parking ticket, When fetch the car, Then return the parked car.
    @Test
    public void should_return_ticket_when_customer_parked_the_car(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ABC100");
        Ticket ticket = ParkingBoy.park(parkingLot, car);
        Car fetchCar = ParkingBoy.fetch(parkingLot, ticket);
        assertEquals(car, fetchCar);
    }

    //Case 3 - Given a parking lot with two parked cars, and two parking tickets, When fetch the car twice, Then return the right car with each ticket
    @Test
    public void should_return_two_tickets_when_customer_parked_two_car(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ABC100");
        Ticket ticket = ParkingBoy.park(parkingLot, car);

        Car fetchCar = ParkingBoy.fetch(parkingLot, ticket);
        assertEquals(car, fetchCar);


        Car car2 = new Car("ABC200");
        Ticket ticket2 = ParkingBoy.park(parkingLot, car2);

        Car fetchCar2 = ParkingBoy.fetch(parkingLot, ticket2);
        assertEquals(car2, fetchCar2);
    }

    //Case 4 - Given a parking lot, and a wrong parking ticket, When fetch the car, Then return nothing.
    @Test
    public void should_return_nothing_when_customer_give_the_wrong_ticket(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ABC100");
        Ticket ticket = ParkingBoy.park(parkingLot, car);

        Ticket wrongTicket = new Ticket(new Car("ABC200"), 10, parkingLot);
        Car fetchCar = ParkingBoy.fetch(parkingLot, wrongTicket);
        assertFalse(car.equals(fetchCar));
    }

    //Case 5 - Given a parking lot, and a used parking ticket, When fetch the car, Then return nothing.
    @Test
    public void should_return_nothing_when_customer_give_the_used_ticket(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ABC100");
        Ticket ticket = ParkingBoy.park(parkingLot, car);
        Car fetchCar = ParkingBoy.fetch(parkingLot, ticket);

        Car fetchCarTwice = ParkingBoy.fetch(parkingLot, ticket);

        assertFalse(car.equals(fetchCarTwice));
    }

    //Case 6 - Given a parking lot without any position, and a car, When park the car, Then return nothing
    @Test
    public void should_return_nothing_when_no_position(){
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("ABC100");
        Ticket ticket = ParkingBoy.park(parkingLot, car);

        Car car2 = new Car("ABC200");
        Ticket ticket2 = ParkingBoy.park(parkingLot, car2);

        assertNull(ticket2);
    }

    //Case 7 - Given a parking lot, and a wrong ticket, When fetch the car, Then return error message "Unrecognized parking ticket."
    @Test
    public void should_return_error_message_when_customer_give_the_wrong_ticket(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ABC100");
        Ticket ticket = ParkingBoy.park(parkingLot, car);

        Ticket wrongTicket = new Ticket(new Car("ABC200"), 10, parkingLot);
        Car fetchCar = ParkingBoy.fetch(parkingLot, wrongTicket);

        assertTrue(outputStream.toString().contains("Unrecognized parking ticket."));
    }

    //Case 8 - Given a parking lot, and a used ticket, When fetch the car, Then return error message "Unrecognized parking ticket."
    @Test
    public void should_return_error_message_when_customer_give_the_used_ticket(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ABC100");
        Ticket ticket = ParkingBoy.park(parkingLot, car);
        Car fetchCar = ParkingBoy.fetch(parkingLot, ticket);

        Car fetchCarTwice = ParkingBoy.fetch(parkingLot, ticket);

        assertTrue(outputStream.toString().contains("Unrecognized parking ticket."));
    }

    //Case 9 - Given a parking lot without any position, and a car, When park the car, Then return error message "No available position."
    @Test
    public void should_return_error_message_when_without_any_position(){
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("ABC100");
        Ticket ticket = ParkingBoy.park(parkingLot, car);

        Car car2 = new Car("ABC200");
        Ticket ticket2 = ParkingBoy.park(parkingLot, car2);

        assertTrue(outputStream.toString().contains("No available position."));
    }



}
