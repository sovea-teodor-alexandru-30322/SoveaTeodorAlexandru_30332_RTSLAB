package App2;
import App1.ExecutionThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.CountDownLatch;

public class ExecutionThread1 extends Thread {
    CountDownLatch latch;
    Semaphore sem;

    int[] times;

    public ExecutionThread1(CountDownLatch latch, Semaphore sem, int[] times) {
        this.latch = latch;
        this.sem = sem;
        this.times = times;
    }

    public void run()
    {
        System.out.println(this.getName() + " - STATE 1");
        try
        {
            sem.acquire();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (times[1] - times[0]) + times[0]);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        try
        {
            Thread.sleep(times[2] * 1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        sem.release();
        System.out.println(this.getName() + " - STATE 3");
        latch.countDown();

    }
}
