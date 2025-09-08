package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ParkingLot {
    private Map<Ticket, Car> ticketsCars = new HashMap<Ticket, Car>();

    private Integer capacity = 10;

    public Ticket park(Car car) {
        return IntStream.rangeClosed(1, capacity).boxed()
            .filter(position -> ticketsCars.keySet().stream().noneMatch(ticket -> ticket.getPosition().equals(position)))
            .findFirst()
            .map(position -> {
                Ticket ticket = new Ticket(car, position, this);
                ticketsCars.put(ticket, car);
                return ticket;
            }).orElse(null);
    }

    public Car fetch(Ticket ticket) {
        return ticketsCars.remove(ticket);
    }
}
