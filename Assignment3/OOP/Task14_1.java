package Assignment3.OOP;

public class Task14 {
    public static void showWeather(City city) {
        String cityName = city.getName();
        int cityTemperature = city.getTemperature();

        System.out.println("In the city of " + cityName + " today, the temperature is " + cityTemperature);
    }

    public static void main(String[] args) {
        City city = new City("Dubai", 40);

        showWeather(city);
    }
}
