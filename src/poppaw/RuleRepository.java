package poppaw;

import java.util.*;

public class RuleRepository {
    private Map<String,Question> questions;

    public RuleRepository() {
        this.questions = new HashMap<>();
    }

    public Map<String,Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        String id = question.getId();
        questions.put(id,question);
    }

    public Question getQuestion(String id){
        return questions.get(id);
    }

    public Iterator<Question> getIterator() {
        return new QuestionIterator();
    }

    private class QuestionIterator implements Iterator<Question>{
        Iterator<Map.Entry<String, Question>> entries = questions.entrySet().iterator(); //#1
        //Set <String> keys = questions.keySet(); //#2
        

        public boolean hasNext(){
            return entries.hasNext(); //#1
            //return keys.iterator().hasNext(); //#2
        }

        public Question next()throws NoSuchElementException{
            if (!this.hasNext())
                throw new NoSuchElementException();
            return entries.next().getValue(); //#1
            //return questions.get(keys.iterator().next()); //#2 
        }
    }
}