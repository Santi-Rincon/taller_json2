package co.edu.uptc.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ProductSerializer{
    public void serializeProduct(Product product, String filePath) throws IOException {
        File outputFile = new File("products.dat");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outputFile));
        out.writeObject(product);
        out.close();
        
        System.out.println("Product serialized successfully to " + filePath);
       
    }


}
