package factory;

import entities.Crewf;

public class CrewFactory {
    public static Crewf createCrew(String name, String role) {
        Crewf crew = new Crewf(name, role);
        return crew;
    }
}
