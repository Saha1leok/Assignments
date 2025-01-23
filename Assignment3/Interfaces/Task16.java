package Assignment3.Interfaces;

import java.awt.*;

public class Task16 {
    public static void main(String[] args) throws Exception {

    }

    public interface Animal {
        default Color getColor() {
            return Color.RED;
        }

        default Integer getAge() {
            return 5;
        }
    }

    public static class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }
}
