package Assignment3.OOP;

public class Task13 {
    public void eat(Apple apple) {
        System.out.println("The apple has been eaten!");
    }

    public static void main(String[] args) {
        Apple apple = new Apple();

        Hedgehog hedgehog = new Hedgehog();

        hedgehog.eat(apple);
    }

    public static class Apple {
    }
}
