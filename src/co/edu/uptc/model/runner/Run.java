package co.edu.uptc.model.runner;

import co.edu.uptc.model.customer.Customer;
import co.edu.uptc.model.customer.CustomerSerializer;
import co.edu.uptc.model.customer.CustomerDeserializer;

public class Run {
    public static void main(String[] args) {
        CustomerSerializer customerSerializer = new CustomerSerializer();
        CustomerDeserializer customerDeserializer = new CustomerDeserializer();

        Customer customer = new Customer("123456", "Calle de la casa", "12345678", "email@email.com");

        try {
            // Serializar el objeto
            customerSerializer.serializeCustomer(customer, "customers.dat");

            // Deserializar el objeto
            Customer deserializedCustomer = customerDeserializer.deserializeCustomer("customers.dat");

            // Mostrar el cliente deserializado
            if (deserializedCustomer != null) {
                System.out.println("Cliente deserializado: " + deserializedCustomer);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de errores
        }
    }
}
