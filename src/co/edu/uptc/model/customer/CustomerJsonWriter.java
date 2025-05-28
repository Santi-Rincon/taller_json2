package co.edu.uptc.model.customer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CustomerJsonWriter {

    public void writeCustomers(List<Customer> customers, String filePath) {
        JSONArray customerList = new JSONArray();

        for (Customer customer : customers) {
            JSONObject customerObj = new JSONObject();
            customerObj.put("id", customer.getId());
            customerObj.put("address", customer.getAddress());
            customerObj.put("phone", customer.getPhone());
            customerObj.put("email", customer.getEmail());

            customerList.add(customerObj);
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(customerList.toJSONString());
            writer.flush();
            System.out.println("Clientes guardados en JSON exitosamente en " + filePath);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo JSON:");
            e.printStackTrace();
        }
    }
}
