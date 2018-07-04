package poppaw;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

// package poppaw
public abstract class XMLParser {
    protected Document document; //must be vissible by descendants!

    public XMLParser (String xmlPath){
        loadXMLDocument(xmlPath);
    }


    private void loadXMLDocument(String xmlPath) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            this.document = builder.parse(xmlPath);
        }
        catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
    