package com.afs.parkinglot;

import java.util.List;
import java.util.stream.IntStream;

public class ParkingBoy {

    public static Ticket park(List<ParkingLot> parkingLots, Car car) {
        for(ParkingLot parkingLot : parkingLots){
            Ticket ticket = IntStream.rangeClosed(1, parkingLot.getCapacity()).boxed()
                .filter(position -> parkingLot.getTicketsCars().keySet().stream().noneMatch(t1 -> t1.getPosition().equals(position)))
                .findFirst()
                .map(position -> {
                    Ticket t = new Ticket(car, position, parkingLot);
                    parkingLot.getTicketsCars().put(t, car);
                    return t;
                }).orElse(null);
            if(ticket != null){
                return ticket;
            }
        }
        System.out.println("No available position.");
        return null;
    }

    public static Car fetch(List<ParkingLot> parkingLots,Ticket ticket) {
        if(parkingLots.isEmpty() ||
                !parkingLots.contains(ticket.getParkingLot()) ||
                !parkingLots.get(parkingLots.indexOf(ticket.getParkingLot())).getTicketsCars().containsKey(ticket)){
            System.out.println("Unrecognized parking ticket.");
            return null;
        }
        return parkingLots.get(parkingLots.indexOf(ticket.getParkingLot())).getTicketsCars().remove(ticket);
    }
}
