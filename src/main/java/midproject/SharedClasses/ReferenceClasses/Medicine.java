package midproject.SharedClasses.ReferenceClasses;


import java.io.Serializable;

public class Medicine implements Serializable {
    private String Category;
    private String GenericName;
    private String BrandName;
    private String Form;
    private int Quantity;
    private double Price;

    public Medicine() {
    }

    public Medicine(String category, String genericName, String brandName, String form, int quantity, double price) {
        this.Category = category;
        this.GenericName = genericName;
        this.BrandName = brandName;
        this.Form = form;
        this.Quantity = quantity;
        this.Price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getGenericName() {
        return GenericName;
    }

    public void setGenericName(String genericName) {
        GenericName = genericName;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public String getForm() {
        return Form;
    }

    public void setForm(String form) {
        Form = form;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}

