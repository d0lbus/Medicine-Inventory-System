package midproject.SharedClasses.ReferenceClasses;

import java.io.Serializable;
import java.util.List;

/**
 * Represents an order placed by a user.
 */
public class Order implements Serializable {


    private String orderId;
    private String userId;
    private List<OrderItem> items;
    private String status;
    private String modeOfDelivery;
    private String paymentMethod;
    private String image;

    private Double total;

    /**
     * Default constructor for creating an order.
     */
    public Order (){

    }

    /**
     * Constructs an order with specified details.
     *
     * @param orderId       The unique identifier for the order.
     * @param userId        The unique identifier for the user who placed the order.
     * @param items         The list of items in the order.
     * @param status        The status of the order (e.g., "pending", "shipped").
     * @param modeOfDelivery The mode of delivery for the order (e.g., "express", "standard").
     * @param paymentMethod The payment method used for the order (e.g., "credit card", "cash").
     * @param image         The image associated with the order.
     * @param total         The total cost of the order.
     */
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

    /**
     * Gets the unique identifier for the order.
     *
     * @return The order ID.
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Sets the unique identifier for the order.
     * @param orderId The unique identifier for the order.
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the unique identifier for the user who placed the order.
     * @return The unique identifier for the user.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the unique identifier for the user who placed the order.
     * @param userId The unique identifier for the user.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the list of items in the order.
     * @return The list of items in the order.
     */
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * Sets the list of items in the order.
     * @param items The list of items in the order.
     */
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    /**
     * Gets the status of the order.
     * @return The status of the order.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the order.
     * @param status The status of the order.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the mode of delivery for the order.
     * @return The mode of delivery for the order.
     */
    public String getModeOfDelivery() {
        return modeOfDelivery;
    }

    /**
     * Sets the mode of delivery for the order.
     * @param modeOfDelivery The mode of delivery for the order.
     */
    public void setModeOfDelivery(String modeOfDelivery) {
        this.modeOfDelivery = modeOfDelivery;
    }

    /**
     * Gets the payment method used for the order.
     * @return The payment method used for the order.
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Gets the payment method used for the order.
     * @return The payment method used for the order.
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    /**
     * Sets the image associated with the order.
     * @param image The image associated with the order.
     */
    public void setImage(String image) {
        this.image = image;
    }
    /**
     * Gets the image associated with the order.
     * @return The image associated with the order.
     */
    public String getImage() {
        return image;
    }

    /**
     * Gets the total cost of the order.
     * @return The total cost of the order.
     */
    public Double getTotal() {
        return total;
    }

    /**
     * Sets the total cost of the order.
     * @param total The total cost of the order.
     */
    public void setTotal(Double total) {
        this.total = total;
    }
}
