package Ex4;

public class ExecutionThread extends Thread{

    final Integer monitor;
    int[] times;

    public ExecutionThread(Integer monitor, int[] times){
        this.monitor = monitor;
        this.times = times;
    }

    public void run(){

        while(true){
            System.out.println(this.getName() + " - STATE 1");
            synchronized (monitor){
                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (times[1] - times[0]) + times[0]);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
            }
            System.out.println(this.getName() + " - STATE 3");
            try {
                Thread.sleep((long)times[2] * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 4");
        }

    }
}
