package co.edu.uptc.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ProductSerializer{

    public void serializeProduct(List<Product> products, String filePath) throws IOException {
        File outputFile = new File("products.dat");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outputFile));
        out.writeObject(products);
        out.close();
        
        System.out.println("Producto serializado exitosamente en " + filePath);
       
    }


}
