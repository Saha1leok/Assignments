package Assignment3.OOP;

public class Task9 {
    private String model;
    private String color;
    private int price;

    public Task9(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true; // Same reference
        }
        if (obj instanceof Iphone) {
            Iphone other = (Iphone) obj;
            return this.model.equals(other.model) &&
                    this.color.equals(other.color) &&
                    this.price == other.price;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = model.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + price;
        return result;
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999);

        System.out.println(iphone1.equals(iphone2));
    }
}
