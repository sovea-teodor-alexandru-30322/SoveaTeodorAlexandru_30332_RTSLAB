import Interfaces.PlaceTemplate;

public class C1_psi1 implements PlaceTemplate {
    public Integer r;
    public Integer e;
    public Integer l;
    public String Name;

    public C1_psi1(String name, Integer r, Integer e, Integer l){
        this.Name = name;
        this.r = r;
        this.e = e;
        this.l = l;
    }

    @Override
    public Object Get() {
        return this;
    }

    @Override
    public void Set(Object value) {

        if(value != null)
        {
            this.r = ((C1_psi1)value).r;
            this.e = ((C1_psi1)value).e;
            this.l = ((C1_psi1)value).l;
            System.out.println(this.r + this.e + this.l);
        }
        else {
            this.r = null;
            this.e = null;
            this.l = null;
        }

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
        return "[" + this.Name + "=(" + this.r +  " ," + this.e + " ," + this.l + ")]";
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
