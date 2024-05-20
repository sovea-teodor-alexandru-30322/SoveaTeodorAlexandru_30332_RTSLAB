package Ex4;

public class Main {
    public static void main(String[] args) {

        Integer monitor = new Integer(1);

        int[] t1 = {3, 6, 5};
        int[] t2 = {4, 7, 3};
        int[] t3 = {5, 7, 6};
        new ExecutionThread(monitor, t1).start();
        new ExecutionThread(monitor, t2).start();
        new ExecutionThread(monitor, t3).start();
    }
}
