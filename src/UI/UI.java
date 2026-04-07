package UI;


import Customers.Customers;
import Service.Service;
import Storage.Storage;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;





public class UI {

    /// DATAS///////////////////////////////////////////////////////////////////////////////////////////////////////////



    private static Map<String, Function<Customers, String>> AttributeNameAndGetterFunktionMap() {
        Map<String, Function<Customers, String>> map = new LinkedHashMap<>();

        map.put("CUSTOMER ID", Customers::getId);
        map.put("FIRST NAME", Customers::getFirstName);
        map.put("LAST NAME", Customers::getLastName);
        map.put("ADDRESS", Customers::getAddress);
        map.put("CITY", Customers::getCity);
        map.put("COUNTRY", Customers::getCountry);
        map.put("COMPANY", Customers::getCompany);
        map.put("STATE", Customers::getState);
        map.put("PHONE", Customers::getPhone);
        map.put("POSTAL CODE", Customers::getPostalcode);
        map.put("FAX", Customers::getFax);
        map.put("EMAIL", Customers::getEmail);
        map.put("SUPPORT REP ID", Customers::getSupportrepid);
        map.put("BILLS", Customers::BillAsString);

        return map;
    }
    public static ArrayList<String> ListNameList = new ArrayList<>(Arrays.asList
    ("customerid","first_name","last_name","address","city","country","company","state","phone","postalcode","fax","email","supportrepid","bill"));





    /// OUTPUTFUNCTIONS/////////////////////////////////////////////////////////////////////////////////////////////////

    public static void multiAttributePrint(String numberofchosencolumns,ArrayList<Customers> inputlist){
        for(int i = 0; i < inputlist.size();i++){

            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX CUSTOMER #" + ((i)+1) + " XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            if (numberofchosencolumns.contains("1")) {
                System.out.println("\nCustomer ID: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getId));
            }

            if (numberofchosencolumns.contains("2")) {
                System.out.println("First Name: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getFirstName));
            }

            if (numberofchosencolumns.contains("3")) {
                System.out.println("Last Name: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getLastName));
            }

            if (numberofchosencolumns.contains("4")) {
                System.out.println("Address: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getAddress));
            }

            if (numberofchosencolumns.contains("5")) {
                System.out.println("City: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getCity));
            }

            if (numberofchosencolumns.contains("6")) {
                System.out.println("State: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getState));
            }

            if (numberofchosencolumns.contains("7")) {
                System.out.println("Country: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getCountry));
            }

            if (numberofchosencolumns.contains("8")) {
                System.out.println("Postal Code: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getPostalcode));
            }

            if (numberofchosencolumns.contains("9")) {
                System.out.println("Phone: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getPhone));
            }

            if (numberofchosencolumns.contains("10")) {
                System.out.println("Fax: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getFax));
            }

            if (numberofchosencolumns.contains("11")) {
                System.out.println("Email: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getEmail));
            }

            if (numberofchosencolumns.contains("12")) {
                System.out.println("Support Rep ID: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getSupportrepid));
            }

            if (numberofchosencolumns.contains("13")) {
                System.out.println("Bill: " + Service.getSoughtAttribute(inputlist.get(i),Customers::BillAsString)+ "\n");
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

    public static void wholeCustomerFormatAndPrint(String scannerinput)
    {
        ArrayList <String> currentkeyofpairlist = new ArrayList<>();
        ArrayList<Function<Customers,String>> currentvalueofpairlist = new ArrayList<>() ;
        Set<Map.Entry<String, Function<Customers, String>>> allEntrySets = AttributeNameAndGetterFunktionMap().entrySet(); // Set -> nennt sich "View" es ist kein Datentyp sondern eine "Art auf die Map zu schauen".
        for(Map.Entry<String, Function<Customers, String>> keyloopvar : allEntrySets) {
            currentkeyofpairlist.add(keyloopvar.getKey());
            currentvalueofpairlist.add(keyloopvar.getValue());
        }
        for(int i = 0; i < ListNameList.size();i++)
        { // geht nacheinander alle listen durch -> customerid[0],firstname[1],lastname[2] etc.
            ArrayList<Customers> currentlist = Service.applyFunctionOnList(ListNameList.get(i), scannerinput, Service::valueSearchByContainingSubString);

            System.out.println("----------------------------------------" + currentkeyofpairlist.get(i) + "------------------------------------------");
            for(int i2 = 0; i2 < currentlist.size();i2++) {
                System.out.printf("%-50s%5s%5s%n", Service.getSoughtAttribute(currentlist.get(i2), currentvalueofpairlist.get(i)), "Customer ID:", Service.getSoughtAttribute(currentlist.get(i2), Customers::getId));
                //%-15s = 15 stellen von links(-) platz für name / 25s = nimmt 25 zeichen platz für customerID AB DEM PUNKT WO DIE 15 stellen des ersten Arguments aufhören(bzw genau ab stelle 15) /
            }
        }
    }

    public static void searchOneColumn(int columnnumber){

        Scanner scanner = new Scanner(System.in);
        System.out.println("\"Please insert what you want to search for: ");
        String theinput = scanner.next();
        //SUCHT NICHT IN DEN KEYS SONDERN VALUES , ALSO SUCHT QUASI IN ALLEN COLUMNS.
        infoOutPutMenu(Service.applyFunctionOnList(ListNameList.get(columnnumber+1), theinput, Service::valueSearchByContainingSubString));
    }

    /// MENUFUNCTIONS///////////////////////////////////////////////////////////////////////////////////////////////////


    public static void infoOutPutMenu(ArrayList<Customers> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What infos do you want to have displayed?\n1-all\n2-short\n3-select single columns\nchoice: ");
        int outputmenu = scanner.nextInt();
        if (outputmenu == 1) {
            multiAttributePrint("1,2,3,4,5,6,7,8,9,10,11,12,13",list);
        }

        if (outputmenu == 2) {
            multiAttributePrint("1,2,3,4,5,6",list);
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

    public static void customerMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to search?\n1-Search in the whole Customer Database\n2-Search in a certain column\n3-Get all Customer entries\n0-mainmenu \nInput: ");
            int auswahlsuche = scanner.nextInt();


            if (auswahlsuche == 1) {
                System.out.println("Insert your keyword: ");
                String searcheverything = scanner.next();
                wholeCustomerFormatAndPrint(searcheverything);
           }

            if (auswahlsuche == 2) {
                while (true) {
                    System.out.println("What column do you want to search in?\n\n1-Customer ID | 2-first name | 3-last name\n4-company | 5-address | 6-postal code" +
                            "\n7-city | 8-country | 9-state | 10-phone \n11-fax | 12-support rep id | 13-bill | \n         0-previous menu");


                    int columnsuche = scanner.nextInt();

                    if (columnsuche == 0) {
                        break;
                    } else
                    {
                        searchOneColumn(columnsuche);
                        }




                }
            }

            if (auswahlsuche == 3) {

                multiAttributePrint("1,2,3,4,5,6,7,8,9,10,11,12,13",Storage.all_customers);

            }

            if (auswahlsuche == 0) {
                break;
            }
        }
    }

}
