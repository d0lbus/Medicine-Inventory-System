package midproject.SharedClasses.ReferenceClasses;

import java.io.Serializable;
import java.util.List;

public class GenericName implements Serializable {
    private String _gname;
    private List<BrandName> brandName;

    // Constructors, getters, and setters
    public GenericName() {
    }

    public String get_gname() {
        return _gname;
    }

    public void set_gname(String _gname) {
        this._gname = _gname;
    }

    public List<BrandName> getBrandName() {
        return brandName;
    }

    public void setBrandName(List<BrandName> brandName) {
        this.brandName = brandName;
    }
}
