package UI;


import Customers.Customers;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;





public class UI {

    /// DATAS///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static Map<String,Function<Customers,String>> AttributeNameAndGetterFunktionMap = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("CUSTOMER ID", (Function<Customers, String>) (c -> c.getId())),     // Lambda Funktionen, klappt anders nich
            Map.entry("FIRST NAME",(Function<Customers, String>) (c -> c.getFirstName())),
            Map.entry("LAST NAME",(Function<Customers, String>) (c -> c.getLastName())),
             Map.entry("ADDRESS",(Function<Customers, String>) (c -> c.getAddress())),
             Map.entry("CITY",(Function<Customers, String>) (c -> c.getCity())),
             Map.entry("COUNTRY",(Function<Customers, String>) (c -> c.getCountry())),
             Map.entry("COMPANY",(Function<Customers, String>) (c -> c.getCompany())),
             Map.entry("STATE",(Function<Customers, String>) (c -> c.getState())),
             Map.entry("PHONE",(Function<Customers, String>) (c -> c.getPhone())),
             Map.entry("POSTAL CODE",(Function<Customers, String>) (c -> c.getPostalcode())),
             Map.entry("FAX",(Function<Customers, String>) (c -> c.getFax())),
             Map.entry("EMAIL",(Function<Customers, String>) (c -> c.getEmail())),
             Map.entry("SUPPORT REP ID", (Function<Customers, String>) (c -> c.getSupportrepid())),
             Map.entry("FINAL BILL",(Function<Customers, String>) (c ->c.BillAsString()))));

    public static ArrayList<Map.Entry<String,Function<Customers,String>>> attributenameandgetterfunctionmap = new ArrayList<>(AttributeNameAndGetterFunktionMap.entrySet());




    /// OUTPUTFUNCTIONS/////////////////////////////////////////////////////////////////////////////////////////////////
    public static void customerInfoShort(ArrayList<Customers> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\n");
            System.out.println("CUSTOMER ID:" + list.get(i).getInfoDynamical(1));
            System.out.println("FULL NAME: "+list.get(i).getInfoDynamical(2)+" "+list.get(i).getInfoDynamical(3));
            System.out.println("ADDRESS: "+list.get(i).getInfoDynamical(4));
            System.out.println("CITY: "+list.get(i).getInfoDynamical(5));
            System.out.println("STATE: "+list.get(i).getInfoDynamical(6));
            System.out.println("COUNTRY: "+list.get(i).getInfoDynamical(7));
            System.out.println("\n");
        }

    }

    public static void customerInfoAll(ArrayList<Customers> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\n");
            System.out.println("CUSTOMER ID:" + list.get(i).getInfoDynamical(1));
            System.out.println("FULL NAME: "+list.get(i).getInfoDynamical(2)+list.get(i).getInfoDynamical(3));
            System.out.println("ADDRESS: "+list.get(i).getInfoDynamical(4));
            System.out.println("CITY: "+list.get(i).getInfoDynamical(5));
            System.out.println("STATE: "+list.get(i).getInfoDynamical(6));
            System.out.println("COUNTRY: "+list.get(i).getInfoDynamical(7));
            System.out.println("POSTAL CODE: "+list.get(i).getInfoDynamical(8));
            System.out.println("PHONE: "+list.get(i).getInfoDynamical(9));
            System.out.println("FAX: "+list.get(i).getInfoDynamical(10));
            System.out.println("EMAIL: "+list.get(i).getInfoDynamical(11));
            System.out.println("SUPPORT REP ID: "+list.get(i).getInfoDynamical(12));
            System.out.println("TOTAL BILL: "+list.get(i).getInfoDynamical(13));
            System.out.println("\n");
        }
    }

    public static void printSoughtAttributeNoId(ArrayList<Customers> list, Function<Customers, String> getter) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(getter.apply(list.get(i)));
        }
    }

    public static void multiAttributePrint(String numberofchosencolumns,ArrayList<Customers> inputlist){
        for(int i = 0; i < inputlist.size();i++){

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

    public static ArrayList<Customers> outputOfCustomerWithSameStartingCharacters(HashMap<String, ArrayList<Customers>> HashMap,String lastnameletter)
    {
        for(int i = 0; i < HashMap.get(lastnameletter).toArray().length;i++) {
            ArrayList<Customers> HashMapbyletters = HashMap.get(lastnameletter);
            HashMapbyletters.get(i);
            System.out.println("CUSTOMER ID:" + HashMap.get(i).get(i).getInfoDynamical(1));
            System.out.println("FULL NAME: "+HashMap.get(i).get(i).getInfoDynamical(2)+HashMap.get(i).get(i).getInfoDynamical(3));
            System.out.println("ADDRESS: "+HashMap.get(i).get(i).getInfoDynamical(4));
            System.out.println("CITY: "+HashMap.get(i).get(i).getInfoDynamical(5));
            System.out.println("STATE: "+HashMap.get(i).get(i).getInfoDynamical(6));
            System.out.println("COUNTRY: "+HashMap.get(i).get(i).getInfoDynamical(7));
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

            multiAttributePrint(columnnumbers,list);

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

    // FUNKTIONIERT ABER ICH NICHT RICHTIG / GIBT ALLE ATTRIBUTE DES CUSTOMERS AUS WO DER SUCHBEGRIFF IM VORNAMEN AUFTAUCHT(GLAUB ICH) ABER SUCHT NICHT IN ALLEN ATTRIBUTEN
    // NACH DEM SCHLAGWORT, liegt wahrscheinlich daran das variablen in der for-schleife zugeordnet werden statt davor, naja , arbeit für morgen oder so.
    public static void wholeCustomerFormatAndPrint(String scannerinput,String listname){
        for (int i = 0; i < attributenameandgetterfunctionmap.size();i++) {
            Map.Entry<String, Function<Customers, String>> actualKeyValuePair = attributenameandgetterfunctionmap.get(i);
            String actualkeyofpair = actualKeyValuePair.getKey();
            Function<Customers,String> actualvalueofpair = actualKeyValuePair.getValue();
            System.out.println("----------------------------------------" + actualkeyofpair + "------------------------------------------");
            ArrayList<Customers> outputlist= Service.Service.applyFunctionOnList(listname, scannerinput, Service.Service::valueSearchByContainingSubString);
            for (int i2 = 0; i2 < outputlist.size(); i2++) {
                System.out.printf("%-50s%5s%5s%n", Service.Service.getSoughtAttribute(outputlist.get(i2), actualvalueofpair), "Customer ID:", Service.Service.getSoughtAttribute(outputlist.get(i2), Customers::getId));
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
                    System.out.printf("%-50s%5s%5s%n",Service.Service.getSoughtAttribute(outputfirstname.get(i), Customers::getFirstName),"Customer ID:" , Service.Service.getSoughtAttribute(outputfirstname.get(i), Customers::getId));
                }                   //%-15s = 15 stellen von links(-) platz für name / 25s = nimmt 25 zeichen platz für customerID AB DEM PUNKT WO DIE 15 stellen des ersten Arguments aufhören(bzw genau ab stelle 15) /
                System.out.println("----------------------------------------TESTOFTHEFUNCTION------------------------------------------");
                wholeCustomerFormatAndPrint(searcheverything,"first_name");

                System.out.println("----------------------------------------ENDOFTHETESTOFFUNK------------------------------------------");

                System.out.println("----------------------------------------LAST NAME------------------------------------------");
                ArrayList<Customers> outputlastname = Service.Service.applyFunctionOnList("last_name", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputlastname.size(); i++) {
                    System.out.printf("%-50s%5s%5s%n",Service.Service.getSoughtAttribute(outputlastname.get(i), Customers::getLastName),"Customer ID:", Service.Service.getSoughtAttribute(outputlastname.get(i), Customers::getId));
                }
                System.out.println("----------------------------------------COMPANY------------------------------------------");
                ArrayList<Customers> outputcompany = Service.Service.applyFunctionOnList("company", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputcompany.size(); i++) {
                    System.out.printf("%-50s%5s%5s%n",Service.Service.getSoughtAttribute(outputcompany.get(i), Customers::getCompany),"Customer ID:" ,Service.Service.getSoughtAttribute(outputcompany.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------ADDRESS------------------------------------------");
                ArrayList<Customers> outputaddress = Service.Service.applyFunctionOnList("address", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputaddress.size(); i++) {
                    System.out.printf("%-50s%5s%5s%n",Service.Service.getSoughtAttribute(outputaddress.get(i), Customers::getAddress),"Customer ID:" , Service.Service.getSoughtAttribute(outputaddress.get(i), Customers::getId));
                }
                System.out.println("----------------------------------------POSTAL CODE------------------------------------------");
                ArrayList<Customers> outputpostalcode = Service.Service.applyFunctionOnList("postalcode", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputpostalcode.size(); i++) {
                    System.out.printf("%-50s%5s%5s%n",Service.Service.getSoughtAttribute(outputpostalcode.get(i), Customers::getPostalcode),"Customer ID:" , Service.Service.getSoughtAttribute(outputpostalcode.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------CITY------------------------------------------");
                ArrayList<Customers> outputcity = Service.Service.applyFunctionOnList("city", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputcity.size(); i++) {
                    System.out.printf("%-50s%5s%5s%n",Service.Service.getSoughtAttribute(outputcity.get(i), Customers::getCity),"Customer ID:", Service.Service.getSoughtAttribute(outputcity.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------COUNTRY------------------------------------------");
                ArrayList<Customers> outputcountry = Service.Service.applyFunctionOnList("country", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputcountry.size(); i++) {
                    System.out.printf("%-50s%5s%5s%n",Service.Service.getSoughtAttribute(outputcountry.get(i), Customers::getCountry),"Customer ID:" ,Service.Service.getSoughtAttribute(outputcountry.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------STATE------------------------------------------");
                ArrayList<Customers> outputstate = Service.Service.applyFunctionOnList("state", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputstate.size(); i++) {
                    System.out.printf("%-50s%5s%5s%n",Service.Service.getSoughtAttribute(outputstate.get(i), Customers::getState)+"           " + "Customer ID:" + Service.Service.getSoughtAttribute(outputaddress.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------PHONE------------------------------------------");
                ArrayList<Customers> outputphone = Service.Service.applyFunctionOnList("phone", searcheverything, Service.Service::valueSearchByContainingSubString);
                for (int i = 0; i < outputphone.size(); i++) {
                    System.out.printf("%-50s%5s%5s%n",Service.Service.getSoughtAttribute(outputphone.get(i), Customers::getPhone), "Customer ID:" , Service.Service.getSoughtAttribute(outputphone.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------FAX------------------------------------------");
                ArrayList<Customers> outputfax = Service.Service.applyFunctionOnList("fax", searcheverything, Service.Service::valueSearchByContainingSubString);
                for(int i = 0; i < outputfax.size();i++) {
                    System.out.printf("%-50s%5s%5s%n",Service.Service.getSoughtAttribute(outputfax.get(i), Customers::getFax),"Customer ID:   " , Service.Service.getSoughtAttribute(outputfax.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------SUPPORT REP ID------------------------------------------");
                ArrayList<Customers> outputsupportrepid = Service.Service.applyFunctionOnList("supportrepid", searcheverything, Service.Service::valueSearchByContainingSubString);
                for(int i = 0; i < outputsupportrepid.size();i++) {
                    System.out.printf("%-50s%5s%5s%n",Service.Service.getSoughtAttribute(outputsupportrepid.get(i), Customers::getSupportrepid),"Customer ID:" , Service.Service.getSoughtAttribute(outputsupportrepid.get(i), Customers::getId));
                }

                System.out.println("----------------------------------------BILL------------------------------------------");
                ArrayList<Customers> outputbill = Service.Service.applyFunctionOnList("bill", searcheverything, Service.Service::valueSearchByContainingSubString);
                for(int i = 0; i < outputbill.size();i++) {
                    System.out.printf("%-50s%5s%5s%n",Service.Service.getSoughtAttribute(outputbill.get(i), Customers::BillAsString),"Customer ID:" , Service.Service.getSoughtAttribute(outputbill.get(i), Customers::getId));
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
