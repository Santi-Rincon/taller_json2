package co.edu.uptc.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ProductJsonWriter {
    public void writeProducts(List<Product> products, String filePath) throws IOException {
        JSONArray productList = new JSONArray();
        

        for(Product product : products) {
            JSONObject productObj = new JSONObject();
            productObj.put("productId", "001");
            productObj.put("description", "Producto X");
            productObj.put("presentation", "Caja");

            productObj.put("productId", product.getProductId());
            productObj.put("description", product.getDescription());
            productObj.put("presentation", product.getPresentation());

            productList.add(productObj);
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(productList.toJSONString());
            writer.flush();
            System.out.println("Productos guardados en JSON exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
