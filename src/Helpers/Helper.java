package Helpers;

import SOED.Entities.Entity;
import SOED.Entities.Material;
import SOED.Entities.Service;
import SOED.Organizations.Organization;
import SOED.Requests.Offers;
import SOED.Requests.RequestDonation;
import SOED.Requests.RequestDonationList;
import SOED.Requests.Requests;
import SOED.Users.Admin;
import SOED.Users.Beneficiary;
import SOED.Users.Donator;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static Material material_1Creation() {
        return new Material("Material_1", "Description for material 1", 1, 1, 2, 5);
    }

    public static Material material_2Creation() {
        return new Material("Material_2", "Description for material 2", 4, 1, 4, 7);
    }

    public static Material material_3Creation() {
        return new Material("Material_3", "Description for material 3", 5, 1, 2, 5);
    }

    public static List<Material> materials() {
        List<Material> materials = new ArrayList<>();
        materials.add(material_1Creation());
        materials.add(material_2Creation());
        materials.add(material_3Creation());

        return materials;
    }

    public static List<Material> materialsEmpty() {
        return new ArrayList<>();
    }

    public static Service service_1Creation() {
        return new Service("Service_1", "Description for service 1", 2);
    }

    public static Service service_2Creation() {
        return new Service("Service_2", "Description for service 2", 3);
    }

    public static List<Service> services() {
        List<Service> services = new ArrayList<>();
        services.add(service_1Creation());
        services.add(service_2Creation());

        return services;
    }

    public static List<Service> servicesEmpty() {
        return new ArrayList<>();
    }

    public static List<Entity> entityListCreation() {
        List<Entity> entityList = new ArrayList<>();

        entityList.add(material_1Creation());
        entityList.add(service_1Creation());

        return entityList;
    }

    public static List<Entity> entityListCreationEmpty() {
        return new ArrayList<>();
    }

    public static Admin admin_1Creation() {
        return new Admin("Admin_1", "6982063681", true);
    }

    public static Admin admin_2Creation() {
        return new Admin("Admin_2", "6982063682", false);
    }

    public static List<Admin> admins() {
        List<Admin> admins = new ArrayList<>();
        admins.add(admin_1Creation());
        admins.add(admin_2Creation());

        return admins;
    }

    public static List<Admin> adminsEmpty() {
        return new ArrayList<>();
    }

    public static RequestDonation requestDonation_1Creation() {
        return new RequestDonation(material_1Creation(), 2.0);
    }

    public static RequestDonation requestDonation_2Creation() {
        return new RequestDonation(service_2Creation(), 7.0);
    }

    public static List<RequestDonation> requestDonationListCreationEmpty() {
        return new ArrayList<>();
    }

    public static List<RequestDonation> requestDonation_1ListCreation() {
        RequestDonation requestDonation1 = new RequestDonation(material_1Creation(), 2.0);
        RequestDonation requestDonation2 = new RequestDonation(service_1Creation(), 4.0);

        List<RequestDonation> requestDonationList = new ArrayList<>();
        requestDonationList.add(requestDonation1);
        requestDonationList.add(requestDonation2);

        return requestDonationList;
    }

    public static List<RequestDonation> requestDonations() {
        List<RequestDonation> requestDonations = new ArrayList<>();
        requestDonations.add(requestDonation_1Creation());
        requestDonations.add(requestDonation_2Creation());

        return requestDonations;
    }

    public static List<RequestDonation> requestDonationsEmpty() {
        return new ArrayList<>();
    }

    public static Offers offers_1Creation() {
        return new Offers(requestDonation_1ListCreation());
    }

    public static Offers offers_2Creation() {
        return new Offers(requestDonation_1ListCreation());
    }

    public static List<Offers> offersListCreationEmpty() {
        return new ArrayList<>();
    }

    public static List<Offers> offersList_1Creation() {
        Offers offers1 = new Offers(requestDonation_1ListCreation());
        Offers offers2 = new Offers(requestDonation_1ListCreation());

        List<Offers> offersList = new ArrayList<>();
        offersList.add(offers1);
        offersList.add(offers2);

        return offersList;
    }

    public static List<Offers> offers() {
        List<Offers> offers = new ArrayList<>();
        offers.add(offers_1Creation());
        offers.add(offers_2Creation());

        return offers;
    }

    public static List<Offers> offersEmpty() {
        return new ArrayList<>();
    }

    public static Donator donatorCreation(String mobile) {
        return new Donator("Donator", mobile, offersList_1Creation());
    }

    public static Donator donator_1Creation() {
        return new Donator("Donator_1", "6987654321", offersList_1Creation());
    }

    public static Donator donator_2Creation() {
        return new Donator("Donator_2", "6912345678", offersList_1Creation());
    }

    public static List<Donator> donators() {
        List<Donator> donators = new ArrayList<>();
        donators.add(donator_1Creation());
        donators.add(donator_2Creation());

        return donators;
    }

    public static List<Donator> donatorsEmpty() {
        return new ArrayList<>();
    }

    public static List<Donator> donatorListCreation() {
        List<Donator> donatorList = new ArrayList<>();

        donatorList.add(donator_1Creation());
        donatorList.add(donator_2Creation());

        return donatorList;
    }

    public static List<Donator> donatorListCreationEmpty() {
        return new ArrayList<>();
    }

    public static RequestDonationList requestDonationList_1Creation() {
        return new RequestDonationList(requestDonation_1ListCreation());
    }

    public static RequestDonationList requestDonationList_2Creation() {
        return new RequestDonationList(requestDonation_1ListCreation());
    }

    public static List<RequestDonationList> requestDonationListList_1Creation() {
        List<RequestDonationList> requestDonationListList = new ArrayList<>();

        requestDonationListList.add(requestDonationList_1Creation());

        return requestDonationListList;
    }

    public static List<RequestDonationList> requestDonationListListCreationEmpty() {
        return new ArrayList<>();
    }

    public static List<RequestDonationList> requestDonationLists() {
        List<RequestDonationList> requestDonationLists = new ArrayList<>();
        requestDonationLists.add(requestDonationList_1Creation());
        requestDonationLists.add(requestDonationList_2Creation());

        return requestDonationLists;
    }

    public static List<RequestDonationList> requestDonationListsEmpty() {
        return new ArrayList<>();
    }

    public static Requests requestsCreation() {
        return new Requests(requestDonation_1ListCreation());
    }

    public static Requests requestsCreationEmpty() {
        return new Requests(requestDonationListCreationEmpty());
    }

    public static Requests requests_1Creation() {
        return new Requests(requestDonation_1ListCreation());
    }

    public static Requests requests_2Creation() {
        return new Requests(requestDonation_1ListCreation());
    }

    public static List<Requests> requests() {
        List<Requests> requests = new ArrayList<>();
        requests.add(requests_1Creation());
        requests.add(requests_2Creation());

        return requests;
    }

    public static List<Requests> requestsEmpty() {
        return new ArrayList<>();
    }

    public static  Beneficiary beneficiaryCreation(String mobile) {
        return new Beneficiary("Beneficiary", mobile, requestDonationListListCreationEmpty(), requestsCreationEmpty());
    }

    public static Beneficiary beneficiary_1Creation() {
        return new Beneficiary("Beneficiary_1", "6987654321", requestDonationListList_1Creation(), requests_1Creation());
    }

    public static Beneficiary beneficiary_2Creation() {
        return new Beneficiary("Beneficiary_2", "6987654322", requestDonationListList_1Creation(), requests_1Creation());
    }

    public static List<Beneficiary> beneficiaries() {
        List<Beneficiary> beneficiaries = new ArrayList<>();
        beneficiaries.add(beneficiary_1Creation());
        beneficiaries.add(beneficiary_2Creation());

        return beneficiaries;
    }

    public static List<Beneficiary> beneficiariesEmpty() {
        return new ArrayList<>();
    }

    public static List<Beneficiary> beneficiaryList_1Creation() {
        List<Beneficiary> donatorList = new ArrayList<>();

        donatorList.add(beneficiary_1Creation());
        donatorList.add(beneficiary_2Creation());

        return donatorList;
    }

    public static List<Beneficiary> beneficiaryListCreationEmpty() {
        return new ArrayList<>();
    }

    public static Organization organization_1Creation() {
        return new Organization("Organization 1", Helper.admin_1Creation(), Helper.entityListCreation(), Helper.donatorListCreation(), Helper.beneficiaryList_1Creation(), Helper.requestDonationList_1Creation());
    }

    public static Organization organization_2Creation() {
        return new Organization("Organization 2", Helper.admin_1Creation(), Helper.entityListCreation(), Helper.donatorListCreation(), Helper.beneficiaryList_1Creation(), Helper.requestDonationList_1Creation());
    }

    public static List<Organization> organizations() {
        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization_1Creation());
        organizations.add(organization_2Creation());

        return organizations;
    }

    public static List<Organization> organizationsEmpty() {
        return new ArrayList<>();
    }
}
