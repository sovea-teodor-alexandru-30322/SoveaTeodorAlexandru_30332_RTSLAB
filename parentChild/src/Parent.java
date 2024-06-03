import java.util.Scanner;

import Interfaces.PlaceTemplate;

public class 	Parent extends Thread {

	boolean stop = false;
	public Child r;
	PlaceHandler PH = new PlaceHandler();

	Parent_Transition_t_1 t_1;
	Parent_Transition_t_2 t_2;
	Parent_Transition_t_3 t_3;
	Scanner in = new Scanner(System.in);

	public void run() {

		PH.AddPlace(new FloatPlace("p_1", 0.0f));
		PH.AddPlace(r=new Child("p_2"));
		PH.AddPlace(new FloatPlace("p_3", null));
		PH.AddPlace(new FloatPlace("p_4", null));
		PH.AddPlace(new FloatPlace("p_5", null));

		t_1 = new Parent_Transition_t_1("t_1", PH, 0);
		t_1.ChildPH = r.PH;
		t_2 = new Parent_Transition_t_2("t_2", PH, 0);
		t_2.ChildPH = r.PH;
		t_3 = new Parent_Transition_t_3("t_3", PH, 0);
		

		System.out.println("Parent: Input p_4 value");
		this.PH.GetPlaceByName("p_4").Set(Float.parseFloat(in.nextLine()));

		while (!stop) {

			t_1.TransitionGuardsMappings();

			t_2.TransitionGuardsMappings();

			t_3.TransitionGuardsMappings();
			
			// For slower printing on the console
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
