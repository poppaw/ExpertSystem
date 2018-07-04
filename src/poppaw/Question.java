package poppaw;

public class Question {
    public String id;
    public String question;
    public Answer answer;

    Question(String id, String question, Answer answer) {
        this.id = id;  // ex. "Money"
        this.question = question; //"Do you have 20.000.000 HUF for a car?""
        this.answer = answer;
    }

    public String getId() {
        return id;
    }
        
    public String getQuestion() {
        return question;
    }
        
    public Answer getAnswer() {
        return answer;
    }
    
    public boolean getEvaluatedAnswer(String input) {
        return answer.evaluateAnswerByInput(input);
    }

    public String toString(){
        String s = String.format("Rule id: %s, \n\tQuestion: %s", id, question);
        return s + "\n\t" + answer;

    }
}
