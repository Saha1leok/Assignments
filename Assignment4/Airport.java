import java.util.ArrayList;
import java.util.List;
class Airport {
    private String name;
    private List<Aircraft> aircraftVehicles; 

    
    public Airport(String name) {
        this.name = name;
        this.aircraftVehicles = new ArrayList<>();
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

   
    public Passenger searchPassenger(String aircraftName, int seatNumber) {
        for (Aircraft aircraft : aircraftVehicles) {
            if (aircraft.getName().equals(aircraftName)) {
                for (Passenger passenger : aircraft.getPassengers()) {
                    if (passenger.getSeatNumber() == seatNumber) {
                        return passenger;
                    }
                }
            }
        }
        return null; // Пассажир не найден
    }
}
