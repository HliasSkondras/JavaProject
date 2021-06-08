package SOED.Requests;

import java.util.List;

public class RequestDonationList {

    //region Private variables.

    private List<RequestDonation> rdEntities;

    //endregion

    //region Constructors.

    public RequestDonationList(List<RequestDonation> rdEntities) {
        this.rdEntities = rdEntities;
    }

    //endregion

    //region Public Methods.

    public List<RequestDonation> getRdEntities() {
        return rdEntities;
    }

    public void setRdEntities(List<RequestDonation> rdEntities) {
        this.rdEntities = rdEntities;
    }

    @Override
    public String toString() {
        return "RequestDonationList{" +
                "rdEntities=" + rdEntities +
                '}';
    }

    //endregion
}
