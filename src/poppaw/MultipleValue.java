package poppaw;

import java.util.*;
public class MultipleValue extends Value {

    private List<String> inputPattern; //[gps,bluetooth,dvd,automatic transmission,self-driving]
    public MultipleValue(List<String> params, boolean selectionType) {
        super(selectionType); //[true] or [false];
        super.inputPattern = params;
    }
    
     //Arrays.asList(getParameter().split("\\s*,\\s*")); //przy parsowaniu multipla
    
}