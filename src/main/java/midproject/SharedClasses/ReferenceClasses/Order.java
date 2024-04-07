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
    private String image;

    private Double total;

    public Order (){

    }

    public Order(String orderId, String userId, List<OrderItem> items, String status, String modeOfDelivery, String paymentMethod, String image,  Double total) {
        this.orderId = orderId;
        this.userId = userId;
        this.items = items;
        this.status = status;
        this.modeOfDelivery = modeOfDelivery;
        this.paymentMethod = paymentMethod;
        this.image = image;
        this.total = total;
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

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
