package SOED.Users;

import SOED.Requests.RequestDonationList;
import SOED.Requests.Requests;

import java.util.List;

public class Beneficiary extends User {

    //region Private variables.

    private final byte noPerson = 1;

    private List<RequestDonationList> receivedList;

    private Requests requestsList;

    //endregion

    //region Constructors.

    public Beneficiary(String name, String phone, List<RequestDonationList> receivedList, Requests requestsList) {
        super(name, phone);
        this.receivedList = receivedList;
        this.requestsList = requestsList;
    }

    //endregion

    //region Public methods.

    public byte getNoPerson() {
        return noPerson;
    }

    public List<RequestDonationList> getReceivedList() {
        return receivedList;
    }

    public void setReceivedList(List<RequestDonationList> receivedList) {
        this.receivedList = receivedList;
    }

    public Requests getRequestsList() {
        return requestsList;
    }

    public void setRequestsList(Requests requestsList) {
        this.requestsList = requestsList;
    }

    //endregion
}
