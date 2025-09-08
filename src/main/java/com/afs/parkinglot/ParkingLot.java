package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ParkingLot {
    private Map<Ticket, Car> ticketsCars = new HashMap<Ticket, Car>();

    private Integer capacity = 10;

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
    }

    public Ticket park(Car car) {
        return IntStream.rangeClosed(1, capacity).boxed()
            .filter(position -> ticketsCars.keySet().stream().noneMatch(ticket -> ticket.getPosition().equals(position)))
            .findFirst()
            .map(position -> {
                Ticket ticket = new Ticket(car, position, this);
                ticketsCars.put(ticket, car);
                return ticket;
            }).orElseGet(() -> {
                System.out.println("No available position.");
                return null;
            });
    }

    public Car fetch(Ticket ticket) {
        if(!ticketsCars.containsKey(ticket)) {
            System.out.println("Unrecognized parking ticket.");
        }
        return ticketsCars.remove(ticket);
    }
}
