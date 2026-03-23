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

    public static void printsoughtattribute(ArrayList<Customers> list, Function<Customers, String> getter) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(getter.apply(list.get(i)));
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
        if (outputmenu == 3) {
            return;
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
                printsoughtattribute(outputid, Customers::getId);

                ArrayList<Customers> outputfirstname = listshortcut("first_name", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------FIRST NAME------------------------------------------");
                printsoughtattribute(outputfirstname, Customers::getFirstName);

                ArrayList<Customers> outputlastname = listshortcut("last_name", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------LAST NAME------------------------------------------");
                printsoughtattribute(outputlastname, Customers::getFirstName);

                ArrayList<Customers> outputcompany = listshortcut("company", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------COMPANY------------------------------------------");
                printsoughtattribute(outputcompany, Customers::getCompany);

                ArrayList<Customers> outputaddress = listshortcut("address", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------ADDRESS------------------------------------------");
                printsoughtattribute(outputaddress, Customers::getAddress);

                ArrayList<Customers> outputpostalcode = listshortcut("postalcode", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------POSTAL CODE------------------------------------------");
                printsoughtattribute(outputpostalcode, Customers::getPostalcode);


                ArrayList<Customers> outputcity = listshortcut("city", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------CITY------------------------------------------");
                printsoughtattribute(outputcity, Customers::getCity);


                ArrayList<Customers> outputcountry = listshortcut("country", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------COUNTRY------------------------------------------");
                printsoughtattribute(outputcountry, Customers::getCountry);


                ArrayList<Customers> outputstate = listshortcut("state", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------STATE------------------------------------------");
                printsoughtattribute(outputstate, Customers::getAddress);


                ArrayList<Customers> outputphone = listshortcut("phone", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------PHONE------------------------------------------");
                printsoughtattribute(outputphone, Customers::getPhone);


                ArrayList<Customers> outputfax = listshortcut("fax", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------FAX------------------------------------------");
                printsoughtattribute(outputfax, Customers::getFax);


                ArrayList<Customers> outputsupportrepid = listshortcut("supportrepid", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------SUPPORT REP ID------------------------------------------");
                printsoughtattribute(outputsupportrepid, Customers::getSupportrepid);


                ArrayList<Customers> outputbill = listshortcut("bill", searcheverything, Service::valuesearchbycontainingsubstring);
                System.out.println("----------------------------------------BILL------------------------------------------");
                printsoughtattribute(outputbill, Customers::BillAsString);


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
}
