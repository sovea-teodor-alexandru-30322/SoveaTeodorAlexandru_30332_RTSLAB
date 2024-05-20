package Ex2;

import Ex1.ExecutionThread;

public class Main {
    public static void main(String[] args) {
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(2);
        new ExecutionThread1(monitor1, 2, 4, 4).start();
        new ExecutionThread1(monitor2, 2, 5, 5).start();
        new ExecutionThread2(monitor1, monitor2, 3, 6, 3).start();
    }
}
