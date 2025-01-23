package Assignment3.OOP;

public class Task7 {
    public static void main(String[] args) {
        Programmer programmer = new Programmer();

        System.out.println("Current salary: " + programmer.getSalary());

        programmer.setSalary(1200);
        System.out.println("Updated salary: " + programmer.getSalary());

        programmer.setSalary(900);
        System.out.println("After trying to decrease salary: " + programmer.getSalary());
    }
}
