package midproject.SharedClasses.ReferenceClasses;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserCart implements Serializable {
    private String userId;
    private Map<String, Integer> items;

    public UserCart() {
        this.items = new HashMap<>();
    }

    public UserCart(String userId) {
        this.userId = userId;
        this.items = new HashMap<>();
    }

    public void addOrUpdateItem(String medicineId, int quantity) {
        items.put(medicineId, quantity);
    }

    public void removeItem(String medicineId) {
        items.remove(medicineId);
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // If you have other functionalities like clearing the cart, include those methods here.
    public void clearCart() {
        items.clear();
    }
}

