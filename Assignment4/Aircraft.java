import java.util.ArrayList;
import java.util.List;

class Aircraft {
    private String name; // Название самолета
    private int maxPassengers; // Максимальное количество пассажиров
    private List<Passenger> passengers; // Список пассажиров

    // Конструктор для создания самолета
    public Aircraft(String name, int maxPassengers) {
        this.name = name;
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    // Метод для получения названия самолета
    public String getName() {
        return name;
    }

    // Метод для получения максимального количества пассажиров
    public int getMaxPassengers() {
        return maxPassengers;
    }

    // Метод для получения списка пассажиров
    public List<Passenger> getPassengers() {
        return passengers;
    }

    // Метод для добавления пассажира в самолет
    public void addPassenger(Passenger passenger) {
        if (passengers.size() < maxPassengers) {
            passengers.add(passenger);
            passenger.setAircraft(this); // Устанавливаем самолет для пассажира
        } else {
            System.out.println("Нельзя добавить пассажира. Достигнута максимальная вместимость.");
        }
    }

    // Метод для удаления пассажира из самолета
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
        passenger.setAircraft(null); // Убираем связь с самолетом
    }
}
