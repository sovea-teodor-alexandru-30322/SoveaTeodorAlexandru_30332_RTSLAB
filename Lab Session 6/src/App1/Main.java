package App1;
import com.sun.org.apache.xpath.internal.axes.FilterExprWalker;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            // This task will run once all the threads reach the barrier
            @Override
            public void run() {
                System.out.println("All parties are at the barrier, so let's proceed");
            }
        });

        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();
        int[] times1 = {2, 4, 4, 6, 4};
        int[] times2 = {3, 5, 5, 7, 5};

        while(true)
        {
            new ExecutionThread(barrier, lock1, lock2, times1).start();
            new ExecutionThread(barrier, lock2, lock1, times2).start();
            barrier.await();
            barrier.reset();
        }


    }
}