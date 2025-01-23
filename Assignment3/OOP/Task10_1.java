package Assignment3.OOP;

public class Task10 {
    private String model;
    private int year;

    public Task10(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }

    public static void main(String[] args) {
        Car lamborghini = new Car("Lamborghini", 2020);
        Car lamborghini1 = new Car("Lamborghini", 2020);
        Car ferrari = new Car("Ferrari", 2020);
        Car ferrari1 = new Car("Ferrari", 2020);
        Car bugatti = new Car("Bugatti", 2020);
        Car bugatti1 = new Car("Bugatti", 2020);

        System.out.println(ferrari.hashCode() == ferrari.hashCode());
        System.out.println(lamborghini.hashCode() == lamborghini1.hashCode());
        System.out.println(ferrari.hashCode() == ferrari1.hashCode());
        System.out.println(bugatti.hashCode() == bugatti1.hashCode());
        System.out.println(bugatti.hashCode() == lamborghini.hashCode());
        System.out.println(lamborghini.hashCode() == ferrari.hashCode());
    }
}
