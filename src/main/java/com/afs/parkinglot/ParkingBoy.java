package com.afs.parkinglot;

import java.util.stream.IntStream;

public class ParkingBoy {
    // 第一个停车场停满了才会第二个，按顺序

    public static Ticket park(ParkingLot parkingLot,Car car) {
        return IntStream.rangeClosed(1, parkingLot.getCapacity()).boxed()
                .filter(position -> parkingLot.getTicketsCars().keySet().stream().noneMatch(ticket -> ticket.getPosition().equals(position)))
                .findFirst()
                .map(position -> {
                    Ticket ticket = new Ticket(car, position, parkingLot);
                    parkingLot.getTicketsCars().put(ticket, car);
                    return ticket;
                }).orElseGet(() -> {
                    System.out.println("No available position.");
                    return null;
                });
    }

    public static Car fetch(ParkingLot parkingLot,Ticket ticket) {
        if(!parkingLot.getTicketsCars().containsKey(ticket)) {
            System.out.println("Unrecognized parking ticket.");
            return null;
        }
        return parkingLot.getTicketsCars().remove(ticket);
    }
}
