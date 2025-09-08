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

    public Map<Ticket, Car> getTicketsCars() {
        return ticketsCars;
    }

    public void setTicketsCars(Map<Ticket, Car> ticketsCars) {
        this.ticketsCars = ticketsCars;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
