package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import entities.Crew;
import entities.Flight;
import entities.Reservation;

public class FileManager {
    private static final String FILE_NAME = "D:\\JavaNetbean\\FlightManageMent\\product.dat";
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
