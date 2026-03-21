import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    public static void customerinfoshort(ArrayList<Customers> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getInfoShort());
        }
    }

    public static void customerinfoall(ArrayList<Customers> list){
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getInfoAll());
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
                return;
            }
            if (auswahlsuche == 0){
                break;
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
                            System.out.println(Service.outputofcustomerwithsamestartingletters(customeridinput, Storage.customersortedbycategories.get("customerid")));
                            break;
                        }
                        if (columnsuche == 2) {

                            System.out.println("Please insert what you want to search: ");
                            String firstnameinput = scanner.next();
                            customerinfoshort(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("first_name"), firstnameinput));
                            return;
                        }
                        if (columnsuche == 3) {

                            System.out.println("Please insert what you want to search");
                            String lastnameinput = scanner.next();
                            //System.out.println(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("last_name"), lastnameinput));
                            customerinfoshort(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("last_name"), lastnameinput));
                            return;
                        }
                        if (columnsuche == 4) {

                            System.out.println("Please insert what you want to search");
                            String companyinput = scanner.next();
                            customerinfoall(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("company"), companyinput));
                            return;
                        }
                        if (columnsuche == 5) {

                            System.out.println("Please insert what you want to search");
                            String addressinput = scanner.next();
                            customerinfoall(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("address"), addressinput));
                            return;
                        }
                        if (columnsuche == 6) {

                            System.out.println("Please insert what you want to search");
                            String postalcodeinput = scanner.next();
                            customerinfoall(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("postalcode"), postalcodeinput));
                            return;
                        }
                        if (columnsuche == 7) {

                            System.out.println("Please insert what you want to search");
                            String cityinput = scanner.next();
                            customerinfoall(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("city"), cityinput));
                            return;
                        }
                        if (columnsuche == 8) {

                            System.out.println("Please insert what you want to search");
                            String countryinput = scanner.next();
                            customerinfoall(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("country"), countryinput));
                            return;
                        }
                        if (columnsuche == 9) {

                            System.out.println("Please insert what you want to search");
                            String stateinput = scanner.next();
                            customerinfoall(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("state"), stateinput));
                            return;
                        }
                        if (columnsuche == 10) {

                            System.out.println("Please insert what you want to search");
                            String phoneinput = scanner.next();
                            customerinfoall(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("phone"), phoneinput));
                            return;
                        }
                        if (columnsuche == 11) {

                            System.out.println("Please insert what you want to search");
                            String faxinput = scanner.next();
                            customerinfoall(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("fax"), faxinput));
                            return;
                        }
                        if (columnsuche == 12) {

                            System.out.println("Please insert what you want to search");
                            String supportrepidinput = scanner.next();
                            customerinfoall(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("supportrepid"), supportrepidinput));
                            return;
                        }
                        if (columnsuche == 13) {

                            System.out.println("Please insert what you want to search");
                            String billinput = scanner.next();
                            customerinfoall(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("bill"), billinput));
                            return;
                        }

                    }
                }
            }
            if (auswahlsuche == 3) {

                customerinfoall(Service.valuesearchbycontainingsubstring(Storage.customersortedbycategories.get("customerid"), ""));

            }
        }
    }
}
