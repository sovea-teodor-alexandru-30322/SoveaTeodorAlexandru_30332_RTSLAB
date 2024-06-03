package App3;
import java.util.concurrent.CountDownLatch;

public class ExecutionThread2 extends Thread {
    CountDownLatch latch;
    int[] times;
    final Integer lock;

    public ExecutionThread2(CountDownLatch latch, Integer lock, int[] times){
        this.latch = latch;
        this.times = times;
        this.lock = lock;

    }
    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        try {
            Thread.sleep(times[0] * 1000);
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (times[2] - times[1]) + times[1]);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        System.out.println(this.getName() + " - STATE 3");
        latch.countDown();
    }
}
