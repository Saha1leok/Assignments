import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter airport name: ");
        String airportName = scanner.nextLine();
        Airport airport = new Airport(airportName);

        System.out.print("Enter the number of aircrafts: ");
        int numAircrafts = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numAircrafts; i++) {
            System.out.print("Enter name of aircraft " + (i + 1) + ": ");
            String aircraftName = scanner.nextLine();

            System.out.print("Enter maximum number of passengers for " + aircraftName + ": ");
            int maxPassengers = scanner.nextInt();
            scanner.nextLine();

            Aircraft aircraft = new Aircraft(aircraftName, maxPassengers);
            airport.addAircraft(aircraft);

            System.out.print("Enter the number of passengers for " + aircraftName + ": ");
            int numPassengers = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < numPassengers; j++) {
                System.out.print("Enter name of passenger " + (j + 1) + ": ");
                String passengerName = scanner.nextLine();

                System.out.print("Enter seat number for " + passengerName + ": ");
                int seatNumber = scanner.nextInt();
                scanner.nextLine();

                Passenger passenger = new Passenger(passengerName, seatNumber);
                aircraft.addPassenger(passenger);
            }
        }

        System.out.println("\nAirport: " + airport.getName());
        for (Aircraft aircraft : airport.getAircraftVehicles()) {
            System.out.println("  Aircraft: " + aircraft.getName());
            for (Passenger passenger : aircraft.getPassengers()) {
                System.out.println("    Passenger: " + passenger.getName() + ", Seat: " + passenger.getSeatNumber());
            }
        }

        System.out.print("\nSearch for a passenger. Enter aircraft name: ");
        String searchAircraftName = scanner.nextLine();

        System.out.print("Enter seat number: ");
        int searchSeatNumber = scanner.nextInt();

        Passenger foundPassenger = airport.searchPassenger(searchAircraftName, searchSeatNumber);
        if (foundPassenger != null) {
            System.out.println("Passenger found: " + foundPassenger.getName() + ", Seat: " + foundPassenger.getSeatNumber());
        } else {
            System.out.println("Passenger not found.");
        }

        scanner.close();
    }
}
