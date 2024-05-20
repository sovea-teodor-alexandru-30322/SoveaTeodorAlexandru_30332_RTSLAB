
package App2.Lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ExecutionThread extends Thread {
    CountDownLatch countdownlatch;
    Lock lock1;
    Lock lock2;
    int sleep_min, sleep_max, activity_min, activity_max;

    public ExecutionThread(CountDownLatch countdownlatch, Lock lock1, Lock lock2, int sleep_min,
                           int sleep_max, int activity_min, int activity_max) {
        this.countdownlatch = countdownlatch;
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    public void run() {
            System.out.println(this.getName() + " - STATE 1");
            if (this.getName().equals("Thread-2")) {
                try {
                    if (this.lock1.tryLock(500000, TimeUnit.MILLISECONDS)) { //lock
                        try {
                            if (this.lock2.tryLock(500000, TimeUnit.MILLISECONDS)) {
                                try {
                                    System.out.println(this.getName() + " - STATE 2");
                                    int k2 = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                                    for (int i = 0; i < k2 * 100000; i++) {
                                        i++;
                                        i--;
                                    }

                                    try {
                                        Thread.sleep(Math.round(Math.random() * (sleep_max - sleep_min) + sleep_min) * 500);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } finally {
                                    this.lock2.unlock();
                                }
                            }
                        } finally {
                            this.lock1.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                try {
                    if (this.lock2.tryLock(500000, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println(this.getName() + " - STATE 2");
                            int k2 = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                            for (int i = 0; i < k2 * 100000; i++) {
                                i++;
                                i--;
                            }

                            try {
                                Thread.sleep(Math.round(Math.random() * (sleep_max - sleep_min) + sleep_min) * 500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } finally {
                            this.lock2.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this.getName() + " - STATE 3");
            System.out.println(this.getName() + " is waiting ");
            try {
                countdownlatch.countDown();
                countdownlatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    }


public class Main {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch barrier ;
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        while (true) { barrier = new CountDownLatch(4);
            ExecutionThread t1 = new ExecutionThread(barrier, lock1, lock2, 0, 4, 2, 4);
            ExecutionThread t2 = new ExecutionThread(barrier, lock1, lock2, 0, 3, 3, 6);
            ExecutionThread t3 = new ExecutionThread(barrier, lock1, lock2, 0, 5, 2, 5);
            t1.start();
            t2.start();
            t3.start();
            barrier.countDown();
            barrier.await();
        }
    }
}
