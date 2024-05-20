import java.util.*;
//Fir is the controller, it is an intermediary
public class Fir extends Observable implements Runnable {
    Thread t;

    int id;

    public void setId(int id) {
        this.id = id;
    }

    int processorLoad;

    public int getId() {
        return id;
    }

    Window win;
    public Window getWin() {
        return win;
    }

    public void setWin(Window win) {
        this.win = win;
    }


    public int getProcessorLoad() {
        return processorLoad;
    }

    public void setProcessorLoad(int processorLoad) {
        this.processorLoad = processorLoad;
    }

    Fir(int id, int priority, Window win, int procLoad){
        this.id=id;
        this.win=win;
        this.processorLoad=procLoad;

    }

    private void setPriority(int priority) {
        t.setPriority(priority);

    }

    public void run(){
        int c=0;
        while(c<1000){
            for(int j=0;j<this.processorLoad;j++){
                j++;j--;
            }
            c++;
           /* try {
               // this.win.setProgressValue(id, c);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            this.setChanged();

            this.notifyObservers();
        }
    }


    public Fir start() {
        return this;
    }
}