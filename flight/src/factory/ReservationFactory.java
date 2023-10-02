package factory;

import entities.Airport;
import entities.Flight;
import entities.Passenger;
import entities.Reservation;

public class ReservationFactory {
    static Airport airport;
    public static Reservation createReservation(String reservationId, Passenger passenger, Flight flight) {
        Reservation reservation = new Reservation(reservationId, passenger, flight);
        airport.addReservation(reservation);
        return reservation;
    }

}
