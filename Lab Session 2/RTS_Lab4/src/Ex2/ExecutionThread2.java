package Ex2;

public class ExecutionThread2 extends Thread {
    private final Integer monitor1, monitor2;

    int sleep_min, sleep_max, activity;

    public ExecutionThread2(Integer monitor1, Integer monitor2, int sleep_min, int
            sleep_max, int activity) {

        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity = activity;

    }

    public void run() {
        System.out.println(this.getName() + " 2sync - STATE 1");
        int k = (int) Math.round(Math.random() * (sleep_max - sleep_min) + sleep_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        System.out.println(this.getName() + " 2sync - STATE 2");
        synchronized(monitor1) {
            synchronized(monitor2){
                System.out.println(this.getName() + " sync - STATE 3");
                try {
                    Thread.sleep((long)activity*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(this.getName() + " 2sync - STATE 4");
    }

}
