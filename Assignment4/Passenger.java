class Passenger {
    private String name; 
    private int seatNumber; 
    private Aircraft aircraft; 

   
    public Passenger(String name, int seatNumber) {
        this.name = name;
        this.seatNumber = seatNumber;
    }

   
    public String getName() {
        return name;
    }

   
    public int getSeatNumber() {
        return seatNumber;
    }

    
    public Aircraft getAircraft() {
        return aircraft;
    }

    
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
