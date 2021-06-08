import Helpers.Helper;
import SOED.Users.Beneficiary;
import SOED.Users.Donator;

import java.util.*;

public class Menu {
    public static void main(String[] args){

        //region Initializations.

        //region Creates entities

        //region Creates a material entity.

        var materials = Helper.materials();

        //endregion

        //region Creates a service entity.

        var services = Helper.services();

        //endregion

        //endregion

        //region Creates users.

        //region Creates an admin user.

        var admins = Helper.admins();

        //endregion

        //region Creates a beneficiary user.

        var beneficiaries = Helper.beneficiaries();

        //endregion

        //region Creates a donator user.

        var donators = Helper.donators();

        //endregion

        //endregion

        //region Creates requests.

        var requests = Helper.requests();

        //region Creates an offer request.

        var offers = Helper.offers();

        //endregion

        //region Creates a request donation request.

        var requestDonations = Helper.requestDonations();

        //endregion

        //region Creates a request donation list request.

        var requestDonationLists = Helper.requestDonationLists();

        //endregion

        //endregion

        //region Creates an organization.

        var organizations = Helper.organizations();

        //endregion

        //endregion

        //region User interface.

        var wantToBack = false;
        var wantToLogout = false;

        do {
            wantToBack = false;
            wantToLogout = false;

            // Asks for mobile.
            Scanner mobileInput = new Scanner(System.in);
            System.out.print("Enter your mobile: ");

            // Enters the mobile phone.
            String mobile = mobileInput.nextLine();

            // Grants the access to the user.
            boolean hasAccess = false;

            // What user is it.
            var donorOrBeneficiaryOrAdmin = "";

            //region Searches if the user exists.

            // For every admin.
            for (var admin : admins) {
                if (admin.getPhone().equals(mobile)) {
                    hasAccess = true;
                    donorOrBeneficiaryOrAdmin = "Admin";
                    break;
                }
            }

            // For every beneficiary.
            for (var beneficiary : beneficiaries) {
                if (beneficiary.getPhone().equals(mobile)) {
                    hasAccess = true;
                    donorOrBeneficiaryOrAdmin = "Beneficiary";
                    break;
                }
            }

            // For every donator.
            for (var donator : donators) {
                if (donator.getPhone().equals(mobile)) {
                    donorOrBeneficiaryOrAdmin = "Donator";
                    hasAccess = true;
                    break;
                }
            }

            //endregion

            //region If the user already exists.

            if (hasAccess) {
                System.out.println("There is a user.");
            }

            //endregion

            //region If it is a new user.

            else {
                // Asks the user if he is interested to enroll.
                Scanner interestInput = new Scanner(System.in);
                System.out.println("Are you interested to enroll to the platform? y/n");

                // Enters y/n
                char interest = interestInput.next().charAt(0);

                while (interest != 'y' && interest != 'n') {
                    System.out.println("Are you interested to enroll to the platform? y/n");
                    interest = interestInput.next().charAt(0);
                }
                if (interest == 'y') {
                    Scanner donorOrBeneficiaryOrAdminInput = new Scanner(System.in);
                    System.out.println("Are you a Donator or a Beneficiary?");

                    // Enters what the user wants.
                    donorOrBeneficiaryOrAdmin = donorOrBeneficiaryOrAdminInput.nextLine();

                    while (!donorOrBeneficiaryOrAdmin.equals("Donator") && !donorOrBeneficiaryOrAdmin.equals("Beneficiary")) {
                        System.out.println("Are you a Donator or a Beneficiary?\nDonator/Beneficiary");
                        donorOrBeneficiaryOrAdmin = donorOrBeneficiaryOrAdminInput.nextLine();
                    }
                }
                else {
                    System.out.println("It was nice meeting you!!!");
                }
            }

            //endregion

            //region UI

            if (donorOrBeneficiaryOrAdmin.equals("Donator") || donorOrBeneficiaryOrAdmin.equals("Beneficiary") || donorOrBeneficiaryOrAdmin.equals("Admin")) {

                //region If it is a Donator.

                if(donorOrBeneficiaryOrAdmin.equals("Donator")) {
                    var donator = Helper.donatorCreation(mobile);
                    donators.add(donator);
                    System.out.println("Welcome donator " + donator.getName());
                    // Prints the existing organizations names.
                    do {
                        System.out.println("\nOrganizations:");
                        for (var organization : organizations)
                            System.out.println(organization.getName());

                        System.out.println("\n\nWhat would you like to do?");
                        System.out.println("1. Add offer.");
                        System.out.println("2. Show offers.");
                        System.out.println("3. Commit.");
                        System.out.println("4. Back.");
                        System.out.println("5. Logout.");
                        System.out.println("6. Exit.");

                        Scanner choiceInput = new Scanner(System.in);
                        var choice = choiceInput.next();

                        switch (choice) {
                            case "1":
                                System.out.println("Add offer.");

                                // Prints the existing material information.
                                System.out.println("\n1. Materials:");
                                for (var material : materials)
                                    System.out.println(material.getEntityInfo());

                                // Prints the existing service information.
                                System.out.println("\n2. Services:");

                                for (var service : services)
                                    System.out.println(service.getEntityInfo());

                                System.out.println("Add offer");
                                Scanner donateInput = new Scanner(System.in);
                                System.out.println("\nWould you like to donate? y/n");

                                // Asks the user to choose an id.
                                char donate = donateInput.next().charAt(0);

                                while (donate != 'y' && donate != 'n') {
                                    System.out.println("\nWould you like to donate? y/n");
                                    donate = donateInput.next().charAt(0);
                                }

                                if (donate == 'y') {
                                    Scanner chooseIdInput = new Scanner(System.in);
                                    System.out.print("\nChoose an id to support: ");

                                    // Asks the user to choose an id.
                                    int chooseId = chooseIdInput.nextInt();
                                    for (var material : materials) {
                                        if (material.getId() == chooseId) {
                                            materials.add(material);
                                            System.out.println("You successfully supported material with id: "+ material.getId());
                                            break;
                                        }
                                    }
                                    for (var service : services) {
                                        if (service.getId() == chooseId) {
                                            services.add(service);
                                            System.out.println("You successfully supported service with id: "+ service.getId());
                                            break;
                                        }
                                    }
                                }
                                break;
                            case "2":
                                System.out.println("Show offers.");

                                System.out.println("\nOffers");
                                for (var offer : offers) {
                                    System.out.println("Offer No. " + offer.hashCode() + ":");
                                    for (var entity : offer.getRdEntities()) {
                                        System.out.println("Entity No. " + entity.hashCode() + "\t\t" + entity.getEntity() + "\t--->\t(" + entity.getQuantity() + ")");
                                    }
                                }

                                // Asks the user if he wants to choose an offer.
                                Scanner offerInput = new Scanner(System.in);
                                System.out.println("\nWould you like to choose an offer? y/n");

                                // Enters y/n.
                                char offer = offerInput.next().charAt(0);

                                while (offer != 'y' && offer != 'n') {
                                    System.out.println("\nWould you like to choose an offer? y/n");
                                    offer = offerInput.next().charAt(0);
                                }

                                if (offer == 'y') {
                                    System.out.println("Please choose an offer No. and an entity No.");
                                    // Asks the user to choose an offer number.
                                    Scanner offerNumberInput = new Scanner(System.in);
                                    System.out.print("Offer No.: ");

                                    // Enters a number.
                                    int offerNumber = offerNumberInput.nextInt();

                                    // Asks the user to choose an offer number.
                                    Scanner entityNumberInput = new Scanner(System.in);
                                    System.out.print("Entity No.: ");

                                    // Enters a number.
                                    int entityNumber = entityNumberInput.nextInt();

                                    for (var offer2 : offers) {
                                        if (offer2.hashCode() == offerNumber) {
                                            for (var entity2 : offer2.getRdEntities()) {
                                                if (entity2.hashCode() == entityNumber) {
                                                    System.out.println("Entity No. " + entity2.hashCode() + "\t\t" + entity2.getEntity() + "\t--->\t(" + entity2.getQuantity() + ")");

                                                    Scanner deleteOrEditInput = new Scanner(System.in);
                                                    System.out.println("\nDo you want to delete or edit the entity?");

                                                    String deleteOrEdit = deleteOrEditInput.next();

                                                    while (!deleteOrEdit.equals("delete") && !deleteOrEdit.equals("edit")) {
                                                        System.out.println("\nDo you want to delete or edit the entity?");
                                                        deleteOrEdit = deleteOrEditInput.next();
                                                    }
                                                    if (deleteOrEdit.equals("delete")) {
                                                        offer2.getRdEntities().remove(entity2);
                                                        System.out.println("Entity No. " + entity2.hashCode() + "\t\t" + entity2.getEntity() + "\t--->\t(" + entity2.getQuantity() + ")\tDeleted.");
                                                    } else {
                                                        Scanner quantityInput = new Scanner(System.in);
                                                        System.out.println("\nSet the new quantity");

                                                        double quantity = quantityInput.nextDouble();
                                                        entity2.setQuantity(quantity);
                                                        System.out.println("Entity No. " + entity2.hashCode() + "\t\t" + entity2.getEntity() + "\t--->\t(" + entity2.getQuantity() + ")");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                            case "3":
                                System.out.println("Commit.");

                                // Asks the user if he is interested to enroll.
                                Scanner commitInput = new Scanner(System.in);
                                System.out.println("Would you like to commit the current entities? y/n");

                                // Enters y/n
                                char commit = commitInput.next().charAt(0);

                                while (commit != 'y' && commit != 'n') {
                                    System.out.println("Would you like to commit the current entities? y/n");
                                    commit = commitInput.next().charAt(0);
                                }

                                if (commit == 'y') {
                                    var list1 = new ArrayList<>();
                                    for (var donation : requestDonationLists) {
                                        for (var offer3 : donation.getRdEntities()) {
                                            list1.add(offer3.getEntity());
                                        }
                                    }
                                    System.out.println(list1);
                                    var list2 = new ArrayList<>();
                                    for (var organization : organizations) {
                                        for (var currentDonations : organization.getCurrentDonations().getRdEntities()) {
                                            list2.add(currentDonations.getEntity());
                                        }
                                    }
                                    for (var i : list1) {
                                        if (!list2.contains(i)) {
                                            list2.add(i);
                                        }
                                    }
                                    System.out.println("Commit successful.");
                                    System.out.println(list2);
                                    for (var donation : requestDonationLists) {
                                        for (var offer3 : donation.getRdEntities()) {
                                            donation.getRdEntities().remove(offer3);
                                        }
                                    }
                                    System.out.println("Delete successful.");
                                }
                                break;

                            case "4":
                                System.out.println("Go back...");
                                wantToBack = false;
                                break;

                            case "5":
                                System.out.println("Logging out...");
                                wantToBack = true;
                                wantToLogout = false;
                                break;

                            case "6":
                                System.out.println("Exiting...");
                                return;
                        }
                    }while(!wantToBack);
                }

                //endregion

                //region If it is a Beneficiary.

                if (donorOrBeneficiaryOrAdmin.equals("Beneficiary")) {
                    var beneficiary = Helper.beneficiaryCreation(mobile);
                    beneficiaries.add(beneficiary);
                    System.out.println("Welcome beneficiary " + beneficiary.getName());
                    do {
                        System.out.println("\n\nWhat would you like to do?");
                        System.out.println("1. Add request.");
                        System.out.println("2. Show requests.");
                        System.out.println("3. Commit.");
                        System.out.println("4. Back.");
                        System.out.println("5. Logout.");
                        System.out.println("6. Exit.");

                        Scanner choiceInput = new Scanner(System.in);
                        var choice = choiceInput.next();

                        switch (choice) {
                            case "1":
                                Scanner requestInput = new Scanner(System.in);
                                System.out.println("Do you want to add a request? y/n");

                                // Enters what the user wants.
                                char request = requestInput.next().charAt(0);

                                while (request != 'y' && request != 'n') {
                                    System.out.println("Do you want to add a request? y/n");
                                    request = requestInput.next().charAt(0);
                                }

                                if (request == 'y') {
                                    Scanner materialOrServiceInput = new Scanner(System.in);
                                    System.out.println("What would you like to request for?\nmaterial/service");

                                    // Enters what the user wants.
                                    String materialOrService = materialOrServiceInput.nextLine();

                                    while (!materialOrService.equals("material") && !materialOrService.equals("service")) {
                                        System.out.println("What would you like to request for?\nmaterial/service");
                                        materialOrService = materialOrServiceInput.nextLine();
                                    }
                                    if (materialOrService.equals("material")) {
                                        System.out.println("Materials:");
                                        if (!materials.isEmpty()){
                                            for (var material : materials) {
                                                System.out.println(material);
                                            }
                                            requestDonationLists.add(Helper.requestDonationList_1Creation());
                                            System.out.println("Your material has been requested");
                                        }else {
                                            System.out.println("Sorry, there are no materials...");
                                        }
                                    } else {
                                        System.out.println("Services:");
                                        if (!services.isEmpty()){
                                            for (var service : services) {
                                                System.out.println(service);
                                            }
                                            requestDonationLists.add(Helper.requestDonationList_2Creation());
                                            System.out.println("Your service has been requested");
                                        }else {
                                            System.out.println("Sorry, there are no services...");
                                        }
                                    }
                                }
                                break;
                            case "2":
                                Scanner showRequestsInput = new Scanner(System.in);
                                System.out.println("Would you like to see the current requests? y/n");

                                // Enters what the user wants.
                                char showRequests = showRequestsInput.next().charAt(0);

                                while (showRequests != 'y' && showRequests != 'n') {
                                    System.out.println("Would you like to see the current requests? y/n");
                                    showRequests = showRequestsInput.next().charAt(0);
                                }

                                if (showRequests == 'y') {
                                    for (var request1 : requests) {
                                        for (var req : request1.getRdEntities()) {
                                            System.out.println(req.getEntity() + "\t--->\t(" + req.getQuantity() + ")");
                                        }
                                    }
                                }
                                break;
                            case "3":
                                Scanner commitInput = new Scanner(System.in);
                                System.out.println("Would you like to commit? y/n");

                                // Enters what the user wants.
                                char commit = commitInput.next().charAt(0);

                                while (commit != 'y' && commit != 'n') {
                                    System.out.println("Would you like to commit? y/n");
                                    commit = commitInput.next().charAt(0);
                                }

                                if (commit == 'y') {
                                    for (var requestDonation : requestDonationLists) {
                                        for (var entity : requestDonation.getRdEntities()) {
                                            System.out.println(entity.getQuantity());
                                        }
                                    }
                                }
                                break;

                            case "4":
                                System.out.println("Go back...");
                                wantToBack = false;
                                break;

                            case "5":
                                System.out.println("Logging out...");
                                wantToBack = true;
                                wantToLogout = false;
                                break;

                            case "6":
                                System.out.println("Exiting...");
                                return;
                        }
                    }while (!wantToBack);
                }

                //endregion

                //region If it is an Admin.

                if(donorOrBeneficiaryOrAdmin.equals("Admin")) {
                    System.out.println("Welcome Admin\n");
                    do {
                        System.out.println("\n\nWhat would you like to do?");
                        System.out.println("1. View requests.");
                        System.out.println("2. Monitor Organizations.");
                        System.out.println("3. Back.");
                        System.out.println("4. Logout.");
                        System.out.println("5. Exit.");

                        Scanner choiceInput = new Scanner(System.in);
                        var choice = choiceInput.next();

                        switch (choice) {
                            case "1":
                                for (var organizationCurrentDonations : organizations) {
                                    for (var organizationCurrentDonation : organizationCurrentDonations.getCurrentDonations().getRdEntities()) {
                                        System.out.println(organizationCurrentDonation.getEntity() + "\t\t-->\t\t(" +organizationCurrentDonation.getQuantity() + ")");
                                    }
                                }

                                System.out.println("Choose materials or services?");
                                Scanner materialOrServiceInput = new Scanner(System.in);
                                var materialOrService = materialOrServiceInput.nextLine();

                                while (!materialOrService.equals("materials") && !materialOrService.equals("services")) {
                                    System.out.println("Choose materials or services?");
                                    materialOrService = materialOrServiceInput.nextLine();
                                }

                                if (materialOrService.equals("materials")) {
                                    for (var material : materials) {
                                        System.out.println(material.getId());
                                    }
                                    System.out.println("Choose one of the ids above?");
                                    Scanner idsInput = new Scanner(System.in);
                                    var ids = idsInput.nextInt();
                                    for (var material : materials) {
                                        if (material.getId() == ids) {
                                            System.out.println(material.getDetails());
                                            System.out.println(material.getEntityInfo());
                                            break;
                                        }
                                    }
                                }
                                else {
                                    for (var service : services) {
                                        System.out.println(service.getId());
                                    }
                                    System.out.println("Choose one of the ids above?");
                                    Scanner idsInput = new Scanner(System.in);
                                    var ids = idsInput.nextInt();
                                    for (var service : services) {
                                        if (service.getId() == ids) {
                                            System.out.println(service.getDetails());
                                            System.out.println(service.getEntityInfo());
                                            break;
                                        }
                                    }
                                }

                                break;
                            case "2":
                                for (var beneficiary : beneficiaries) {
                                    System.out.println(beneficiary.getName());
                                }

                                System.out.println("Would you like to choose one?");
                                Scanner beneficiaryNameInput = new Scanner(System.in);
                                var beneficiaryName = beneficiaryNameInput.nextLine();

                                List<Beneficiary> toRemoveBeneficiary = new ArrayList<>();

                                for (var beneficiary : beneficiaries) {
                                    if (beneficiary.getName().equals(beneficiaryName)){
                                        for (var beneficiaryReceivedLists : beneficiary.getReceivedList()) {
                                            for (var beneficiaryReceivedList : beneficiaryReceivedLists.getRdEntities()) {
                                                System.out.println(beneficiaryReceivedList.getEntity());
                                            }
                                        }
                                        Scanner deleteListInput = new Scanner(System.in);
                                        System.out.println("Would you like to clear users received list? y/n");
                                        // Enters what the user wants.
                                        char deleteList = deleteListInput.next().charAt(0);

                                        while (deleteList != 'y' && deleteList != 'n') {
                                            System.out.println("Would you like to clear users received list? y/n");
                                            deleteList = deleteListInput.next().charAt(0);
                                        }

                                        if (deleteList == 'y') {
                                            for (var beneficiaryReceivedLists : beneficiary.getReceivedList()) {
                                                beneficiaryReceivedLists.getRdEntities().clear();
                                                System.out.println("Received list cleared successfully for beneficiary: " + beneficiaryName);
                                            }
                                        }
                                        Scanner deleteUserInput = new Scanner(System.in);
                                        System.out.println("Would you like to delete current user? y/n");
                                        // Enters what the user wants.
                                        char deleteUser = deleteUserInput.next().charAt(0);

                                        while (deleteUser != 'y' && deleteUser != 'n') {
                                            System.out.println("Would you like to delete current user? y/n");
                                            deleteUser = deleteUserInput.next().charAt(0);
                                        }

                                        if (deleteUser == 'y') {
                                            toRemoveBeneficiary.add(beneficiary);
                                            System.out.println("Beneficiary successfully deleted.");
                                        }
                                    }
                                }
                                beneficiaries.removeAll(toRemoveBeneficiary);

                                for (var donator : donators) {
                                    System.out.println(donator.getName());
                                }

                                System.out.println("Would you like to choose one?");
                                Scanner donatorNameInput = new Scanner(System.in);
                                var donatorName = donatorNameInput.nextLine();

                                List<Donator> toRemoveDonator = new ArrayList<>();

                                for (var donator : donators) {
                                    if (donator.getName().equals(donatorName)){
                                        for (var donatorOffersLists : donator.getOffersList()) {
                                            for (var donatorOffersList : donatorOffersLists.getRdEntities()) {
                                                System.out.println(donatorOffersList.getEntity());
                                            }
                                        }
                                        Scanner deleteUserInput = new Scanner(System.in);
                                        System.out.println("Would you like to delete current user? y/n");
                                        // Enters what the user wants.
                                        char deleteUser = deleteUserInput.next().charAt(0);

                                        while (deleteUser != 'y' && deleteUser != 'n') {
                                            System.out.println("Would you like to delete current user? y/n");
                                            deleteUser = deleteUserInput.next().charAt(0);
                                        }

                                        if (deleteUser == 'y') {
                                            toRemoveDonator.add(donator);
                                            System.out.println("Donator successfully deleted.");
                                        }
                                    }
                                }
                                donators.removeAll(toRemoveDonator);

                                Scanner deleteAllBeneficiariesListsInput = new Scanner(System.in);
                                System.out.println("Would you like to delete all received lists of all users? y/n");
                                // Enters what the user wants.
                                char deleteAllBeneficiariesLists = deleteAllBeneficiariesListsInput.next().charAt(0);

                                while (deleteAllBeneficiariesLists != 'y' && deleteAllBeneficiariesLists != 'n') {
                                    System.out.println("Would you like to delete all received lists of all users? y/n");
                                    deleteAllBeneficiariesLists = deleteAllBeneficiariesListsInput.next().charAt(0);
                                }

                                if (deleteAllBeneficiariesLists == 'y') {
                                    for (var beneficiary : beneficiaries) {
                                        for (var beneficiaryReceivedLists : beneficiary.getReceivedList()) {
                                            beneficiaryReceivedLists.getRdEntities().clear();
                                            System.out.println("You deleted all received lists of all users");
                                        }
                                    }
                                }
                                break;
                            case "3":
                                System.out.println("Go back...");
                                wantToBack = false;
                                break;

                            case "4":
                                System.out.println("Logging out...");
                                wantToBack = true;
                                wantToLogout = false;
                                break;

                            case "5":
                                System.out.println("Exiting...");
                                return;
                        }
                    }while (!wantToBack);
                }

                //endregion

            }

            //endregion

        }while (!wantToLogout);

        //endregion
    }
}
