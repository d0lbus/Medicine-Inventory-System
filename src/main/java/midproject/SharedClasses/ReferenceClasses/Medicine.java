package midproject.SharedClasses.ReferenceClasses;

import java.io.Serializable;
import java.util.List;

public class Medicine implements Serializable {
    private List<GenericName> genericName;

    public Medicine() {}

    public List<GenericName> getGenericName() {
        return genericName;
    }

    public void setGenericName(List<GenericName> genericName) {
        this.genericName = genericName;
    }
}

