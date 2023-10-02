package entities;

public class Reservation {
    private String reservationId;
    private Passenger passenger;
    private Flight flight;
    private boolean status;//check in or not

    public Reservation(String reservationId, Passenger passenger, Flight flight) {
        this.reservationId = reservationId;
        this.passenger = passenger;
        this.flight = flight;
        this.status = false;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Reservation [flight=" + flight + ", passenger=" + passenger + ", reservationId=" + reservationId + "]";
    }

}
