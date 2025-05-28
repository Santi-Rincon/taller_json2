package co.edu.uptc.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ProductJsonReader {

    public List<Product> readProducts(String filePath) {
        List<Product> products = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            Object obj = parser.parse(reader);
            JSONArray productList = (JSONArray) obj;

            for (Object productObj : productList) {
                JSONObject jsonProduct = (JSONObject) productObj;
                
                String productId = (String) jsonProduct.get("productId");
                String description = (String) jsonProduct.get("description");
                String presentation = (String) jsonProduct.get("presentation");

                Product product = new Product(productId, description, presentation);
                products.add(product);
            }

            System.out.println("Productos leídos exitosamente desde JSON.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
