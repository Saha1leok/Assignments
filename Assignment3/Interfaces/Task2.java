package Assignment3.Interfaces;

public class Task2 {
    public static void main(String[] args) {

    }
    public interface CanFly {
        public void Fly();
    }
    public interface CanMove {
        public void Move();
    }
    public interface CanEat {
        public void Eat();
    }
    public class Dog implements CanEat, CanMove{
        @Override
        public void Eat() {

        }

        @Override
        public void Move() {

        }
    }
    public class Duck implements CanEat, CanMove, CanFly {
        @Override
        public void Eat() {

        }

        @Override
        public void Fly() {

        }

        @Override
        public void Move() {

        }
    }
    public class Car implements CanMove {
        @Override
        public void Move() {

        }
    }
    public class Plane implements CanMove, CanFly {
        @Override
        public void Move() {

        }
        @Override
        public void Fly() {

        }
    }
}
