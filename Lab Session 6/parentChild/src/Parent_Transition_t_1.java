import Interfaces.PlaceHandlerTemplate;
import Interfaces.TransitionTemplate;

public class Parent_Transition_t_1 implements TransitionTemplate {
	Integer timeUnitControl = 500;
	Integer eet;
	Integer let;
	String Name;
	PlaceHandlerTemplate PH;
	PlaceHandlerTemplate ChildPH;

	public Parent_Transition_t_1(String name, PlaceHandlerTemplate PH, Integer delay) {
		this.Init(name, PH);
		this.SetDelay(delay);
	}

	public Parent_Transition_t_1(String name, PlaceHandlerTemplate PH, Integer eet, Integer let) {
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
		String toPrint = "--------------Parent--------------\n";

		if (!PH.GetPlaceByName("p_1").IsNull() && !PH.GetPlaceByName("p_4").IsNull()) {
			if ((Float) (PH.GetPlaceByName("p_4").Get()) <= 1.0f) {
				toPrint = toPrint.concat(Print() + "\n");
				ChildPH.GetPlaceByName("p_21").Set(PH.GetPlaceByName("p_4").Get());
				((Child) (PH.GetPlaceByName("p_2"))).start();

				PH.GetPlaceByName("p_1").Set(null);
				PH.GetPlaceByName("p_4").Set(null);

				toPrint = toPrint.concat(Print() + "\n");
				toPrint = toPrint.concat("--------------------------------------\n");

				System.out.println(toPrint);
				return true;
			}
		
			if (!PH.GetPlaceByName("p_1").IsNull() && !PH.GetPlaceByName("p_4").IsNull()) {
				if ((Float) (PH.GetPlaceByName("p_4").Get()) > 1.0f) {
					toPrint = toPrint.concat(Print() + "\n");
					ChildPH.GetPlaceByName("p_21").Set(PH.GetPlaceByName("p_4").Get());
					PH.GetPlaceByName("p_1").Set(null);
					PH.GetPlaceByName("p_4").Set(null);

					toPrint = toPrint.concat(Print() + "\n");
					toPrint = toPrint.concat("--------------------------------------\n");
					System.out.println(toPrint);
					return true;
				}
			}
		}return false;
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