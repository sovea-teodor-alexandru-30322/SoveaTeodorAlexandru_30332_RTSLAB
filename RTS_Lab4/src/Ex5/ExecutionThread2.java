package Ex5;

public class ExecutionThread2 extends Thread {
    int[] times;
    final Integer lock;
    Thread t1;
    public ExecutionThread2(Integer lock, Thread t1, int[] times){
        this.times = times;
        this.lock = lock;
        this.t1 = t1;
    }
    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        try {
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (times[1] - times[0]) + times[0]);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        System.out.println(this.getName() + " - STATE 3");
        if(t1 != null) {
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
