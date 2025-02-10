import java.util.ArrayList;
import java.util.List;

// Airport class
class Airport {
    private String name;
    private List<Aircraft> aircraftVehicles = new ArrayList<>();

    public Airport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Aircraft> getAircraftVehicles() {
        return aircraftVehicles;
    }

    public void addAircraft(Aircraft aircraft) {
        aircraftVehicles.add(aircraft);
    }

    public void removeAircraft(Aircraft aircraft) {
        aircraftVehicles.remove(aircraft);
    }

    public Passenger searchPassenger(String airlineName, int seatNumber) {
        for (Aircraft aircraft : aircraftVehicles) {
            if (aircraft.getName().equals(airlineName)) {
                for (Passenger passenger : aircraft.getPassengers()) {
                    if (passenger.getSeatNumber() == seatNumber) {
                        return passenger;
                    }
                }
            }
        }
        return null; // No passenger found
    }
}
