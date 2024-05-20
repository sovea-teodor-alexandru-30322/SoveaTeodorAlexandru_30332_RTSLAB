package Application2;

public class FirController {

    public static void main(String[] args) {
        int noOfThreads = 6;
        Window win = new Window(noOfThreads);

        for (int i = 0; i < noOfThreads; i++) {
            Fir fir = new Fir(i, i + 2, win, 1000000);
            fir.addObserver(win); // Register the Window as an observer
            new Thread(fir).start();
        }
    }
}