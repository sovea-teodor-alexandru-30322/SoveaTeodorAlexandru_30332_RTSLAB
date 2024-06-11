import Interfaces.PlaceTemplate;
import java.util.ArrayList;

public class C1_ps1 extends ArrayList<C1_psi1> implements PlaceTemplate  {

    public String Name;

    public C1_ps1(String name){
        this.Name = name;
    }

    @Override
    public Object Get() {
        return this;
    }

    @Override
    public void Set(Object value) {


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
        return "[" + this.Name + "=(" + this.get(size()-1).r +  " ," + this.get(size()-1).e + " ," + this.get(size()-1).l + ")]";
    }

    @Override
    public void Init(String name, Object value) {
        this.SetPlaceName(name);
        this.Set(value);
    }

    @Override
    public Boolean IsNull() {
        if(this.isEmpty())
            return true;
        if(this.get(size()-1)==null)
            return true;
        if(this.get(size()-1).r==null || this.get(size()-1).l==null || this.get(size()-1).e==null)
            return true;
        return false;
    }
}
