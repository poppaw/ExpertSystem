package poppaw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FactRepository {
    List<Fact> facts;

    public FactRepository() {
        this.facts = new ArrayList<>();
    }

    public void addFact(Fact fact) {
        this.facts.add(fact);
    }

    public Iterator<Fact> getIterator() {
        return new FactIterator();
    }

    private class FactIterator implements Iterator<Fact>{
        int index = 0;

        public boolean hasNext(){
            return index < facts.size();
        }

        public Fact next()throws NoSuchElementException{
            if (!this.hasNext())
                throw new NoSuchElementException();
            return facts.get(index++); 
        }
    }
}