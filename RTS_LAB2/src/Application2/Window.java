package Application2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Window extends JFrame implements Observer {

    private ArrayList<JProgressBar> bars = new ArrayList<>();

    public Window(int nrThreads) {
        setLayout(null);
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init(nrThreads);
        this.setVisible(true);
    }

    private void init(int n) {
        for (int i = 0; i < n; i++) {
            JProgressBar pb = new JProgressBar();
            pb.setMaximum(1000);
            pb.setBounds(50, (i + 1) * 30, 350, 20);
            this.add(pb);
            this.bars.add(pb);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Fir && arg instanceof Integer) {
            int id = ((Fir) o).getId();
            int value = (Integer) arg;
            setProgressValue(id, value);
        }
    }

    public void setProgressValue(int id, int val) {
        bars.get(id).setValue(val);
    }
}
