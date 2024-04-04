package midproject.SharedClasses.ReferenceClasses;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Order implements Serializable {


    private String orderId;
    private String userId;
    private List<OrderItem> items;
    private String status;
    private String modeOfDelivery;
    private String paymentMethod;
    private byte[] image;

    public Order(String orderId, String userId, List<OrderItem> items, String status, String modeOfDelivery, String paymentMethod, byte[] image) {
        this.orderId = orderId;
        this.userId = userId;
        this.items = items;
        this.status = status;
        this.modeOfDelivery = modeOfDelivery;
        this.paymentMethod = paymentMethod;
        this.image = image;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModeOfDelivery() {
        return modeOfDelivery;
    }

    public void setModeOfDelivery(String modeOfDelivery) {
        this.modeOfDelivery = modeOfDelivery;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }
    // Constructor, getters, and setters omitted for brevity
}
