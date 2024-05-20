package Ex5;

public class ExecutionThread1 extends Thread {

    int[] times;
    final Integer lock1;
    final Integer lock2;
    public ExecutionThread1(Integer lock1, Integer lock2, int[] times){
        this.times = times;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }
    public void run(){
        System.out.println(this.getName() + " - STATE 1");
        try {
            Thread.sleep((long)times[0] * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (times[2] - times[1]) + times[1]);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        synchronized (lock1) {
            lock1.notify();
        }
        synchronized (lock2) {
            lock2.notify();
        }
        System.out.println(this.getName() + " - STATE 3");
    }
}
