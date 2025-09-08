package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ParkingLot {
    private Map<Ticket, Car> ticketsCars = new HashMap<Ticket, Car>();

    private Integer capacity = 10;

    private Integer id;

    public ParkingLot(Integer id) {
        this.id = id;
    }

    public ParkingLot() {
    }

    public ParkingLot(Integer id, Integer capacity) {
        this.capacity = capacity;
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
