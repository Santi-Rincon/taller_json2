package co.edu.uptc.persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import co.edu.uptc.model.Shipping;

public class ShippingJsonWriter {

    public void writeShippings(List<Shipping> shippings, String filePath) {
        JSONArray shippingList = new JSONArray();

        for (Shipping shipping : shippings) {
            JSONObject shippingObj = new JSONObject();
            shippingObj.put("shippingId", shipping.getShippingId());
            shippingObj.put("carrier", shipping.getCarrier());
            shippingObj.put("shippingDate", shipping.getShippingDate());
            shippingObj.put("status", shipping.getStatus());
            shippingObj.put("deliveryDate", shipping.getDeliveryDate());

            shippingList.add(shippingObj);
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(shippingList.toJSONString());
            writer.flush();
            System.out.println("Envíos guardados en JSON exitosamente en " + filePath);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo JSON:");
            e.printStackTrace();
        }
    }
}
