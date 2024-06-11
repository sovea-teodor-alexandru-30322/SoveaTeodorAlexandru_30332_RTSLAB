import Interfaces.PlaceHandlerTemplate;
import Interfaces.PlaceTemplate;
import Interfaces.TransitionTemplate;

public class Supervisor_Transition_t_2 implements TransitionTemplate {

    Integer timeUnitControl = 500;
    Integer eet;
    Integer let;
    String Name;
    PlaceHandlerTemplate PH;
    PlaceHandlerTemplate ControllerPH;

    public Supervisor_Transition_t_2(String name, PlaceHandlerTemplate PH, Integer delay){
        this.Init(name, PH);
        this.SetDelay(delay);
    }

    public Supervisor_Transition_t_2(String name, PlaceHandlerTemplate PH, Integer eet, Integer let) {
        this.Init(name, PH);
        this.SetDelayInRange(eet, let);
    }

    @Override
    public void TransitionDelay() {
        try {
            if (this.let == null) {
                Thread.sleep(this.eet * timeUnitControl);
            } else {
                Thread.sleep(Math.round(Math.random() * (this.let - this.eet) + this.eet) * timeUnitControl);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Boolean TransitionGuardsMappings() {
        TransitionDelay();
        String toPrint="--------------Supervisor--------------\n";

        if (!((C1_ps1)PH.GetPlaceByName("ps_1")).IsNull() && !PH.GetPlaceByName("ps_2").IsNull())
        {
            C1_psi1 val = ((C1_ps1)PH.GetPlaceByName("ps_1")).get(((C1_ps1)PH.GetPlaceByName("ps_1")).size()-1);

            if(!(val.r.equals(PH.GetPlaceByName("ps_2").Get()))){

                //PH.GetPlaceByName("ps_1").Set(1);
                PH.GetPlaceByName("ps_o1").Set(val.r);
                PH.GetPlaceByName("ps_3").Set(val.e);
                ((C1_ps1)PH.GetPlaceByName("ps_1")).remove(val);
                PH.GetPlaceByName("ps_2").Set(null);

                toPrint = toPrint.concat(Print() + "\n");
                toPrint = toPrint.concat("--------------------------------------\n");

                System.out.println(toPrint);
                return true;
            }
        }

        return false;
    }

    @Override
    public void Init(String name, PlaceHandlerTemplate PH) {
        this.PH = PH;
        this.Name = name;
    }

    @Override
    public void SetDelay(int value) {
        this.eet = value;
    }

    @Override
    public void SetDelayInRange(int eet, int let) {
        this.eet = eet;
        this.let = let;
    }

    @Override
    public String Print() {
        return this.Name + "\n" + this.PH.PrintAllPlaces();
    }

}
