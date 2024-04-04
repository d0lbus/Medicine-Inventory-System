package midproject.SharedClasses.ReferenceClasses;

import java.io.Serializable;
import java.util.List;

public class OrderItem implements Serializable {
    private String medicineId;
    private String genericName;
    private String brandName;

    private String form;
    private int quantity;

    private double price;

    public OrderItem(String medicineId, String genericName, String brandName, String form, int quantity, double price) {
        this.medicineId = medicineId;
        this.genericName = genericName;
        this.brandName = brandName;
        this.form = form;
        this.quantity = quantity;
        this.price = price;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static double calculateTotalPrice(List<OrderItem> orderItems) {
        double total = 0;
        for (OrderItem item : orderItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

}
