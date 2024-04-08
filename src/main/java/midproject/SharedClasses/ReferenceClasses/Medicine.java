package midproject.SharedClasses.ReferenceClasses;


import java.io.Serializable;

/**
 * This class represents a Medicine object.
 */
public class Medicine implements Serializable {

    private String MedicineID;
    private String Category;
    private String GenericName;
    private String BrandName;
    private String Form;
    private int Quantity;
    private double Price;

    /**
     * Default constructor for Medicine class.
     */
    public Medicine() {
    }

    /**
     * Parameterized constructor for Medicine class.
     * @param medicineID The ID of the medicine.
     * @param category The category of the medicine.
     * @param genericName The generic name of the medicine.
     * @param brandName The brand name of the medicine.
     * @param form The form of the medicine.
     * @param quantity The quantity of the medicine.
     * @param price The price of the medicine.
     */
    public Medicine(String medicineID, String category, String genericName, String brandName, String form, int quantity, double price) {
        this.MedicineID = medicineID;
        this.Category = category;
        this.GenericName = genericName;
        this.BrandName = brandName;
        this.Form = form;
        this.Quantity = quantity;
        this.Price = price;
    }

    /**
     * Retrieves the ID of the medicine.
     * @return The ID of the medicine.
     */
    public String getMedicineID() {
        return MedicineID;
    }

    /**
     * Sets the ID of the medicine.
     * @param medicineID The ID of the medicine.
     */
    public void setMedicineID(String medicineID) {
        MedicineID = medicineID;
    }

    /**
     * Retrieves the category of the medicine.
     * @return The category of the medicine.
     */
    public String getCategory() {
        return Category;
    }

    /**
     * Sets the category of the medicine.
     * @param category The category of the medicine.
     */
    public void setCategory(String category) {
        Category = category;
    }

    /**
     * Retrieves the generic name of the medicine.
     * @return The generic name of the medicine.
     */
    public String getGenericName() {
        return GenericName;
    }

    /**
     * Sets the generic name of the medicine.
     * @param genericName The generic name of the medicine.
     */
    public void setGenericName(String genericName) {
        GenericName = genericName;
    }

    /**
     * Retrieves the brand name of the medicine.
     * @return The brand name of the medicine.
     */
    public String getBrandName() {
        return BrandName;
    }

    /**
     * Sets the brand name of the medicine.
     * @param brandName The brand name of the medicine.
     */
    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    /**
     * Retrieves the form of the medicine.
     * @return The form of the medicine.
     */
    public String getForm() {
        return Form;
    }

    /**
     * Sets the form of the medicine.
     * @param form The form of the medicine.
     */
    public void setForm(String form) {
        Form = form;
    }

    /**
     * Retrieves the quantity of the medicine.
     * @return The quantity of the medicine.
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * Sets the quantity of the medicine.
     * @param quantity The quantity of the medicine.
     */
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    /**
     * Retrieves the price of the medicine.
     * @return The price of the medicine.
     */
    public double getPrice() {
        return Price;
    }

    /**
     * Sets the price of the medicine.
     * @param price The price of the medicine.
     */
    public void setPrice(double price) {
        Price = price;
    }
    /**
     * String representation of the Medicine object.
     * @return A string representation of the Medicine object.
     */
    @Override
    public String toString() {
        return "Medicine{" +
                "MedicineID='" + MedicineID + '\'' +
                ", Category='" + Category + '\'' +
                ", GenericName='" + GenericName + '\'' +
                ", BrandName='" + BrandName + '\'' +
                ", Form='" + Form + '\'' +
                ", Quantity=" + Quantity +
                ", Price=" + Price +
                '}';
    }
}