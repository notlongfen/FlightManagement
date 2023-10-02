package factory;

import entities.Flight;
import entities.Airport;

public class FlightFactory {
    private static Airport airport;
    public static Flight createNewFlight(String flightNumber, String departureCity, String destinationCity, String departureTime,
            String duration, int availableSeats) {
        Flight flight = new Flight(flightNumber, departureCity, destinationCity, departureTime,
                 duration, availableSeats);
        airport.addFlight(flight);
        return flight;
    }
}
