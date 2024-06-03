import Interfaces.PlaceTemplate;

public class Child extends Thread implements PlaceTemplate {
	String name;
	boolean stop = false;
	PlaceHandler PH = new PlaceHandler();

	public Parent c;

	Child_Transition_t_1 t_1;
	Child_Transition_t_2 t_2;
	Child_Transition_t_3 t_3;
	Child_Transition_t_4 t_4;

	Boolean runningState = false;

	public Child(String name) {
		PH.AddPlace(new FloatPlace("p_21", null));
		PH.AddPlace(new FloatPlace("p_22", null));
		PH.AddPlace(new FloatPlace("p_23", null));
		PH.AddPlace(new FloatPlace("p_24", null));
		t_1 = new Child_Transition_t_1("t_1", PH, 0);
		t_2 = new Child_Transition_t_2("t_2", PH, 0);
		t_3 = new Child_Transition_t_3("t_3", PH, 0);
		t_4 = new Child_Transition_t_4("t_4", PH, 0);
		t_4.c = this;
		this.SetPlaceName(name);
	}

	public void run() {
		runningState = true;
		
		while (!stop) {
			t_1.TransitionGuardsMappings();
			t_2.TransitionGuardsMappings();
			t_3.TransitionGuardsMappings();
			t_4.TransitionGuardsMappings();

			// For slower printing on the console
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		runningState = false;
	}

	public void StopThread() {
		this.stop = true;
		this.runningState = false;
	}

	@Override
	public Object Get() {
		return this;
	}

	public boolean GetRunningState() {
		return this.runningState;
	}

	@Override
	public void Set(Object value) {
		//
	}

	@Override
	public String GetPlaceName() {
		return this.name;
	}

	@Override
	public void SetPlaceName(String name) {
		this.name = name;
	}

	@Override
	public String Print() {
		return "[" + this.name + "=" + this.runningState + "]";
	}

	@Override
	public void Init(String name, Object value) {
		this.SetPlaceName(name);
		this.Set(value);
	}

	@Override
	public Boolean IsNull() {
		return this.Get() == null;
	}
}
