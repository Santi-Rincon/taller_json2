package co.edu.uptc.persistence;

import java.io.File;
import java.io.FileWriter;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.*;



public class ShippingXmlToJsonConverter {

    public void convertXmlToJson(String xmlFilePath, String jsonFilePath) {
        try {
            File inputFile = new File(xmlFilePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("shipping");
            JSONArray shippingList = new JSONArray();
            
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
            
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element shippingElement = (Element) node;
            
                    String shippingId = shippingElement.getAttribute("shippingId");
            
                    Node carrierNode = shippingElement.getElementsByTagName("carrier").item(0);
                    String carrier = (carrierNode != null) ? carrierNode.getTextContent() : null;
            
                    Node shippingDateNode = shippingElement.getElementsByTagName("shippingDate").item(0);
                    String shippingDate = (shippingDateNode != null) ? shippingDateNode.getTextContent() : null;
            
                    Node statusNode = shippingElement.getElementsByTagName("status").item(0);
                    String status = (statusNode != null) ? statusNode.getTextContent() : null;
            
                    Node deliveryDateNode = shippingElement.getElementsByTagName("deliveryDate").item(0);
                    String deliveryDate = (deliveryDateNode != null) ? deliveryDateNode.getTextContent() : null;
            
                    JSONObject shippingObj = new JSONObject();
                    shippingObj.put("shippingId", shippingId);
                    shippingObj.put("carrier", carrier);
                    shippingObj.put("shippingDate", shippingDate);
                    shippingObj.put("status", status);
                    shippingObj.put("deliveryDate", deliveryDate);
            
                    shippingList.add(shippingObj);
                }
            }

            try (FileWriter writer = new FileWriter(jsonFilePath)) {
                writer.write(shippingList.toJSONString());
                writer.flush();
                System.out.println("XML converted to JSON successfully: " + jsonFilePath);
            }
        } catch (Exception e) {
            System.err.println("Error converting XML to JSON:");
            e.printStackTrace();
        }
    }
}