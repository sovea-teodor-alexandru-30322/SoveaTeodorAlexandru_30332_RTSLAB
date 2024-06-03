package App3;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {

        int[] t1 = {7, 2, 3};
        int[] t2 = {5, 3, 5};
        int[] t3 = {5, 4, 6};

        CountDownLatch latch = new CountDownLatch(2);

        Integer lock1 = new Integer(1);
        Integer lock2 = new Integer(1);

        // test comment to see that repo is ok
        ExecutionThread1 thread1 = new ExecutionThread1(latch, lock1, lock2, t1);
        ExecutionThread2 thread2 = new ExecutionThread2(latch, lock1, t2);
        ExecutionThread2 thread3 = new ExecutionThread2(latch, lock2, t3);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
