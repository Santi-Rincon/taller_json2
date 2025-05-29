package co.edu.uptc.persistence;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import co.edu.uptc.model.Shipping;

public class ShippingJsonReader {

    public List<Shipping> readShippings(String filePath) {
        List<Shipping> shippings = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            Object obj = parser.parse(reader);
            JSONArray shippingArray = (JSONArray) obj;

            for (Object shippingObj : shippingArray) {
                JSONObject shippingJson = (JSONObject) shippingObj;

                String shippingId = (String) shippingJson.get("shippingId");
                String carrier = (String) shippingJson.get("carrier");
                String shippingDate = (String) shippingJson.get("shippingDate");
                String status = (String) shippingJson.get("status");
                String deliveryDate = (String) shippingJson.get("deliveryDate");

                Shipping shipping = new Shipping(shippingId, carrier, shippingDate, status, deliveryDate);
                shippings.add(shipping);
            }
            System.out.println("Shippings loaded from JSON successfully.");
        } catch (Exception e) {
            System.err.println("Error reading JSON file:");
            e.printStackTrace();
        }

        return shippings;
    }
}