package Assignment3.OOP;

public class Task6 {
    public static void main(String[] args) {
            Bugatti myBugatti = new Bugatti();

            System.out.println("Current body type: " + myBugatti.getBody());

            myBugatti.setBody("Convertible");

            System.out.println("Updated body type: " + myBugatti.getBody());
    }
}
