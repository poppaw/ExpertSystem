package poppaw;

import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

// package poppaw
public class FactParser extends XMLParser{
    private FactRepository factRepository;

    public FactParser(String filename) {
        super(filename);
        this.factRepository = new FactRepository();
        parse();
      }

    private void parse(){        
        Element factsRoot = super.document.getDocumentElement();
        factsRoot.normalize();//another topic;

        NodeList factsChildren = factsRoot.getElementsByTagName("Fact"); 
        //NodeList factsChildren = factsRoot.getChildNodes(); //another possibility;
        for (int i = 0; i< factsChildren.getLength();i++){
            Node factNode = factsChildren.item(i);
            if(factNode instanceof Element){
                Element fact = (Element) factNode;
                Fact carFact = createFact(fact);
                this.factRepository.addFact(carFact);
            }
        }                          
    }

    private static Fact createFact(Element fact){
        String brand = fact.getAttribute("id");
        Node descriptionNode = fact.getElementsByTagName("Description").item(0);//know that node has only one element;
        //Node descriptionNode = getFirstElementChild(fact); //alternative
        Element descriptionElement = (Element)descriptionNode;
        String description = descriptionElement.getAttribute("value");
        Fact carFact = new Fact(brand, description);
        setEvalsValue(fact, carFact);
        return carFact;
    }

    private static void setEvalsValue(Element fact, Fact carFact) {
        Node evalsNode = fact.getElementsByTagName("Evals").item(0);
        Element evalsElement = (Element) evalsNode;
        NodeList evalList = evalsElement.getElementsByTagName("Eval");
        for (int j = 0; j < evalList.getLength(); j++) {
            Node evalNode = evalList.item(j);
            Element evalElement = (Element) evalNode;
            String id = evalElement.getAttribute("id");
            String valueLabel = evalElement.getTextContent();
            boolean value = setEvalValue(valueLabel);
            carFact.setFactValueById(id,value);
        }
    }
        
    private static Node getFirstElementChild (Node parrentNode) { 
        Node childNode = parrentNode.getFirstChild();
        boolean isElement = childNode instanceof Element;
        while (!isElement){ 
            childNode = childNode.getNextSibling();
        }
        return childNode;  
    }

    private static boolean setEvalValue(String valueLabel) {
        if(valueLabel.equals("true")) {
            return true;
        }
        return false;
    }

    public FactRepository getFactRepository(){
        return this.factRepository;
    }

    //for tests only;
    public static void main(String[] args) {
        FactParser test = new FactParser("Fact.xml");
        FactRepository testFR = test.getFactRepository();
        Iterator<Fact> iter = testFR.getIterator();
        while (iter.hasNext())
            System.out.println(iter.next());

        //for (Fact carFact : testFR.getIterator()) {
          //  System.out.println(carFact)
        //}
    }
}