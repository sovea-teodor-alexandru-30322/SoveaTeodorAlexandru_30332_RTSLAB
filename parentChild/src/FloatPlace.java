import Interfaces.PlaceTemplate;

public class FloatPlace implements PlaceTemplate {
	Float value;
	String Name;

	public FloatPlace(String name, Object value) {
		this.Init(name, value);
	}

	@Override
	public Object Get() {
		return this.value;
	}

	@Override
	public void Set(Object value) {
		this.value = (Float) value;
	}

	@Override
	public String GetPlaceName() {
		return this.Name;
	}

	@Override
	public void SetPlaceName(String name) {
		this.Name = name;
	}

	@Override
	public String Print() {
		return "[" + this.Name + "=" + this.value + "]";
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
