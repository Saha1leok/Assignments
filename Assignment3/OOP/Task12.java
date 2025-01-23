package Assignment3.OOP;

public class Task12 {
    private static boolean hasEggs = true;

    public static void main(String[] args) {
        boolean hasEggs = false;
        makePurchases(hasEggs);
    }

    public static void makePurchases(boolean hasEggs) {
        if (hasEggs) {
            System.out.println("Bought 10 Batons");
        } else {
            System.out.println("Bought 1 loaf");
        }
    }
}
