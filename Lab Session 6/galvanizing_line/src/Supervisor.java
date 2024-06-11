import javax.naming.ldap.Control;
import java.util.Scanner;

public class Supervisor extends Thread {
    boolean stop = false;
    public Controller c;
    PlaceHandler PH = new PlaceHandler();
    Supervisor_Transition_t_1 t_1;
    Supervisor_Transition_t_2 t_2;
    Supervisor_Transition_t_3 t_3;
    Scanner in = new Scanner(System.in);

    public void run(){
        PH.AddPlace(new C1_psi1("ps_i1", null, null, null));
        PH.AddPlace(new C1_ps1("ps_1"));
        PH.AddPlace(new IntPlace("ps_o1", null));
        PH.AddPlace(new IntPlace("ps_2", 0));
        PH.AddPlace(new IntPlace("ps_3", 0));
        PH.AddPlace(new IntPlace("ps_o2", null));
        PH.AddPlace(new IntPlace("ps_i2", null));

        t_1 = new Supervisor_Transition_t_1("t_1", PH, 0);
        t_2 = new Supervisor_Transition_t_2("t_2", PH, 0);
        t_3 = new Supervisor_Transition_t_3("t_3", PH, 0);
        t_2.ControllerPH = c.PH;

        while(!stop){
            t_1.TransitionGuardsMappings();
            t_2.TransitionGuardsMappings();
            t_3.TransitionGuardsMappings();

            System.out.println("Supervisor: Input ps_i1 value");
            this.PH.GetPlaceByName("ps_i1").Set(new C1_psi1("ps_i1", 1, 1, 1));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    public void StopThread() {
        this.stop = true;
    }
}
