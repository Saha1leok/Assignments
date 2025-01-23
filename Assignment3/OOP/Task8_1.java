package Assignment3.OOP;

public class Task8 {
    public static void main(String[] args) {
        String s1 = "JavaITU";
        s1 = "JavaENU";
        String s2 = "JavaENU";
        String s3 = "JavaENU";

        System.out.println(s1 == s3); // This will be true
        System.out.println(s2.equals(s3)); // This will also be true
    }
}
