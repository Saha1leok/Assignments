import java.util.ArrayList;
import java.util.List;

class Aircraft {
    private String name; 
    private int maxPassengers; 
    private List<Passenger> passengers; 
   
    public Aircraft(String name, int maxPassengers) {
        this.name = name;
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    
    public String getName() {
        return name;
    }

    
    public int getMaxPassengers() {
        return maxPassengers;
    }

   
    public List<Passenger> getPassengers() {
        return passengers;
    }

   
    public void addPassenger(Passenger passenger) {
        if (passengers.size() < maxPassengers) {
            passengers.add(passenger);
            passenger.setAircraft(this); 
        } else {
            System.out.println("Нельзя добавить пассажира. Достигнута максимальная вместимость.");
        }
    }

    
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
        passenger.setAircraft(null); 
    }
}
