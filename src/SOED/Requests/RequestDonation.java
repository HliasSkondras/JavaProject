package SOED.Requests;

import SOED.Entities.Entity;

public class RequestDonation {

    //region Private variables.

    private Entity entity;

    private double quantity;

    //endregion

    //region Constructors.

    public RequestDonation(Entity entity, double quantity) {
        this.entity = entity;
        this.quantity = quantity;
    }

    //endregion

    //region Public methods.

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    //endregion
}
