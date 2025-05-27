package co.edu.uptc.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ProductDeserializer {
    public Product deserializeProduct(String filePath) throws IOException, ClassNotFoundException {
        File outputFile = new File("products.dat");
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(outputFile));
            Product product = (Product) in.readObject();
            System.out.println("Product deserialized successfully from " + filePath);
            return product;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
