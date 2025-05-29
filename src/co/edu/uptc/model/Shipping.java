package co.edu.uptc.model;

import java.io.Serializable;

public class Shipping implements Serializable {
  

    private String shippingId;     
    private String carrier;        
    private String shippingDate;    
    private String status;         
    private String deliveryDate;   

    
    public Shipping() {
    }

    
    public Shipping(String shippingId, String carrier, String shippingDate, String status, String deliveryDate) {
        this.shippingId = shippingId;
        this.carrier = carrier;
        this.shippingDate = shippingDate;
        this.status = status;
        this.deliveryDate = deliveryDate;
    }

    
    public String getShippingId() {
        return shippingId;
    }

    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    // Método toString
    @Override
    public String toString() {
        return "Shipping{" +
                "shippingId='" + shippingId + '\'' +
                ", carrier='" + carrier + '\'' +
                ", shippingDate='" + shippingDate + '\'' +
                ", status='" + status + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                '}';
    }
}