package entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flight {
    private String flightNumber;
    private String departureCity;
    private String destinationCity;
    private String departureTime;
    private String arrivalTime;
    private String duration;
    private int availableSeats;


    public Flight(String flightNumber, String departureCity, String destinationCity, String departureTime,
             String duration, int availableSeats) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        LocalDateTime departureDateTime = LocalDateTime.parse(departureTime, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        Duration flightDuration = Duration.ofMinutes(Long.parseLong(duration));
        LocalDateTime arrivalDateTime = departureDateTime.plus(flightDuration);
        this.arrivalTime = arrivalDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        this.availableSeats = availableSeats;
        this.duration = duration;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }   

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
    
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getDuration() {
        return duration;
    }


    @Override
    public String toString() {
        return "Flight [flightNumber=" + flightNumber + ", departureCity=" + departureCity + ", destinationCity="
                + destinationCity + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
                + ", availableSeats=" + availableSeats + "]";
    }


}
