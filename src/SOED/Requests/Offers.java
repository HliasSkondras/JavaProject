package SOED.Requests;

import Helpers.Helper;
import SOED.Organizations.Organization;

import java.util.List;

public class Offers extends RequestDonationList{

    //region Private variable.

    //endregion

    //region Constructors.

    public Offers(List<RequestDonation> rdEntities) {
        super(rdEntities);
    }

    //endregion

    //region Public methods.

    public void commit() {
        Organization organization = new Organization("Org", Helper.admin_1Creation(), Helper.entityListCreation(), Helper.donatorListCreation(), Helper.beneficiaryList_1Creation(), Helper.requestDonationList_1Creation());
        organization.setCurrentDonations(Helper.requestDonationList_1Creation());
    }

    //endregion
}
