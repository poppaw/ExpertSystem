package poppaw;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ESProvider {
    private FactRepository factRepository;
    private RuleRepository ruleRepository;
    private Map<String, Boolean> answers;
    private static Scanner userInput = new Scanner(System.in);

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factRepository = factParser.getFactRepository();
        this.ruleRepository = ruleParser.getRuleRepository();
      }
    public void collectAnswers() {
        Iterator<Question> iter = ruleRepository.getIterator();
        this.answers = new HashMap<>();
        while (iter.hasNext()) {
            Question question = iter.next();
            String questionId = question.getId();
            System.out.println(question.getQuestion());
            String userAnswer = userInput.nextLine();
            Boolean answerExist = isInputCorrect(userAnswer, question);
            while (!answerExist) {
                if (isInputCorrect(userAnswer, question))
                    break;
                else System.out.println("Please write correct answer: ");
                userAnswer = userInput.nextLine();
            }
            Boolean validation = getAnswerByQuestion(userAnswer, question);
            answers.put(questionId, validation);
        }
    }
    
    public boolean getAnswerByQuestion(String userAnswer, Question question) {
        return question.getEvaluatedAnswer(userAnswer);
    }
    
    private boolean isInputCorrect(String userAnswer, Question question) {
        List<Value> answerValues = question.getAnswer().getValues();
        for (int i = 0; i < answerValues.size(); i++) {
            for (int j = 0; j < answerValues.get(i).getInputPattern().size(); j++) {
                String value = answerValues.get(i).getInputPattern().get(j);
                if (userAnswer.equals(value)) 
                    return true;
        
            }
        }
        return false;
    }
    
    public void evaluate() {
        Iterator<Fact> factIterator = factRepository.getIterator();
        while (factIterator.hasNext()) {
            Fact currentlyCheckedFact = factIterator.next();
            if (testMatch(currentlyCheckedFact))
                System.out.println("You should buy a " + currentlyCheckedFact.getDescription());
          
        }
    }
    
    private boolean testMatch(Fact fact) {
        Set<String> factValueIdSet = fact.getEvalsIdSet();
    
        for (String id : factValueIdSet) {
            if (!this.answers.get(id).equals(fact.getValueById(id)))
                return false;
        }
        return true;
    }
}