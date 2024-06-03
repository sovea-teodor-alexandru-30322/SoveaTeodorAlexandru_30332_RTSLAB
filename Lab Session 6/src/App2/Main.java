package App2;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main
{
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        Semaphore sem1 = new Semaphore(1);
        Semaphore sem2 = new Semaphore(1);

        int[] times1 = {2, 4, 4};
        int[] times2 = {2, 5, 5};
        int[] times3 = {3, 6, 3};

        while(true){
            new ExecutionThread1(latch, sem1, times1).start();
            new ExecutionThread1(latch, sem2, times2).start();
            new ExecutionThread2(latch, sem1, sem2, times3).start();

            latch.await();
            latch = new CountDownLatch(3);
        }

    }

}
