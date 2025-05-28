package co.edu.uptc.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ProductDeserializer {

    public ProductDeserializer() {
    }

    public List<Product> deserializeProduct(String filePath) throws IOException, ClassNotFoundException {
        File inputFile = new File("products.dat");

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(inputFile))){
            List<Product> products = (List<Product>) in.readObject();
            System.out.println("Producto deserializado exitosamente desde " + filePath);
            return products;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
