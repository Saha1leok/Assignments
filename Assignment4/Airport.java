import java.util.ArrayList;
import java.util.List;
class Airport {
    private String name; // Имя аэропорта
    private List<Aircraft> aircraftVehicles; // Список самолетов

    // Конструктор для создания аэропорта
    public Airport(String name) {
        this.name = name;
        this.aircraftVehicles = new ArrayList<>();
    }

    // Метод для получения имени аэропорта
    public String getName() {
        return name;
    }

    // Метод для получения списка самолетов
    public List<Aircraft> getAircraftVehicles() {
        return aircraftVehicles;
    }

    // Метод для добавления самолета в аэропорт
    public void addAircraft(Aircraft aircraft) {
        aircraftVehicles.add(aircraft);
    }

    // Метод для удаления самолета из аэропорта
    public void removeAircraft(Aircraft aircraft) {
        aircraftVehicles.remove(aircraft);
    }

    // Метод для поиска пассажира по названию самолета и номеру места
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
