package poppaw;

import java.util.ArrayList;
import java.util.List;

public abstract class Value {
    protected List<String> inputPattern; 
    //if multuple: [gps,bluetooth,dvd,automatic transmission,self-driving]...
    // ... if single: [comfort] or [speed] / ["yes"] or ["no"];
    protected boolean selectionType; //true or false

    public Value(boolean selectionType){
        inputPattern = new ArrayList<>();
        this.selectionType = selectionType;
    }


    public List<String> getInputPattern(){
        return inputPattern;
    }
        
    public boolean getSelectionType(){
        return selectionType;
    }

    public String toString(){
        return  String.join(", ", inputPattern)
                +": " + Boolean.toString(selectionType);
    }
}