package co.edu.uptc.persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import co.edu.uptc.model.Shipping;

public class ShippingSerializer {

    public ShippingSerializer() {
    }

    public void serializeShipping(Shipping shipping, String filePath) throws IOException {
        File outputFile = new File(filePath);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            out.writeObject(shipping);
            System.out.println("Shipping serialized successfully to " + filePath);
        }
    }
}