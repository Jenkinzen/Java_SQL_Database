import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class UI {

    ///OUTPUTFUNCTIONS//////////////////////////////////////////////////////////////////////////////////////////////////
    public static void customerInfoShort(ArrayList<Customers> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getInfoShort());
        }
    }

    public static void customerInfoAll(ArrayList<Customers> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getInfoAll());
        }
    }

    public static void printSoughtAttributeNoId(ArrayList<Customers> list, Function<Customers, String> getter) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(getter.apply(list.get(i)));
        }
    }

    public static void multiAttributePrint(String numberofchosencolumns,ArrayList<Customers> inputlist){
        for(int i = 0; i < inputlist.size();i++){
            inputlist.get(i).getInfoDynamical(numberofchosencolumns,inputlist);

            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX CUSTOMER #" + ((i)+1) + " XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            if (numberofchosencolumns.contains("1")) {
                System.out.println("\nCustomer ID: " + Service.getSoughtAttribute(inputlist,Customers::getId));
            }

            if (numberofchosencolumns.contains("2")) {
                System.out.println("First Name: " + Service.getSoughtAttribute(inputlist,Customers::getFirstName));
            }

            if (numberofchosencolumns.contains("3")) {
                System.out.println("Last Name: " + Service.getSoughtAttribute(inputlist,Customers::getLastName));
            }

            if (numberofchosencolumns.contains("4")) {
                System.out.println("Address: " + Service.getSoughtAttribute(inputlist,Customers::getAddress));
            }

            if (numberofchosencolumns.contains("5")) {
                System.out.println("City: " + Service.getSoughtAttribute(inputlist,Customers::getCity));
            }

            if (numberofchosencolumns.contains("6")) {
                System.out.println("State: " + Service.getSoughtAttribute(inputlist,Customers::getState));
            }

            if (numberofchosencolumns.contains("7")) {
                System.out.println("Country: " + Service.getSoughtAttribute(inputlist,Customers::getCountry));
            }

            if (numberofchosencolumns.contains("8")) {
                System.out.println("Postal Code: " + Service.getSoughtAttribute(inputlist,Customers::getPostalcode));
            }

            if (numberofchosencolumns.contains("9")) {
                System.out.println("Phone: " + Service.getSoughtAttribute(inputlist,Customers::getPhone));
            }

            if (numberofchosencolumns.contains("10")) {
                System.out.println("Fax: " + Service.getSoughtAttribute(inputlist,Customers::getFax));
            }

            if (numberofchosencolumns.contains("11")) {
                System.out.println("Email: " + Service.getSoughtAttribute(inputlist,Customers::getEmail));
            }

            if (numberofchosencolumns.contains("12")) {
                System.out.println("Support Rep ID: " + Service.getSoughtAttribute(inputlist,Customers::getSupportrepid));
            }

            if (numberofchosencolumns.contains("13")) {
                System.out.println("Bill: " + Service.getSoughtAttribute(inputlist,Customers::BillAsString)+ "\n");
            }
        }
    }

    public static ArrayList<Customers> outputOfCustomerWithSameStartingCharacters(HashMap<String, ArrayList<Customers>> list,String lastnameletter)
    {
        for(int i = 0; i < list.get(lastnameletter).toArray().length;i++) {
            ArrayList<Customers> listbyletters = list.get(lastnameletter);
            listbyletters.get(i);
            System.out.println(listbyletters.get(i).getInfoShort());
        }
        return null;
    }

    /// MENUFUNCTIONS///////////////////////////////////////////////////////////////////////////////////////////////////


    public static void infooutputmenu(ArrayList<Customers> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What infos do you want to have displayed?\n1-all\n2-short\n3-select single columns\nchoice: ");
        int outputmenu = scanner.nextInt();
        if (outputmenu == 1) {
            customerInfoAll(list);
        }

        if (outputmenu == 2) {
            customerInfoShort(list);
        }

        if (outputmenu == 3)
        {
            System.out.println("What columns do you want to have displayed,please seperate the numbers with a comma.\n\n1-Customer ID | 2-first name | 3-last name\n4-address | 5-city | 6-state" +
                    "\n7-country | 8-postalcode | 9-phone | 10-fax \n11-email | 12-support rep id | 13-bill | \n         0-previous menu");

            String columnnumbers = scanner.next();


            for (int i = 0; i < list.size(); i++)
            {
                multiAttributePrint(columnnumbers,list);
            }
        }

    }

    public static void mainmenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the main menu\nWhat do you want to do??\n1-Search Customer Database\n2-blabla\n3-blablabla\nInput: ");
            int auswahlmenu = scanner.nextInt();
            if (auswahlmenu == 1) {
                customermenu();
            }
            if (auswahlmenu == 2) {
                break;
            }
            if (auswahlmenu == 3) {
                break;
            }
        }

    }

    public static void customermenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to search?\n1-Search in the whole Customer Database\n2-Search in a certain column\n3-Get all Customer entries\n0-mainmenu \nInput: ");
            int auswahlsuche = scanner.nextInt();


            if (auswahlsuche == 1) {
                System.out.println("Insert your keyword: ");
                String searcheverything = scanner.next();
                ArrayList<Customers> outputid = Service.applyFunctionOnList("customerid", searcheverything, Service::valueSearchByContainingSubString);
                System.out.println("----------------------------------------CUSTOMER ID------------------------------------------");
                printSoughtAttributeNoId(outputid, Customers::getId);


                ArrayList<Customers> outputfirstname = Service.applyFunctionOnList("first_name", searcheverything, Service::valueSearchByContainingSubString);
                System.out.println("----------------------------------------FIRST NAME------------------------------------------");
                Service.getSoughtAttribute(outputfirstname, Customers::getFirstName);

                ArrayList<Customers> outputlastname = Service.applyFunctionOnList("last_name", searcheverything, Service::valueSearchByContainingSubString);
                System.out.println("----------------------------------------LAST NAME------------------------------------------");
                Service.getSoughtAttribute(outputlastname, Customers::getFirstName);

                ArrayList<Customers> outputcompany = Service.applyFunctionOnList("company", searcheverything, Service::valueSearchByContainingSubString);
                System.out.println("----------------------------------------COMPANY------------------------------------------");
                Service.getSoughtAttribute(outputcompany, Customers::getCompany);

                ArrayList<Customers> outputaddress = Service.applyFunctionOnList("address", searcheverything, Service::valueSearchByContainingSubString);
                System.out.println("----------------------------------------ADDRESS------------------------------------------");
                Service.getSoughtAttribute(outputaddress, Customers::getAddress);

                ArrayList<Customers> outputpostalcode = Service.applyFunctionOnList("postalcode", searcheverything, Service::valueSearchByContainingSubString);
                System.out.println("----------------------------------------POSTAL CODE------------------------------------------");
                Service.getSoughtAttribute(outputpostalcode, Customers::getPostalcode);


                ArrayList<Customers> outputcity = Service.applyFunctionOnList("city", searcheverything, Service::valueSearchByContainingSubString);
                System.out.println("----------------------------------------CITY------------------------------------------");
                Service.getSoughtAttribute(outputcity, Customers::getCity);


                ArrayList<Customers> outputcountry = Service.applyFunctionOnList("country", searcheverything, Service::valueSearchByContainingSubString);
                System.out.println("----------------------------------------COUNTRY------------------------------------------");
                Service.getSoughtAttribute(outputcountry, Customers::getCountry);


                ArrayList<Customers> outputstate = Service.applyFunctionOnList("state", searcheverything, Service::valueSearchByContainingSubString);
                System.out.println("----------------------------------------STATE------------------------------------------");
                Service.getSoughtAttribute(outputstate, Customers::getAddress);


                ArrayList<Customers> outputphone = Service.applyFunctionOnList("phone", searcheverything, Service::valueSearchByContainingSubString);
                System.out.println("----------------------------------------PHONE------------------------------------------");
                Service.getSoughtAttribute(outputphone, Customers::getPhone);


                ArrayList<Customers> outputfax = Service.applyFunctionOnList("fax", searcheverything, Service::valueSearchByContainingSubString);
                System.out.println("----------------------------------------FAX------------------------------------------");
                Service.getSoughtAttribute(outputfax, Customers::getFax);


                ArrayList<Customers> outputsupportrepid = Service.applyFunctionOnList("supportrepid", searcheverything, Service::valueSearchByContainingSubString);
                System.out.println("----------------------------------------SUPPORT REP ID------------------------------------------");
                Service.getSoughtAttribute(outputsupportrepid, Customers::getSupportrepid);


                ArrayList<Customers> outputbill = Service.applyFunctionOnList("bill", searcheverything, Service::valueSearchByContainingSubString);
                System.out.println("----------------------------------------BILL------------------------------------------");
                Service.getSoughtAttribute(outputbill, Customers::BillAsString);
            }

            if (auswahlsuche == 2) {
                while (true) {
                    System.out.println("What column do you want to search in?\n\n1-Customer ID | 2-first name | 3-last name\n4-company | 5-address | 6-postal code" +
                            "\n7-city | 8-country | 9-state | 10-phone \n11-fax | 12-support rep id | 13-bill | \n         0-previous menu");


                    int columnsuche = scanner.nextInt();

                    if (columnsuche == 0) {
                        break;
                    }
                    while (true) {
                        if (columnsuche == 1) {

                            System.out.println("Please insert what you want to search for: ");
                            String customeridinput = scanner.next();
                            Service.applyFunctionOnList("customerid", customeridinput,UI::outputOfCustomerWithSameStartingCharacters);
                            break;
                        }
                        if (columnsuche == 2) {

                            System.out.println("Please insert what you want to search: ");
                            String firstnameinput = scanner.next();
                            infooutputmenu(Service.applyFunctionOnList("first_name", firstnameinput, Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 3) {

                            System.out.println("Please insert what you want to search");
                            String lastnameinput = scanner.next();
                            //System.out.println(Service.valueSearchByContainingSubString(Storage.customersortedbycategories.get("last_name"), lastnameinput));
                            infooutputmenu(Service.applyFunctionOnList("last_name", lastnameinput, Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 4) {

                            System.out.println("Please insert what you want to search");
                            String companyinput = scanner.next();
                            infooutputmenu(Service.applyFunctionOnList("company", companyinput, Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 5) {

                            System.out.println("Please insert what you want to search");
                            String addressinput = scanner.next();
                            infooutputmenu(Service.applyFunctionOnList("address", addressinput, Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 6) {

                            System.out.println("Please insert what you want to search");
                            String postalcodeinput = scanner.next();
                            infooutputmenu(Service.applyFunctionOnList("postalcode", postalcodeinput, Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 7) {

                            System.out.println("Please insert what you want to search");
                            String cityinput = scanner.next();
                            customerInfoShort(Service.applyFunctionOnList("city", cityinput, Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 8) {

                            System.out.println("Please insert what you want to search");
                            String countryinput = scanner.next();
                            customerInfoShort(Service.applyFunctionOnList("country", countryinput, Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 9) {

                            System.out.println("Please insert what you want to search");
                            String stateinput = scanner.next();
                            customerInfoShort(Service.applyFunctionOnList("state", stateinput, Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 10) {

                            System.out.println("Please insert what you want to search");
                            String phoneinput = scanner.next();
                            customerInfoShort(Service.applyFunctionOnList("phone", phoneinput, Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 11) {

                            System.out.println("Please insert what you want to search");
                            String faxinput = scanner.next();
                            customerInfoShort(Service.applyFunctionOnList("fax", faxinput, Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 12) {

                            System.out.println("Please insert what you want to search");
                            String supportrepidinput = scanner.next();
                            customerInfoShort(Service.applyFunctionOnList("supportrepid", supportrepidinput, Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 13) {

                            System.out.println("Please insert what you want to search");
                            String billinput = scanner.next();
                            customerInfoShort(Service.applyFunctionOnList("bill", billinput, Service::valueSearchByContainingSubString));
                            return;
                        }

                    }
                }
            }

            if (auswahlsuche == 3) {

                customerInfoAll(Service.applyFunctionOnList("customerid", "", Service::valueSearchByContainingSubString));

            }

            if (auswahlsuche == 0) {
                break;
            }
        }
    }
}
