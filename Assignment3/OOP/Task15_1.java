package Assignment3.OOP;

public class Task15 {
    public static void main(String[] args) {
        Africa africa = new Africa(30_370_000);
        Antarctica antarctica = new Antarctica(14_200_000);
        Australia australia = new Australia(8_600_000);
        Eurasia eurasia = new Eurasia(55_000_000);
        NorthAmerica northAmerica = new NorthAmerica(24_709_000);
        SouthAmerica southAmerica = new SouthAmerica(17_840_000);

        System.out.println("Africa area: " + africa.getArea());
        System.out.println("Antarctica area: " + antarctica.getArea());
        System.out.println("Australia area: " + australia.getArea());
        System.out.println("Eurasia area: " + eurasia.getArea());
        System.out.println("North America area: " + northAmerica.getArea());
        System.out.println("South America area: " + southAmerica.getArea());
    }
}
