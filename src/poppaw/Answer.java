package poppaw;

import java.util.*;

public class Answer {
    private List<Value> values;
    
    public Answer() {
        this.values = new ArrayList<>();
    }

    public boolean evaluateAnswerByInput(String input) {
        for(Value value : values) {
            if (value.getInputPattern().contains(input)) {
                return value.getSelectionType();
            }
        }
        return false;
    }

    public void addValue(Value value) {
        values.add(value);
    }

    public List<Value> getValues(){
        return values;
    }

    public String toString(){
        return String.join("\n", values.toString());
    }
}