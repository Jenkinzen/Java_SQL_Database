import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class UI {

    public static ArrayList<Customers> listshortcut(String listname, String scannerinput, BiFunction<HashMap<String, ArrayList<Customers>>, String, ArrayList<Customers>> output) {
        return output.apply(Storage.customersortedbycategories.get(listname), scannerinput);
    }

    public static void customerinfoshort(ArrayList<Customers> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getInfoShort());
        }
    }

    public static void customerinfoall(ArrayList<Customers> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getInfoAll());
        }
    }

    public static String getsoughtattribute(ArrayList<Customers> list, Function<Customers, String> getter) {

            return getter.apply(list.get(0));

    }


    public static void printsoughtattributenoid(ArrayList<Customers> list, Function<Customers, String> getter) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(getter.apply(list.get(i)));
        }
    }

    public static void multiattributeprint(String numberofchosencolumns,ArrayList<Customers> inputlist){
        for(int i = 0; i < inputlist.size();i++){
            inputlist.get(i).getInfoDynamical(numberofchosencolumns,inputlist);

            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX CUSTOMER #" + ((i)+1) + " XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            if (numberofchosencolumns.contains("1")) {
                System.out.println("\nCustomer ID: " + getsoughtattribute(inputlist,Customers::getId));
            }

            if (numberofchosencolumns.contains("2")) {
                System.out.println("First Name: " + getsoughtattribute(inputlist,Customers::getFirstName));
            }

            if (numberofchosencolumns.contains("3")) {
                System.out.println("Last Name: " + getsoughtattribute(inputlist,Customers::getLastName));
            }

            if (numberofchosencolumns.contains("4")) {
                System.out.println("Address: " + getsoughtattribute(inputlist,Customers::getAddress));
            }

            if (numberofchosencolumns.contains("5")) {
                System.out.println("City: " + getsoughtattribute(inputlist,Customers::getCity));
            }

            if (numberofchosencolumns.contains("6")) {
                System.out.println("State: " + getsoughtattribute(inputlist,Customers::getState));
            }

            if (numberofchosencolumns.contains("7")) {
                System.out.println("Country: " + getsoughtattribute(inputlist,Customers::getCountry));
            }

            if (numberofchosencolumns.contains("8")) {
                System.out.println("Postal Code: " + getsoughtattribute(inputlist,Customers::getPostalcode));
            }

            if (numberofchosencolumns.contains("9")) {
                System.out.println("Phone: " + getsoughtattribute(inputlist,Customers::getPhone));
            }

            if (numberofchosencolumns.contains("10")) {
                System.out.println("Fax: " + getsoughtattribute(inputlist,Customers::getFax));
            }

            if (numberofchosencolumns.contains("11")) {
                System.out.println("Email: " + getsoughtattribute(inputlist,Customers::getEmail));
            }

            if (numberofchosencolumns.contains("12")) {
                System.out.println("Support Rep ID: " + getsoughtattribute(inputlist,Customers::getSupportrepid));
            }

            if (numberofchosencolumns.contains("13")) {
                System.out.println("Bill: " + getsoughtattribute(inputlist,Customers::BillAsString)+ "\n");
            }
        }
    }

    public static void chooseinfooutput(ArrayList<Customers> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What infos do you want to have displayed?\n1-all\n2-short\n3-select single columns\nchoice: ");
        int outputmenu = scanner.nextInt();
        if (outputmenu == 1) {
            customerinfoall(list);
        }

        if (outputmenu == 2) {
            customerinfoshort(list);
        }

        if (outputmenu == 3)
        {
            System.out.println("What columns do you want to have displayed,please seperate the numbers with a comma.\n\n1-Customer ID | 2-first name | 3-last name\n4-address | 5-city | 6-state" +
                    "\n7-country | 8-postalcode | 9-phone | 10-fax \n11-email | 12-support rep id | 13-bill | \n         0-previous menu");

            String columnnumbers = scanner.next();


            for (int i = 0; i < list.size(); i++)
            {
                System.out.println(list.get(i).getInfoDynamical(columnnumbers, list));
                System.out.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
                multiattributeprint(columnnumbers,list);
                System.out.println("LINE IN THE GETINFODYNAMICAL OUTPUT LOOP");
            }
            System.out.println("GNAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHHHHHHHHH");
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
                ArrayList<Customers> outputid = listshortcut("customerid", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------CUSTOMER ID------------------------------------------");
                printsoughtattributenoid(outputid, Customers::getId);


                ArrayList<Customers> outputfirstname = listshortcut("first_name", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------FIRST NAME------------------------------------------");
                getsoughtattribute(outputfirstname, Customers::getFirstName);

                ArrayList<Customers> outputlastname = listshortcut("last_name", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------LAST NAME------------------------------------------");
                getsoughtattribute(outputlastname, Customers::getFirstName);

                ArrayList<Customers> outputcompany = listshortcut("company", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------COMPANY------------------------------------------");
                getsoughtattribute(outputcompany, Customers::getCompany);

                ArrayList<Customers> outputaddress = listshortcut("address", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------ADDRESS------------------------------------------");
                getsoughtattribute(outputaddress, Customers::getAddress);

                ArrayList<Customers> outputpostalcode = listshortcut("postalcode", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------POSTAL CODE------------------------------------------");
                getsoughtattribute(outputpostalcode, Customers::getPostalcode);


                ArrayList<Customers> outputcity = listshortcut("city", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------CITY------------------------------------------");
                getsoughtattribute(outputcity, Customers::getCity);


                ArrayList<Customers> outputcountry = listshortcut("country", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------COUNTRY------------------------------------------");
                getsoughtattribute(outputcountry, Customers::getCountry);


                ArrayList<Customers> outputstate = listshortcut("state", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------STATE------------------------------------------");
                getsoughtattribute(outputstate, Customers::getAddress);


                ArrayList<Customers> outputphone = listshortcut("phone", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------PHONE------------------------------------------");
                getsoughtattribute(outputphone, Customers::getPhone);


                ArrayList<Customers> outputfax = listshortcut("fax", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------FAX------------------------------------------");
                getsoughtattribute(outputfax, Customers::getFax);


                ArrayList<Customers> outputsupportrepid = listshortcut("supportrepid", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------SUPPORT REP ID------------------------------------------");
                getsoughtattribute(outputsupportrepid, Customers::getSupportrepid);


                ArrayList<Customers> outputbill = listshortcut("bill", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------BILL------------------------------------------");
                getsoughtattribute(outputbill, Customers::BillAsString);
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
                            listshortcut("customerid", customeridinput, Service::outputofcustomerwithsamestartingletters);
                            break;
                        }
                        if (columnsuche == 2) {

                            System.out.println("Please insert what you want to search: ");
                            String firstnameinput = scanner.next();
                            chooseinfooutput(listshortcut("first_name", firstnameinput, Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 3) {

                            System.out.println("Please insert what you want to search");
                            String lastnameinput = scanner.next();
                            //System.out.println(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("last_name"), lastnameinput));
                            chooseinfooutput(listshortcut("last_name", lastnameinput, Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 4) {

                            System.out.println("Please insert what you want to search");
                            String companyinput = scanner.next();
                            chooseinfooutput(listshortcut("company", companyinput, Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 5) {

                            System.out.println("Please insert what you want to search");
                            String addressinput = scanner.next();
                            chooseinfooutput(listshortcut("address", addressinput, Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 6) {

                            System.out.println("Please insert what you want to search");
                            String postalcodeinput = scanner.next();
                            chooseinfooutput(listshortcut("postalcode", postalcodeinput, Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 7) {

                            System.out.println("Please insert what you want to search");
                            String cityinput = scanner.next();
                            customerinfoshort(listshortcut("city", cityinput, Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 8) {

                            System.out.println("Please insert what you want to search");
                            String countryinput = scanner.next();
                            customerinfoshort(listshortcut("country", countryinput, Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 9) {

                            System.out.println("Please insert what you want to search");
                            String stateinput = scanner.next();
                            customerinfoshort(listshortcut("state", stateinput, Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 10) {

                            System.out.println("Please insert what you want to search");
                            String phoneinput = scanner.next();
                            customerinfoshort(listshortcut("phone", phoneinput, Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 11) {

                            System.out.println("Please insert what you want to search");
                            String faxinput = scanner.next();
                            customerinfoshort(listshortcut("fax", faxinput, Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 12) {

                            System.out.println("Please insert what you want to search");
                            String supportrepidinput = scanner.next();
                            customerinfoshort(listshortcut("supportrepid", supportrepidinput, Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 13) {

                            System.out.println("Please insert what you want to search");
                            String billinput = scanner.next();
                            customerinfoshort(listshortcut("bill", billinput, Service::valuesearchbycontainingsubstring));
                            return;
                        }

                    }
                }
            }

            if (auswahlsuche == 3) {

                customerinfoshort(listshortcut("customerid", "", Service::valuesearchbycontainingsubstring));

            }

            if (auswahlsuche == 0) {
                break;
            }
        }
    }
}
