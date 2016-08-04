package jaxpassignment;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JAXPassignment {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String path = JAXPassignment.class.getResource("catalog.xml").toString();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        dbf.setIgnoringElementContentWhitespace(true);
        
        Document doc = db.parse(path);
        Element root = doc.getDocumentElement();
        NodeList books = doc.getElementsByTagName("book");
        
        for (int i = 0; i < books.getLength(); i++) {
            Node book = books.item(i);
            double price = Double.parseDouble(((Element) book).getElementsByTagName("price").item(0).getTextContent());
            int year = Integer.parseInt(((Element) book).getElementsByTagName("publish_date").item(0).getTextContent().split("-")[0]);

            if (price > 10 && year > 2005) {
                System.out.println(book.getTextContent());
            }
        }

    }

}
