package SOED.Users;

import SOED.Requests.Offers;

import java.util.List;

public class Donator extends User {

    //region Private variables.

    private List<Offers> offersList;

    //endregion

    //region Constructors.

    public Donator(String name, String phone, List<Offers> offersList) {
        super(name, phone);
        this.offersList = offersList;
    }

    //endregion

    //region Public methods.

    public List<Offers> getOffersList() {
        return offersList;
    }

    public void setOffersList(List<Offers> offersList) {
        this.offersList = offersList;
    }


    //endregion
}
