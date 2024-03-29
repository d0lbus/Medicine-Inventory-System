package midproject.SharedClasses.ReferenceClasses;


public class Medicine {
    private String category;
    private String genericName;
    private String brandName;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    private String form;
    private int quantity;
    private double price;

    public Medicine() {
    }

    public Medicine(String category, String genericName, String brandName, String form, int quantity, double price) {
        this.category = category;
        this.genericName = genericName;
        this.brandName = brandName;
        this.form = form;
        this.quantity = quantity;
        this.price = price;
    }

}

