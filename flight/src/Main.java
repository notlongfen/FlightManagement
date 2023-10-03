import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;
import java.util.HashMap;
import entities.Crew;
import entities.Flight;
import entities.Passenger;
import entities.Reservation;
import factory.CrewFactory;
import factory.FlightFactory;
import factory.PassengerFactory;
import factory.ReservationFactory;
import service.Service;
// import Service.Service;
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Flight> flights = new ArrayList<>();
    private static final List<Reservation> reservations = new ArrayList<>();
    private static final List<Crew> crews = new ArrayList<>();
    // private static final Service Service = new Service();
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
                    Service.addNewFlight();
                    break;
                case 2:
                    Service.makeReservation();
                    break;
                case 3:
                    Service.checkIn();
                    break;
                case 4:
                    Service.manageCrew();
                    break;
                case 5:
                    Service.saveToFile();
                    break;
                case 6:
                    Service.printAllLists();
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
}