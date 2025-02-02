class Passenger {
    private String name; // Имя пассажира
    private int seatNumber; // Номер места
    private Aircraft aircraft; // Самолет, к которому относится пассажир

    // Конструктор для создания пассажира
    public Passenger(String name, int seatNumber) {
        this.name = name;
        this.seatNumber = seatNumber;
    }

    // Метод для получения имени пассажира
    public String getName() {
        return name;
    }

    // Метод для получения номера места
    public int getSeatNumber() {
        return seatNumber;
    }

    // Метод для получения самолета
    public Aircraft getAircraft() {
        return aircraft;
    }

    // Метод для установки самолета
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
