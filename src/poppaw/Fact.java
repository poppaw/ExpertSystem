package poppaw;

import java.util.*;

public class Fact {
    private String id;
    private String description;
    private Map<String,Boolean> idValues;

    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
        this.idValues = new HashMap<>();

    }

    public String getId() {
        return id;
    }

    public Map<String,Boolean> getIdValues() {
        return idValues;
    }

    public Set<String> getEvalsIdSet() { //może się przydać;
        return this.idValues.keySet();
      }

    public void setFactValueById(String id, Boolean value) {
        idValues.put(id,value);
    }

    public boolean getValueById(String id) {
        return idValues.get(id);
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
         
        String s = String.format("\nId: %s \n\tdescription: %s \n\t", id, description);
        for(String id: idValues.keySet())
            s+= String.format("\n\teval: %s,= %s", id, String.valueOf(getValueById(id)));
        return s;
    }
        

    
}