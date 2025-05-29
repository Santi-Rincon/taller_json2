package co.edu.uptc.persistence;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XmlToJson {

    public void convertXmlToJson(String xmlFilePath, String jsonFilePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            ProductHandler handler = new ProductHandler();

            saxParser.parse(new File(xmlFilePath), handler);

            ProductJsonWriter jsonWriter = new ProductJsonWriter();
            jsonWriter.writeProducts(handler.getProductList(), jsonFilePath);

            System.out.println("Conversión de XML a JSON completada.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
