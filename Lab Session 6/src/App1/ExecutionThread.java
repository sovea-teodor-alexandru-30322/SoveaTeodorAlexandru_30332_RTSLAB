package App1;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.CyclicBarrier;

public class ExecutionThread extends Thread implements Runnable
{
    private CyclicBarrier barrier;
    private ReentrantLock lock1;
    private ReentrantLock lock2;
    private int[] times;

    public ExecutionThread(CyclicBarrier barrier, ReentrantLock lock1, ReentrantLock lock2, int[] times)
    {
        this.barrier = barrier;
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.times = times;
    }

    public void run()
    {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (times[1] - times[0]) + times[0]);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        lock1.lock();

        System.out.println(this.getName() + " - STATE 2");
        k = (int) Math.round(Math.random() * (times[3] - times[2]) + times[2]);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        if(lock2.tryLock())
        {
            System.out.println(this.getName() + " - STATE 3");
            try {
                Thread.sleep((long)times[4] * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock2.unlock();
            }
        }

        lock1.unlock();
        System.out.println(this.getName() + " - STATE 4");
        try
        {
            barrier.await();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
