package entities;

import java.util.List;

public class Airport {
    List<Flight> flights;
    List<Passenger> passengers;
    List<Crew> crews;
    List<Reservation> reservations;

    public Airport(List<Flight> flights, List<Crew> crews) {
        this.flights = flights;
        this.crews = crews;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public int getNumberOfPassenger(){
        return passengers.size();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
    @Override
    public String toString() {
        return "Airport [flights=" + flights + ", passengers=" + passengers + "]";
    }

}
