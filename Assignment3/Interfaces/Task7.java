package Assignment3.Interfaces;

public class Task7 {
    public static void main(String[] args) {
        System.out.println(Dream.HOBBY.toString());
        System.out.println(new Hobby().toString());
    }
    interface Desire {
    }
    interface Dream {
        Hobby HOBBY = new Hobby();
    }
    static class Hobby implements Desire, Dream {
        int INDEX = 1;

        @Override
        public String toString() {
            INDEX++;
            return "" + INDEX;
        }
    }
}
