package Ex3;

public class Main {
    public static void main(String[] args) {
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(2);
        Integer monitorSh = new Integer(3);

        int[] t1 = {2, 4, 4, 6, 4};
        int[] t2 = {3, 5, 5, 7, 5};
        new ExecutionThread(monitor1, monitorSh, t1).start();
        new ExecutionThread(monitor2, monitorSh, t2).start();
    }
}
