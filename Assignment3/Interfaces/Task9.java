package Assignment3.Interfaces;

public class Task9 {
    public static void main(String[] args) {

    }
    public interface CanMove {
        double speed();
    }
    public interface CanFly extends CanMove {
        double speed(CanFly canFly);
    }
}
