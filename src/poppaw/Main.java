package poppaw;

public class Main {
    public static void main(String[] args) {
        FactParser factParser = new FactParser("Fact.xml");
        RuleParser ruleParser = new RuleParser("Rules.xml");
        ESProvider esProvider = new ESProvider(factParser, ruleParser);
        esProvider.collectAnswers();
        esProvider.evaluate();
    }
}