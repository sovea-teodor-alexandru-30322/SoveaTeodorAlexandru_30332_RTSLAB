package Ex3;

import Ex2.ExecutionThread2;

public class ExecutionThread extends Thread{

    final Integer monitor, monitorSh;
    int[] times;

    public ExecutionThread(Integer monitor, Integer monitorSh, int[] times){
        this.monitor = monitor;
        this.monitorSh = monitorSh;
        this.times = times;
    }

    public void run(){
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (times[1] - times[0]) + times[0]);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        synchronized (monitor) {
            synchronized (monitorSh){
                System.out.println(this.getName() + " - STATE 2");
                k = (int) Math.round(Math.random() * (times[3] - times[2]) + times[2]);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
            }
            System.out.println(this.getName() + " - STATE 3");
            try {
                Thread.sleep((long)times[4]*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName() + " - STATE 4");
    }

}
