import Helpers.Helper;
import SOED.Organizations.Organization;
import SOED.Requests.Offers;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){

        //region Instances creation.

        Offers offers = new Offers(Helper.requestDonation_1ListCreation());

        Organization organization = new Organization("Organization 1", Helper.admin_1Creation(), Helper.entityListCreation(), Helper.donatorListCreation(), Helper.beneficiaryList_1Creation(), Helper.requestDonationList_1Creation());

        //endregion

        offers.commit();
        System.out.println("ORG: " + organization.getEntityList());

        ArrayList<String> animals = new ArrayList<>();
        String i = "bat";
        animals.add(i);
        animals.add("owl");
        animals.add(i);
        animals.add("bat");

        int occurrences = Collections.frequency(animals, "bat");

        System.out.println(occurrences);
    }
}
