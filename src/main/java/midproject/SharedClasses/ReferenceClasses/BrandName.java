package midproject.SharedClasses.ReferenceClasses;

import java.io.Serializable;

public class BrandName implements Serializable {
    private String _bname;
    private String form;
    private String quantity;
    private String price;

    public BrandName() {
    }

    public String get_bname() {
        return _bname;
    }

    public void set_bname(String _bname) {
        this._bname = _bname;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
