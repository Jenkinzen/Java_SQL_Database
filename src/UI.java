import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiFunction;

public class UI {

    public static ArrayList<Customers> listshortcut(String listname, String scannerinput, BiFunction<HashMap<String, ArrayList<Customers>>,String,ArrayList<Customers>> output){
        return output.apply(Storage.customersortedbycategories.get(listname), scannerinput);
    }

    public static void customerinfoshort(ArrayList<Customers> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getInfoShort());
        }
    }

    public static void customerinfoall(ArrayList<Customers> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getInfoAll());
        }
    }


    public static void chooseinfooutput(ArrayList<Customers> list){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What infos do you want to have displayed?\n1-all\n2-short\n3-select single columns\nchoice: ");
        int outputmenu = scanner.nextInt();
        if( outputmenu == 1){
            customerinfoall(list);
        }
        if ( outputmenu == 2){
            customerinfoshort(list);
        }
        if ( outputmenu == 3){
            return;
        }
    }

    public static void mainmenu(){
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

    public static void customermenu(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to search?\n1-Search in the whole Customer Database\n2-Search in a certain column\n3-Get all Customer entries\n0-mainmenu \nInput: ");
            int auswahlsuche = scanner.nextInt();
            if (auswahlsuche == 1) {
                return; // Jetzt hier versuchen eine Funktion und Methode zu finden wie alle columns gecheckt werden können.


            }

            if (auswahlsuche == 2) {
                while (true) {
                    System.out.println("What column do you want to search in?\n1-Customer ID\n2-first name\n3-last name\n4-company\n5-address\n6-postal code" +
                            "\n7-city\n8-country\n9-state\n10-phone\n11-fax\n12-support rep id\n13-bill\n0-previous menu");



                    int columnsuche = scanner.nextInt();

                    if (columnsuche == 0){
                        break;
                    }
                    while (true) {
                        if (columnsuche == 1) {

                            System.out.println("Please insert what you want to search for: ");
                            String customeridinput = scanner.next();
                            chooseinfooutput(listshortcut("customerid",customeridinput,Service::outputofcustomerwithsamestartingletters));
                            break;
                        }
                        if (columnsuche == 2) {

                            System.out.println("Please insert what you want to search: ");
                            String firstnameinput = scanner.next();
                            chooseinfooutput(listshortcut("first_name",firstnameinput,Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 3) {

                            System.out.println("Please insert what you want to search");
                            String lastnameinput = scanner.next();
                            //System.out.println(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("last_name"), lastnameinput));
                            chooseinfooutput(listshortcut("last_name",lastnameinput,Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 4) {

                            System.out.println("Please insert what you want to search");
                            String companyinput = scanner.next();
                            chooseinfooutput(listshortcut("company",companyinput,Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 5) {

                            System.out.println("Please insert what you want to search");
                            String addressinput = scanner.next();
                            chooseinfooutput(listshortcut("address",addressinput,Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 6) {

                            System.out.println("Please insert what you want to search");
                            String postalcodeinput = scanner.next();
                            chooseinfooutput(listshortcut("postalcode",postalcodeinput,Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 7) {

                            System.out.println("Please insert what you want to search");
                            String cityinput = scanner.next();
                            customerinfoshort(listshortcut("city",cityinput,Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 8) {

                            System.out.println("Please insert what you want to search");
                            String countryinput = scanner.next();
                            customerinfoshort(listshortcut("country",countryinput,Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 9) {

                            System.out.println("Please insert what you want to search");
                            String stateinput = scanner.next();
                            customerinfoshort(listshortcut("state",stateinput,Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 10) {

                            System.out.println("Please insert what you want to search");
                            String phoneinput = scanner.next();
                            customerinfoshort(listshortcut("phone",phoneinput,Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 11) {

                            System.out.println("Please insert what you want to search");
                            String faxinput = scanner.next();
                            customerinfoshort(listshortcut("fax",faxinput,Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 12) {

                            System.out.println("Please insert what you want to search");
                            String supportrepidinput = scanner.next();
                            customerinfoshort(listshortcut("supportrepid",supportrepidinput,Service::valuesearchbycontainingsubstring));
                            return;
                        }
                        if (columnsuche == 13) {

                            System.out.println("Please insert what you want to search");
                            String billinput = scanner.next();
                            customerinfoshort(listshortcut("bill",billinput,Service::valuesearchbycontainingsubstring));
                            return;
                        }

                    }
                }
            }

            if (auswahlsuche == 3) {

                customerinfoshort(listshortcut("customerid","",Service::valuesearchbycontainingsubstring));

            }

            if (auswahlsuche == 0){
                break;
            }
        }
    }
}
