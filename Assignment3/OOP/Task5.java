package Assignment3.OOP;

public class Task5 {
    private String type;

    public void initialize(String type) {
        this.type = type;
    }

    public static void main(String[] args) {
        Building building = new Building();
        building.initialize("Restaurant");
        building.initialize("Barbershop");
    }

    public String getType() {
        return type;
    }
}
