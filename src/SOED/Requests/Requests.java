package SOED.Requests;

//import SOED.Users.Beneficiary;

import java.util.List;

public class Requests extends RequestDonationList {

    //region Private variables.

    //private Beneficiary beneficiary;

    //endregion

    //region Constructors.

    public Requests(List<RequestDonation> rdEntities/*, Beneficiary beneficiary*/) {
        super(rdEntities);
        //this.beneficiary = beneficiary;
    }

    //endregion

    //region Public methods.

//    public Beneficiary getBeneficiary() {
//        return beneficiary;
//    }
//
//    public void setBeneficiary(Beneficiary beneficiary) {
//        this.beneficiary = beneficiary;
//    }

    //endregion
}
