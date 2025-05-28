package co.edu.uptc.model.customer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CustomerSerializer {

    public CustomerSerializer() {
    }

    public void serializeCustomer(Customer customer, String filePath) throws IOException {
        File outputFile = new File("customers.dat");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outputFile));
        out.writeObject(customer);
        out.close();
        
        System.out.println("Customer serialized successfully to " + filePath);
       
    }
    
}
