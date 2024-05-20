//Window is the view, it represents the presentation layer
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import java.util.*;

public class Window extends JFrame implements Observer {
    ArrayList<JProgressBar> bars=new ArrayList<JProgressBar>();
    public Window(int nrThreads) {
        setLayout(null);
        setSize(450,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init(nrThreads);
        this.setVisible(true);
    }
    private void init(int n){
        for(int i=0 ;i<n; i++){
            JProgressBar pb=new JProgressBar();
            pb.setMaximum(1000);
            pb.setBounds(50,(i+1)*30,350,20);
            this.add(pb);
            this.bars.add(pb);
        }
    }
    public void setProgressValue(int id,int val) throws InterruptedException {
        bars.get(id).setValue(val);
        Thread.sleep(50);
    }

    public void update(Observable o, Object arg){
        int id=((Fir)o).getId();
        int processorLoad=((Fir)o).getProcessorLoad();
        try {
            setProgressValue(id,processorLoad);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}