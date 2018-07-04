package poppaw;

import java.util.*;
//Answer can have more than one Value: comfort /speed 
public class SingleValue extends Value {
    //private String Param; //"comfort" or "speed"
    //private List<String> inputPattern = new ArrayList<>(); //comfort/speed;
    private String param; //na wszelki wypadek

    public SingleValue(String param, boolean selectionType) {
        super(selectionType);
        super.inputPattern.add(param); //["comfort"]
        this.param = param;
    }

    public String getParam(){ //jakby był potrzebny;
        return param;
    }
}