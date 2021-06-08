package SOED.Organizations;

import SOED.Entities.Entity;
import SOED.Requests.RequestDonationList;
import SOED.Users.Admin;
import SOED.Users.Beneficiary;
import SOED.Users.Donator;

import java.util.List;

public class Organization {

    //region Private variables.

    private String name;

    private Admin admin;

    private List<Entity> entityList;

    private List<Donator> donatorList;

    private List<Beneficiary> beneficiaryList;

    private RequestDonationList currentDonations;

    //endregion

    //region Constructors.

    public Organization(String name, Admin admin, List<Entity> entityList, List<Donator> donatorList, List<Beneficiary> beneficiaryList, RequestDonationList currentDonations) {
        this.name = name;
        this.admin = admin;
        this.entityList = entityList;
        this.donatorList = donatorList;
        this.beneficiaryList = beneficiaryList;
        this.currentDonations = currentDonations;
    }

    //endregion

    //region Public methods.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Entity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<Entity> entityList) {
        this.entityList = entityList;
    }

    public List<Donator> getDonatorList() {
        return donatorList;
    }

    public void setDonatorList(List<Donator> donatorList) {
        this.donatorList = donatorList;
    }

    public List<Beneficiary> getBeneficiaryList() {
        return beneficiaryList;
    }

    public void setBeneficiaryList(List<Beneficiary> beneficiaryList) {
        this.beneficiaryList = beneficiaryList;
    }

    public RequestDonationList getCurrentDonations() {
        return currentDonations;
    }

    public void setCurrentDonations(RequestDonationList currentDonations) {
        this.currentDonations = currentDonations;
    }

    //endregion
}
