package UI;


import Customers.Customers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
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
        for(int i = 0; i <= inputlist.size();i++){

            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX CUSTOMER #" + ((i)+1) + " XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            if (numberofchosencolumns.contains("1")) {
                System.out.println("\nCustomer ID: " + Service.Service.getSoughtAttribute(inputlist.get(i),Customers::getId));
            }

            if (numberofchosencolumns.contains("2")) {
                System.out.println("First Name: " + Service.Service.getSoughtAttribute(inputlist.get(i),Customers::getFirstName));
            }

            if (numberofchosencolumns.contains("3")) {
                System.out.println("Last Name: " + Service.Service.getSoughtAttribute(inputlist.get(i),Customers::getLastName));
            }

            if (numberofchosencolumns.contains("4")) {
                System.out.println("Address: " + Service.Service.getSoughtAttribute(inputlist.get(i),Customers::getAddress));
            }

            if (numberofchosencolumns.contains("5")) {
                System.out.println("City: " + Service.Service.getSoughtAttribute(inputlist.get(i),Customers::getCity));
            }

            if (numberofchosencolumns.contains("6")) {
                System.out.println("State: " + Service.Service.getSoughtAttribute(inputlist.get(i),Customers::getState));
            }

            if (numberofchosencolumns.contains("7")) {
                System.out.println("Country: " + Service.Service.getSoughtAttribute(inputlist.get(i),Customers::getCountry));
            }

            if (numberofchosencolumns.contains("8")) {
                System.out.println("Postal Code: " + Service.Service.getSoughtAttribute(inputlist.get(i),Customers::getPostalcode));
            }

            if (numberofchosencolumns.contains("9")) {
                System.out.println("Phone: " + Service.Service.getSoughtAttribute(inputlist.get(i),Customers::getPhone));
            }

            if (numberofchosencolumns.contains("10")) {
                System.out.println("Fax: " + Service.Service.getSoughtAttribute(inputlist.get(i),Customers::getFax));
            }

            if (numberofchosencolumns.contains("11")) {
                System.out.println("Email: " + Service.Service.getSoughtAttribute(inputlist.get(i),Customers::getEmail));
            }

            if (numberofchosencolumns.contains("12")) {
                System.out.println("Support Rep ID: " + Service.Service.getSoughtAttribute(inputlist.get(i),Customers::getSupportrepid));
            }

            if (numberofchosencolumns.contains("13")) {
                System.out.println("Bill: " + Service.Service.getSoughtAttribute(inputlist.get(i),Customers::BillAsString)+ "\n");
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


    public static void infoOutPutMenu(ArrayList<Customers> list) {
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

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the main menu\nWhat do you want to do??\n1-Search Customer Database\n2-blabla\n3-blablabla\nInput: ");
            int auswahlmenu = scanner.nextInt();
            if (auswahlmenu == 1) {
                customerMenu();
            }
            if (auswahlmenu == 2) {
                break;
            }
            if (auswahlmenu == 3) {
                break;
            }
        }

    }

    public static void customerMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to search?\n1-Search in the whole Customer Database\n2-Search in a certain column\n3-Get all Customer entries\n0-mainmenu \nInput: ");
            int auswahlsuche = scanner.nextInt();


            if (auswahlsuche == 1) {
                System.out.println("Insert your keyword: ");
                String searcheverything = scanner.next();

                System.out.println("----------------------------------------CUSTOMER ID------------------------------------------");
                ArrayList<Customers> outputid = Service.Service.applyFunctionOnList("customerid", searcheverything, Service.Service::valueSearchByContainingSubString);
                printSoughtAttributeNoId(outputid, Customers::getId);


                System.out.println("----------------------------------------FIRST NAME------------------------------------------");
                ArrayList<Customers> outputfirstname = Service.Service.applyFunctionOnList("first_name", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputfirstname.size(); i++) {
                    System.out.println(Service.Service.getSoughtAttribute(outputfirstname.get(i), Customers::getFirstName)+"           " + "Customer ID:   " + Service.Service.getSoughtAttribute(outputfirstname.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------LAST NAME------------------------------------------");
                ArrayList<Customers> outputlastname = Service.Service.applyFunctionOnList("last_name", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputlastname.size(); i++) {
                    System.out.println(Service.Service.getSoughtAttribute(outputlastname.get(i), Customers::getLastName)+"           " + "Customer ID:   " + Service.Service.getSoughtAttribute(outputlastname.get(i), Customers::getId));
                }
                System.out.println("----------------------------------------COMPANY------------------------------------------");
                ArrayList<Customers> outputcompany = Service.Service.applyFunctionOnList("company", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputcompany.size(); i++) {
                    System.out.println(Service.Service.getSoughtAttribute(outputcompany.get(i), Customers::getCompany)+"           " + "Customer ID:   " + Service.Service.getSoughtAttribute(outputcompany.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------ADDRESS------------------------------------------");
                ArrayList<Customers> outputaddress = Service.Service.applyFunctionOnList("address", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputaddress.size(); i++) {
                    System.out.println(Service.Service.getSoughtAttribute(outputaddress.get(i), Customers::getAddress)+"           " + "Customer ID:   " + Service.Service.getSoughtAttribute(outputaddress.get(i), Customers::getId));
                }
                System.out.println("----------------------------------------POSTAL CODE------------------------------------------");
                ArrayList<Customers> outputpostalcode = Service.Service.applyFunctionOnList("postalcode", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputpostalcode.size(); i++) {
                    System.out.println(Service.Service.getSoughtAttribute(outputpostalcode.get(i), Customers::getPostalcode)+"           " + "Customer ID:   " + Service.Service.getSoughtAttribute(outputpostalcode.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------CITY------------------------------------------");
                ArrayList<Customers> outputcity = Service.Service.applyFunctionOnList("city", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputcity.size(); i++) {
                    System.out.println(Service.Service.getSoughtAttribute(outputcity.get(i), Customers::getCity)+"           " + "Customer ID:   " + Service.Service.getSoughtAttribute(outputcity.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------COUNTRY------------------------------------------");
                ArrayList<Customers> outputcountry = Service.Service.applyFunctionOnList("country", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputcountry.size(); i++) {
                    System.out.println(Service.Service.getSoughtAttribute(outputcountry.get(i), Customers::getCountry)+"           " + "Customer ID:   " + Service.Service.getSoughtAttribute(outputcountry.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------STATE------------------------------------------");
                ArrayList<Customers> outputstate = Service.Service.applyFunctionOnList("state", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputstate.size(); i++) {
                    System.out.println(Service.Service.getSoughtAttribute(outputstate.get(i), Customers::getAddress)+"           " + "Customer ID:   " + Service.Service.getSoughtAttribute(outputaddress.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------PHONE------------------------------------------");
                ArrayList<Customers> outputphone = Service.Service.applyFunctionOnList("phone", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputphone.size(); i++) {
                    System.out.println(Service.Service.getSoughtAttribute(outputphone.get(i), Customers::getPhone)+"           " + "Customer ID:   " + Service.Service.getSoughtAttribute(outputphone.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------FAX------------------------------------------");
                ArrayList<Customers> outputfax = Service.Service.applyFunctionOnList("fax", searcheverything, Service.Service::valueSearchByContainingSubString);
                for(int i = 0; i < outputstate.size();i++) {
                    System.out.println(Service.Service.getSoughtAttribute(outputfax.get(i), Customers::getFax)+"           " + "Customer ID:   " + Service.Service.getSoughtAttribute(outputfax.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------SUPPORT REP ID------------------------------------------");
                ArrayList<Customers> outputsupportrepid = Service.Service.applyFunctionOnList("supportrepid", searcheverything, Service.Service::valueSearchByContainingSubString);
                for(int i = 0; i < outputstate.size();i++) {
                    System.out.println(Service.Service.getSoughtAttribute(outputsupportrepid.get(i), Customers::getSupportrepid)+"           " + "Customer ID:   " + Service.Service.getSoughtAttribute(outputsupportrepid.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------BILL------------------------------------------");
                ArrayList<Customers> outputbill = Service.Service.applyFunctionOnList("bill", searcheverything, Service.Service::valueSearchByContainingSubString);
                for(int i = 0; i < outputstate.size();i++) {
                    System.out.println(Service.Service.getSoughtAttribute(outputbill.get(i), Customers::BillAsString)+"           " + "Customer ID:   " + Service.Service.getSoughtAttribute(outputbill.get(i), Customers::getId));
                }
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
                            Service.Service.applyFunctionOnList("customerid", customeridinput,UI::outputOfCustomerWithSameStartingCharacters);
                            break;
                        }
                        if (columnsuche == 2) {

                            System.out.println("Please insert what you want to search: ");
                            String firstnameinput = scanner.next();
                            infoOutPutMenu(Service.Service.applyFunctionOnList("first_name", firstnameinput, Service.Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 3) {

                            System.out.println("Please insert what you want to search");
                            String lastnameinput = scanner.next();
                            //System.out.println(Service.Service.valueSearchByContainingSubString(Storage.customersortedbycategories.get("last_name"), lastnameinput));
                            infoOutPutMenu(Service.Service.applyFunctionOnList("last_name", lastnameinput, Service.Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 4) {

                            System.out.println("Please insert what you want to search");
                            String companyinput = scanner.next();
                            infoOutPutMenu(Service.Service.applyFunctionOnList("company", companyinput, Service.Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 5) {

                            System.out.println("Please insert what you want to search");
                            String addressinput = scanner.next();
                            infoOutPutMenu(Service.Service.applyFunctionOnList("address", addressinput, Service.Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 6) {

                            System.out.println("Please insert what you want to search");
                            String postalcodeinput = scanner.next();
                            infoOutPutMenu(Service.Service.applyFunctionOnList("postalcode", postalcodeinput, Service.Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 7) {

                            System.out.println("Please insert what you want to search");
                            String cityinput = scanner.next();
                            customerInfoShort(Service.Service.applyFunctionOnList("city", cityinput, Service.Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 8) {

                            System.out.println("Please insert what you want to search");
                            String countryinput = scanner.next();
                            customerInfoShort(Service.Service.applyFunctionOnList("country", countryinput, Service.Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 9) {

                            System.out.println("Please insert what you want to search");
                            String stateinput = scanner.next();
                            customerInfoShort(Service.Service.applyFunctionOnList("state", stateinput, Service.Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 10) {

                            System.out.println("Please insert what you want to search");
                            String phoneinput = scanner.next();
                            customerInfoShort(Service.Service.applyFunctionOnList("phone", phoneinput, Service.Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 11) {

                            System.out.println("Please insert what you want to search");
                            String faxinput = scanner.next();
                            customerInfoShort(Service.Service.applyFunctionOnList("fax", faxinput, Service.Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 12) {

                            System.out.println("Please insert what you want to search");
                            String supportrepidinput = scanner.next();
                            customerInfoShort(Service.Service.applyFunctionOnList("supportrepid", supportrepidinput, Service.Service::valueSearchByContainingSubString));
                            return;
                        }
                        if (columnsuche == 13) {

                            System.out.println("Please insert what you want to search");
                            String billinput = scanner.next();
                            customerInfoShort(Service.Service.applyFunctionOnList("bill", billinput, Service.Service::valueSearchByContainingSubString));
                            return;
                        }

                    }
                }
            }

            if (auswahlsuche == 3) {

                customerInfoAll(Service.Service.applyFunctionOnList("customerid", "", Service.Service::valueSearchByContainingSubString));

            }

            if (auswahlsuche == 0) {
                break;
            }
        }
    }
}
