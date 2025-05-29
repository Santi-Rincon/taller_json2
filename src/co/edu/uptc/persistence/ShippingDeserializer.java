package co.edu.uptc.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import co.edu.uptc.model.Shipping;

public class ShippingDeserializer {

    public ShippingDeserializer() {
    }

    public Shipping deserializeShipping(String filePath) {
        File inputFile = new File(filePath);

        if (!inputFile.exists()) {
            System.out.println("El archivo " + filePath + " no existe.");
            return null;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(inputFile))) {
            Shipping shipping = (Shipping) in.readObject();
            System.out.println("Envío deserializado correctamente desde " + filePath);
            return shipping;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar el envío:");
            e.printStackTrace();
            return null;
        }
    }
}
