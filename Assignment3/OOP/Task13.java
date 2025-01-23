package Assignment3.OOP;

public class Task13 {
    public void eat(Task13_Apple apple) {
        System.out.println("The apple has been eaten!");
    }

    public static void main(String[] args) {
        Task13_Apple apple = new Task13_Apple();

        Hedgehog hedgehog = new Hedgehog();

        hedgehog.eat(apple);
    }

    public static class Task13_Apple {
    }
}
