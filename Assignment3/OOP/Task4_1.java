package Assignment3.OOP;

public class Task4 {
    private final String manufacturer = "Lamborghini";
    private final String model;
    private final int year;
    private final String color;

    public Task4(String model, int year, String color) {

        this.model = model;
        this.year = year;
        this.color = color;
    }

    public Task4(String model, int year) {
        this(model, year, "Orange");
    }

    public Task4(String model) {
        this(model, 4321, "Orange");
    }
}
