package SOED.Entities;

public class Service extends Entity {

    //region Constructors.

    public Service(String name, String description, int id) {
        super(name, description, id);
    }

    //endregion

    //region Public methods.

    public String getDetails() {
        return toString();
    }

    @Override
    public String toString() {
        return "Service{This is a service}";
    }

    //endregion
}
