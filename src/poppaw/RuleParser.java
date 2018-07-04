package poppaw;

import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// package poppaw
public class RuleParser extends XMLParser{
    private RuleRepository ruleRepository;

    public RuleParser(String filename) {
        super(filename);
        this.ruleRepository = new RuleRepository();
        parse();
    }

    public RuleRepository getRuleRepository (){
        return ruleRepository;
    }


    private void parse(){        
        Element rulesRoot = super.document.getDocumentElement();
        rulesRoot.normalize();//another topic;
        NodeList rulesList = rulesRoot.getElementsByTagName("Rule");

        for (int i = 0; i < rulesList.getLength(); i++) {
            Element rule = (Element) rulesList.item(i);
            Question question = createQuestion(rule);
            ruleRepository.addQuestion(question);
        }
    }

    private static Question createQuestion(Element rule) { //poppaw
        String id = rule.getAttribute("id");

        Element elementQuestion = (Element) rule.getElementsByTagName("Question").item(0); //the only one element in each rule node
        String question = elementQuestion.getTextContent();

        NodeList selections = rule.getElementsByTagName("Selection");
        Answer answer = createCompletedAnswer(selections);
        
        return new Question(id, question, answer);
    }

    private static Answer createCompletedAnswer(NodeList selections) {
        Answer answer = new Answer();
        for (int i = 0; i < selections.getLength(); i++) {
            Element selectionElement = (Element) selections.item(i);
            Value selectionValue = extractValue(selectionElement);
            answer.addValue(selectionValue);
        }
        return answer;
    }
            
            
    private static Value extractValue(Element selectionElement) {
        boolean selectionType = selectionElement.getAttribute("value").equals("true");
        //NodeList allValues = selectionElement.getElementsBy(".*Value");
        NodeList singleValues = selectionElement.getElementsByTagName("SingleValue");
        NodeList multipleValues = selectionElement.getElementsByTagName("MultipleValue");
    
        if (!(singleValues.getLength() > 0)) { //if (single is empty): multiple;
            Element multipleValueElement = (Element) multipleValues.item(0); //every selection has only one element node;
            String param = multipleValueElement.getAttribute("value");
            List<String> params = Arrays.asList(param.split(","));
            return new MultipleValue(params, selectionType);
        }
        else { //if not multiple: must be single;
            Element singleValueElement = (Element) singleValues.item(0);
            String param = singleValueElement.getAttribute("value");
            return new SingleValue(param, selectionType);
        }   
    }

    public static void main(String[] args) {
        RuleParser test = new RuleParser("Rules.xml");
        RuleRepository testRep = test.getRuleRepository();
        Iterator iter = testRep.getIterator();
        while(iter.hasNext())
            System.out.println(iter.next());


    }
}