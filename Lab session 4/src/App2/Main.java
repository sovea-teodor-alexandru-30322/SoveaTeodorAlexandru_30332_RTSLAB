package App2;
import java.util.concurrent.Semaphore;
public class Main {
    public static void main(String []args) {
        Semaphore semaphore = new Semaphore(4);
        Fir f1 = new Fir(1, semaphore, 2, (int) Math.round(Math.random() * 3 + 2), 2);
        Fir f2 = new Fir(2, semaphore, 4, (int) Math.round(Math.random() * 3 + 3), 2);
        f1.start();
        f2.start();
    }
}