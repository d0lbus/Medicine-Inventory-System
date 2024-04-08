package midproject.SharedClasses.ReferenceClasses;

import java.io.Serializable;
import java.util.List;

/**
 * Represents an item in an order.
 */
public class OrderItem implements Serializable {
    private String medicineId;
    private String genericName;
    private String brandName;
    private String form;
    private int quantity;
    private double price;

    /**
     * Constructs an OrderItem with the specified details.
     *
     * @param medicineId  The ID of the medicine.
     * @param genericName The generic name of the medicine.
     * @param brandName   The brand name of the medicine.
     * @param form        The form of the medicine.
     * @param quantity    The quantity of the medicine.
     * @param price       The price of the medicine.
     */
    public OrderItem(String medicineId, String genericName, String brandName, String form, int quantity, double price) {
        this.medicineId = medicineId;
        this.genericName = genericName;
        this.brandName = brandName;
        this.form = form;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Gets the ID of the medicine.
     *
     * @return The ID of the medicine.
     */
    public String getMedicineId() {
        return medicineId;
    }

    /**
     * Sets the ID of the medicine.
     *
     * @param medicineId The ID of the medicine.
     */
    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    /**
     * Gets the generic name of the medicine.
     *
     * @return The generic name of the medicine.
     */
    public String getGenericName() {
        return genericName;
    }

    /**
     * Sets the generic name of the medicine.
     *
     * @param genericName The generic name of the medicine.
     */
    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    /**
     * Gets the brand name of the medicine.
     *
     * @return The brand name of the medicine.
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Sets the brand name of the medicine.
     *
     * @param brandName The brand name of the medicine.
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * Gets the form of the medicine.
     *
     * @return The form of the medicine.
     */
    public String getForm() {
        return form;
    }

    /**
     * Sets the form of the medicine.
     *
     * @param form The form of the medicine.
     */
    public void setForm(String form) {
        this.form = form;
    }

    /**
     * Gets the quantity of the medicine.
     *
     * @return The quantity of the medicine.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the medicine.
     *
     * @param quantity The quantity of the medicine.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the price of the medicine.
     *
     * @return The price of the medicine.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the medicine.
     *
     * @param price The price of the medicine.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Calculates the total price of a list of order items.
     *
     * @param orderItems The list of order items.
     * @return The total price of all order items.
     */
    public static double calculateTotalPrice(List<OrderItem> orderItems) {
        double total = 0;
        for (OrderItem item : orderItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}
