package entities;

public class Crewf {
    private String name;
    private String role;

    public Crewf(String name, String role) {
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

    @Override
    public String toString() {
        return "Crewf  name=" + name + ", role=" + role + "]";
    }


}
