package factory;
import entities.Passenger;

public class PassengerFactory {
    public static Passenger createPassenger(String name, String contact) {
        Passenger passenger = new Passenger(name, contact);
        return passenger;
    }
}
