package App2;
import java.util.concurrent.Semaphore;
public class Fir extends Thread{
    int name;
    int delay;
    int k;
    int permit;
    Semaphore s;
    public Fir(int n, Semaphore s, int delay, int k, int permit) {
        this.name = n;
        this.s = s;
        this.delay = delay;
        this.k = k;
        this.permit = permit;
    }

    public void run() {

        while (true) {
            try {
                System.out.println("Fir " + this.name + " State 1");
                Thread.sleep(this.delay * 500);
                System.out.println("Fir " + this.name + " State 2");
                this.s.acquire(this.permit);
                System.out.println("Fir " + this.name + " took a token from the semaphore");
                System.out.println("Fir " + this.name + " State 3");
                for (int i = 0; i < this.k * 100000; i++) {
                    i++;
                    i--;
                }
                this.s.release(this.permit);
                System.out.println("Fir " + this.name + " released a token from the semaphore");
                System.out.println("Fir " + this.name + " State 4");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}