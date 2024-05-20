package Application2;
import java.util.Observable;

public class Fir extends Observable implements Runnable {

    private int id;
    private int processorLoad;

    Fir(int id, int priority, Window win, int procLoad) {
        this.id = id;
        this.processorLoad = procLoad;
        this.setPriority(priority);
    }

    private void setPriority(int priority) {
    }

    public void run() {
        int c = 0;

        while (c < 1000) {
            for (int j = 0; j < this.processorLoad; j++) {
                j++;
                j--;
            }
            c++;

            // Notify observers (View) about the progress
            setChanged();
            notifyObservers(c);
        }
    }

    public void start() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}