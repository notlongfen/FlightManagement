// Flight.java
public class Flight {
    private String flightNumber;
    private String departureCity;
    private String destinationCity;
    private String departureTime;
    private String arrivalTime;
    private int availableSeats;

    public Flight(String flightNumber, String departureCity, String destinationCity, String departureTime, String arrivalTime, int availableSeats) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = availableSeats;
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

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}

// FlightFactory.java
public class FlightFactory {
    public static Flight createFlight(String flightNumber, String departureCity, String destinationCity, String departureTime, String arrivalTime, int availableSeats) {
        return new Flight(flightNumber, departureCity, destinationCity, departureTime, arrivalTime, availableSeats);
    }
}

// Reservation.java
public class Reservation {
    private String reservationId;
    private Passenger passenger;
    private Flight flight;

    public Reservation(String reservationId, Passenger passenger, Flight flight) {
        this.reservationId = reservationId;
        this.passenger = passenger;
        this.flight = flight;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}

// ReservationFactory.java
public class ReservationFactory {
    public static Reservation createReservation(String reservationId, Passenger passenger, Flight flight) {
        return new Reservation(reservationId, passenger, flight);
    }
}

// Passenger.java
public class Passenger {
    private String name;
    private String contactDetails;

    public Passenger(String name, String contactDetails) {
        this.name = name;
        this.contactDetails = contactDetails;
    }

    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}

// PassengerFactory.java
public class PassengerFactory {
    public static Passenger createPassenger(String name, String contactDetails) {
        return new Passenger(name, contactDetails);
    }
}

// Crew.java
public class Crew {
    private String name;
    private String role;

    public Crew(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

// CrewFactory.java
public class CrewFactory {
    public static Crew createCrew(String name, String role) {
        return new Crew(name, role);
    }
}

// FileManager.java
public class FileManager {
    private static final String FILE_NAME = "D:\JavaNetbean\FlightManageMent\product.dat";

    public static void saveToFile(List<Flight> flights, List<Reservation> reservations, List<Crew> crews) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(flights);
            oos.writeObject(reservations);
            oos.writeObject(crews);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Flight> loadFlightsFromFile() {
        List<Flight> flights = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            flights = (List<Flight>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flights;
    }

    public static List<Reservation> loadReservationsFromFile() {
        List<Reservation> reservations = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            ois.readObject();
            reservations = (List<Reservation>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public static List<Crew> loadCrewsFromFile() {
        List<Crew> crews = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            ois.readObject();
            ois.readObject();
            crews = (List<Crew>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return crews;
    }
}

// Main.java
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Flight> flights = new ArrayList<>();
    private static final List<Reservation> reservations = new ArrayList<>();
    private static final List<Crew> crews = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Flight schedule management");
            System.out.println("2. Passenger reservation and booking");
            System.out.println("3. Passenger check-in and seat allocation");
            System.out.println("4. Crew management and administrator access");
            System.out.println("5. Save to file");
            System.out.println("6. Print all lists from file");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    addNewFlight();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    checkIn();
                    break;
                case 4:
                    manageCrew();
                    break;
                case 5:
                    saveToFile();
                    break;
                case 6:
                    printAllLists();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 7);
    }

    private static void addNewFlight() {
        System.out.print("Enter flight number (must follow format Fxyzt, with xyzt is a number and no spaces, ex: F0001): ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter departure city: ");
        String departureCity = scanner.nextLine();
        System.out.print("Enter destination city: ");
        String destinationCity = scanner.nextLine();
        System.out.print("Enter departure time (in HH:mm format): ");
        String departureTime = scanner.nextLine();
        System.out.print("Enter arrival time (in HH:mm format): ");
        String arrivalTime = scanner.nextLine();
        System.out.print("Enter available seats: ");
        int availableSeats = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        Flight flight = FlightFactory.createFlight(flightNumber, departureCity, destinationCity, departureTime, arrivalTime, availableSeats);
        flights.add(flight);
        System.out.println("Flight added successfully.");
    }

    private static void makeReservation() {
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

    private static void checkIn() {
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
    
        if (reservation.getFlight().isFull()) {
            System.out.println("Flight is full. Check-in not possible.");
            return;
        }
    
        reservation.getPassenger().setCheckedIn(true);
        System.out.println("Check-in successful.");
    }

//crew
    private static void manageCrew() {
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

    private static void addNewCrew() {
        System.out.print("Enter crew name: ");
        String name = scanner.nextLine();
        System.out.print("Enter crew role: ");
        String role = scanner.nextLine();

        Crew crew = CrewFactory.createCrew(name, role);
        crews.add(crew);
        System.out.println("Crew added successfully.");
    }

    private static void viewAllCrews() {
        System.out.println("All crews:");
        for (Crew crew : crews) {
            System.out.println(crew.getName() + " - " + crew.getRole());
        }
    }

    private static void saveToFile() {
        FileManager.saveToFile(flights, reservations, crews);
        System.out.println("Saved to file successfully.");
    }

    private static void printAllLists() {
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