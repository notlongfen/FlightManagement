package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import entities.Crew;
import entities.Flight;
import entities.Passenger;
import entities.Reservation;
import factory.FlightFactory;
import factory.PassengerFactory;
import factory.ReservationFactory;

public class Service{
    static Scanner scanner = new Scanner(System.in); 
    private static final List<Flight> flights = new ArrayList<>();
    private static final List<Reservation> reservations = new ArrayList<>();
    private static final List<Crew> crews = new ArrayList<>();
    public static void addNewFlight() {
        System.out.print("Enter flight number (must follow format Fxyzt, with xyzt is a number and no spaces, ex: F0001): ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter departure city: ");
        String departureCity = scanner.nextLine();
        System.out.print("Enter destination city: ");
        String destinationCity = scanner.nextLine();
        System.out.print("Enter departure time (in HH:mm format): ");
        String departureTime = scanner.nextLine();
        System.out.print("Enter duration time (in HH:mm format): ");
        String duration = scanner.nextLine();
        int availableSeats = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        Flight flight = FlightFactory.createNewFlight(flightNumber, departureCity, destinationCity, departureTime, duration, availableSeats);
        flights.add(flight);
        System.out.println("Flight added successfully.");
    }

    public static void makeReservation() {
        System.out.print("Enter departure city: ");
        String departureCity = scanner.nextLine();
        System.out.print("Enter destination city: ");
        String destinationCity = scanner.nextLine();
        System.out.print("Enter date (in yyyy-MM-dd format): ");
        String date = scanner.nextLine();

        List<Flight> availableFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDepartureCity().equals(departureCity) && flight.getDestinationCity().equals(destinationCity)) {
                availableFlights.add(flight);
            }
        }

        if (availableFlights.isEmpty()) {
            System.out.println("No available flights found.");
            return;
        }

        System.out.println("Available flights:");
        for (int i = 0; i < availableFlights.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, availableFlights.get(i).getFlightNumber());
        }

        System.out.print("Enter flight number: ");
        int flightIndex = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        if (flightIndex < 1 || flightIndex > availableFlights.size()) {
            System.out.println("Invalid flight number. Please try again.");
            return;
        }

        Flight selectedFlight = availableFlights.get(flightIndex - 1);

        System.out.print("Enter passenger name: ");
        String passengerName = scanner.nextLine();
        System.out.print("Enter contact details: ");
        String contactDetails = scanner.nextLine();

        Passenger passenger = PassengerFactory.createPassenger(passengerName, contactDetails);

        String reservationId = UUID.randomUUID().toString();
        Reservation reservation = ReservationFactory.createReservation(reservationId, passenger, selectedFlight);
        reservations.add(reservation);

        System.out.printf("Reservation successful. Your reservation ID is %s.\n", reservationId);
    }

    public static void checkIn() {
        System.out.print("Enter reservation ID: ");
        String reservationId = scanner.nextLine();

        Reservation reservation = null;
        for (Reservation r : reservations) {
            if (r.getReservationId().equals(reservationId)) {
                reservation = r;
                break;
            }
        }
    
        if (reservation == null) {
            System.out.println("Reservation not found.");
            return;
        }
    
        if (reservation.getFlight().getAvailableSeats() ==0) {
            System.out.println("Flight is full. Check-in not possible.");
            return;
        }
    
        reservation.getPassenger().setStatus(true);
        System.out.println("Check-in successful.");
    }

//crew
    public static void manageCrew() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (!username.equals("admin") || !password.equals("admin")) {
            System.out.println("Invalid username or password.");
            return;
        }

        int choice;
        do {
            System.out.println("1. Add new crew");
            System.out.println("2. View all crews");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    addNewCrew();
                    break;
                case 2:
                    viewAllCrews();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);
    }

    public static void addNewCrew() {
        System.out.print("Enter crew name: ");
        String name = scanner.nextLine();
        System.out.print("Enter crew role: ");
        String role = scanner.nextLine();

        Crew crew = CrewFactory.createCrew(name, role);
        crews.add(crew);
        System.out.println("Crew added successfully.");
    }

    public static void viewAllCrews() {
        System.out.println("All crews:");
        for (Crew crew : crews) {
            System.out.println(crew.getName() + " - " + crew.getRole());
        }
    }

    public static void saveToFile() {
        FileManager.saveToFile(flights, reservations, crews);
        System.out.println("Saved to file successfully.");
    }

    public static void printAllLists() {
        System.out.println("Flights:");
        for (Flight flight : FileManager.loadFlightsFromFile()) {
            System.out.println(flight.getFlightNumber() + " - " + flight.getDepartureCity() + " - " + flight.getDestinationCity() + " - " + flight.getDepartureTime() + " - " + flight.getArrivalTime() + " - " + flight.getAvailableSeats());
        }

        System.out.println("Reservations:");
        for (Reservation reservation : FileManager.loadReservationsFromFile()) {
            System.out.println(reservation.getReservationId() + " - " + reservation.getPassenger().getName() + " - " + reservation.getPassenger().getContactDetails() + " - " + reservation.getFlight().getFlightNumber());
        }

        System.out.println("Crews:");
        for (Crew crew : FileManager.loadCrewsFromFile()) {
            System.out.println(crew.getName() + " - " + crew.getRole());
        }
    }
}