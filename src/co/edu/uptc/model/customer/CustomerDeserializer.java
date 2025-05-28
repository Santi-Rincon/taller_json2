package co.edu.uptc.model.customer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class CustomerDeserializer {

    public CustomerDeserializer() {
    }

    public Customer deserializeCustomer(String filePath) throws IOException, ClassNotFoundException {
        File inputFile = new File(filePath);

        if (!inputFile.exists()) {
            System.out.println("El archivo " + filePath + " no existe.");
            return null;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(inputFile))) {
            Customer customer = (Customer) in.readObject();
            System.out.println("Customer deserialized successfully from " + filePath);
            return customer;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar el cliente:");
            e.printStackTrace();
            return null;
        }
    }
}
