package UI;


import Customers.Customers;
import Service.Service;
import Storage.Storage;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;





public class UI {

    /// OUTPUTFUNCTIONS/////////////////////////////////////////////////////////////////////////////////////////////////
    public static void multiAttributePrintSortedByCustomer(String numbersofchosencolumns,ArrayList<Customers> inputlist){

        ArrayList<Integer> columnnumbers = new ArrayList<>();
        String[] pieces = numbersofchosencolumns.split(",");
        for(String piece : pieces){
            piece = piece.trim();
            if(!piece.isEmpty()){
                columnnumbers.add(Integer.parseInt(piece));
            }
        }
        for(int i = 0; i < inputlist.size();i++){
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX CUSTOMER COUNT: " + ((i) + 1) + " XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("\n");
                for(int i2 = 0; i2 < Storage.attribute_title_list.size();i2++) {
                    if (columnnumbers.contains(i2)) {
                    System.out.println(Storage.attribute_title_list.get(i2) + ": " + Service.getSoughtAttribute(inputlist.get(i), Storage.getter_function_list.get(i2)));
                }
            }
        }
    }

    public static void multiAttributePrintSortedByAttributes(String numbersofchosencolumns,ArrayList<Customers> inputlist) {

        ArrayList<Integer> columnnumbers = new ArrayList<>();
        String[] pieces = numbersofchosencolumns.split(",");
        for (String piece : pieces) {
            piece = piece.trim();
            if (!piece.isEmpty()) {
                columnnumbers.add(Integer.parseInt(piece));
            }
        }

        for(int i = 0; i < Storage.attribute_title_list.size();i++) {
            if (columnnumbers.contains(i)) {

                System.out.printf("%8s%s%s%s%n", "", " XXXX XXXX ",Storage.attribute_title_list.get(i), " XXXX XXXX");
                for (int i2 = 0; i2 < inputlist.size(); i2++) {
                    System.out.println(Storage.attribute_title_list.get(i) +": " + Service.getSoughtAttribute(inputlist.get(i2), Storage.getter_function_list.get(i)));

                }
            }
        }
    }

    public static void searchOneColumn(int columnnumber){

        Scanner scanner = new Scanner(System.in);
        System.out.println("\"Please insert what you want to search for: ");
        String theinput = scanner.next();
        UI.multiAttributePrintSortedByAttributes("1,2,3,4,5,6,7,8,9,10,11,12,13",Service.searchInColumnDynamical(Storage.all_customers,columnnumber,theinput));
    }


    /// MENUFUNCTIONS///////////////////////////////////////////////////////////////////////////////////////////////////



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
            System.out.println("What do you want to search?\n1-[BY COLUMN]Search sorted by column|||\n2-[BY COLUMN]Search in a certain column\n3-[BY CUSTOMER]Get all Customer entries|||\n4-[BY CUSTOMER]Get chosen Customer entries\n0-mainmenu \n\nInput: ");
            int auswahlsuche = scanner.nextInt();


            if (auswahlsuche == 1) {
                System.out.println("Insert your keyword: ");
                String searcheverything = scanner.next();
                for(int i = 0; i < Storage.all_customers.size();i++) {
                    UI.multiAttributePrintSortedByAttributes(String.valueOf(i), Service.searchInColumnDynamical(Storage.all_customers, i, searcheverything));
                }
           }

            if (auswahlsuche == 2) {
                while (true) {
                    System.out.println("Insert your keyword: ");

                    System.out.println("What column do you want to search in?\n\n1-Customer ID | 2-first name | 3-last name\n4-address | 5-city | 6-State" +
                            "\n7-country | 8-postal code | 9-phone | 10-fax \n11-email | 12-support rep id | 13-bill | \n0-previous menu");


                    String columnsuche = scanner.next();
                    int columnnumber = Integer.parseInt(columnsuche)-1;
                    String columnnumberfinal = String.valueOf(columnnumber);

                    System.out.println("Insert your keyword: ");
                    String searcheverything = scanner.next();
                    multiAttributePrintSortedByAttributes(columnnumberfinal, Service.searchInColumnDynamical(Storage.all_customers, columnnumber, searcheverything));





                }
            }

            if (auswahlsuche == 3) {

                multiAttributePrintSortedByCustomer("0,1,2,3,4,5,6,7,8,9,10,11,12,13",Storage.all_customers);

            }

            if (auswahlsuche == 4) {
                System.out.println("What do you want to search?");
                String searchauswahl = scanner.next();
                System.out.println("What Columns do you want to have displayed(seperate numbers by comma)?\n 1-Customer ID | 2-first name | 3-last name\\n4-address | 5-city | 6-State\" +\n" +
                        "                            \"\\n7-country | 8-postal code | 9-phone | 10-fax \\n11-email | 12-support rep id | 13-bill | \\n");
                String columnauswahl = scanner.next();
                for(int i = 0; i < Storage.all_customers.size();i++) {
                    multiAttributePrintSortedByCustomer(columnauswahl, Service.searchInColumnDynamical(Storage.all_customers, i, searchauswahl));
                }
            }

            if (auswahlsuche == 0) {
                break;
            }
        }
    }











//    public static void infoOutPutMenu(ArrayList<Customers> list) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What infos do you want to have displayed?\n1-all\n2-short\n3-select single columns\nchoice: ");
//        int outputmenu = scanner.nextInt();
//        if (outputmenu == 1) {
//            multiAttributePrintSortedByCustomer("1,2,3,4,5,6,7,8,9,10,11,12,13",list);
//        }
//
//        if (outputmenu == 2) {
//            multiAttributePrintSortedByCustomer("1,2,3,4,5,6",list);
//        }
//
//        if (outputmenu == 3)
//        {
//            System.out.println("What columns do you want to have displayed,please seperate the numbers with a comma.\n\n1-Customer ID | 2-first name | 3-last name\n4-address | 5-city | 6-state" +
//                    "\n7-country | 8-postalcode | 9-phone | 10-fax \n11-email | 12-support rep id | 13-bill | \n         0-previous menu");
//
//            String columnnumbers = scanner.next();
//
//            multiAttributePrintSortedByCustomer(columnnumbers,list);
//
//        }
//
//    }








//    public static void multiAttributePrintSortedByAttributes(String numbersofchosencolumns,ArrayList<Customers> inputlist) {
//
//        ArrayList<Integer> columnnumbers = new ArrayList<>();
//        String[] pieces = numbersofchosencolumns.split(",");
//        for (String piece : pieces) {
//            piece = piece.trim();
//            if (!piece.isEmpty()) {
//                columnnumbers.add(Integer.parseInt(piece));
//            }
//        }
//
//
//        if (columnnumbers.contains(1)) {
//
//            System.out.printf("%8s%s%n",""," XXXX XXXX CUSTOMER ID XXXX XXXX");
//            for (int i = 0; i < inputlist.size(); i++) {
//                System.out.println("Customer ID: " + Service.getSoughtAttribute(inputlist.get(i), Customers::getId));
//
//            }
//        }
//
//
//        if (columnnumbers.contains(2)) {
//            System.out.printf("%8s%s%n",""," XXXX XXXX FIRST NAME XXXX XXXX");
//            for (int i = 0; i < inputlist.size(); i++) {
//                System.out.printf("%-40s%5s%s%n", Service.getSoughtAttribute(inputlist.get(i), Customers::getFirstName), "CUSTOMER ID: ", Service.getSoughtAttribute(inputlist.get(i), Customers::getId));
//            }
//        }
//
//
//        if (columnnumbers.contains(3)) {
//            System.out.printf("%8s%s%n",""," XXXX XXXX LAST NAME XXXX XXXX");
//            for (int i = 0; i < inputlist.size(); i++) {
//                System.out.printf("%-40s%5s%s%n", Service.getSoughtAttribute(inputlist.get(i), Customers::getLastName), "CUSTOMER ID: ", Service.getSoughtAttribute(inputlist.get(i), Customers::getId));
//            }
//        }
//
//
//        if (columnnumbers.contains(4)) {
//            System.out.printf("%8s%s%n",""," XXXX XXXX ADDRESS XXXX XXXX");
//            for (int i = 0; i < inputlist.size(); i++) {
//                System.out.printf("%-40s%5s%s%n", Service.getSoughtAttribute(inputlist.get(i), Customers::getAddress), "CUSTOMER ID: ", Service.getSoughtAttribute(inputlist.get(i), Customers::getId));
//            }
//        }
//
//        if (columnnumbers.contains(5)) {
//            System.out.printf("%8s%s%n",""," XXXX XXXX CITY XXXX XXXX");
//            for (int i = 0; i < inputlist.size(); i++) {
//                System.out.printf("%-40s%5s%s%n", Service.getSoughtAttribute(inputlist.get(i), Customers::getCity), "CUSTOMER ID: ", Service.getSoughtAttribute(inputlist.get(i), Customers::getId));
//            }
//        }
//
//        if (columnnumbers.contains(6)) {
//            System.out.printf("%8s%s%n",""," XXXX XXXX STATE XXXX XXXX");
//            for (int i = 0; i < inputlist.size(); i++) {
//                System.out.printf("%-40s%5s%s%n", Service.getSoughtAttribute(inputlist.get(i), Customers::getState), "CUSTOMER ID: ", Service.getSoughtAttribute(inputlist.get(i), Customers::getId));
//            }
//        }
//
//        if (columnnumbers.contains(7)) {
//            System.out.printf("%8s%s%n",""," XXXX XXXX COUNTRY XXXX XXXX");
//            for (int i = 0; i < inputlist.size(); i++) {
//                System.out.printf("%-40s%5s%s%n", Service.getSoughtAttribute(inputlist.get(i), Customers::getCountry), "CUSTOMER ID: ", Service.getSoughtAttribute(inputlist.get(i), Customers::getId));
//            }
//        }
//
//        if (columnnumbers.contains(8)) {
//            System.out.printf("%8s%s%n",""," XXXX XXXX POSTAL CODE XXXX XXXX");
//            for (int i = 0; i < inputlist.size(); i++) {
//                System.out.printf("%-40s%5s%s%n", Service.getSoughtAttribute(inputlist.get(i), Customers::getPostalcode), "CUSTOMER ID: ", Service.getSoughtAttribute(inputlist.get(i), Customers::getId));
//            }
//        }
//
//        if (columnnumbers.contains(9)) {
//            System.out.printf("%8s%s%n",""," XXXX XXXX PHONE XXXX XXXX");
//            for (int i = 0; i < inputlist.size(); i++) {
//                System.out.printf("%-40s%5s%s%n", Service.getSoughtAttribute(inputlist.get(i), Customers::getPhone), "CUSTOMER ID: ", Service.getSoughtAttribute(inputlist.get(i), Customers::getId));
//            }
//        }
//
//        if (columnnumbers.contains(10)) {
//            System.out.printf("%8s%s%n",""," XXXX XXXX FAX XXXX XXXX");
//            for (int i = 0; i < inputlist.size(); i++) {
//                System.out.printf("%-40s%5s%s%n", Service.getSoughtAttribute(inputlist.get(i), Customers::getFax), "CUSTOMER ID: ", Service.getSoughtAttribute(inputlist.get(i), Customers::getId));
//            }
//        }
//
//        if (columnnumbers.contains(11)) {
//            System.out.printf("%8s%s%n",""," XXXX XXXX EMAIL XXXX XXXX");
//            for (int i = 0; i < inputlist.size(); i++) {
//                System.out.printf("%-40s%5s%s%n", Service.getSoughtAttribute(inputlist.get(i), Customers::getEmail), "CUSTOMER ID: ", Service.getSoughtAttribute(inputlist.get(i), Customers::getId));
//            }
//        }
//
//        if (columnnumbers.contains(12)) {
//            System.out.printf("%8s%s%n","","XXXX XXXX SUPPORT REP ID XXXX XXXX");
//            for (int i = 0; i < inputlist.size(); i++) {
//                System.out.printf("%-40s%5s%s%n", Service.getSoughtAttribute(inputlist.get(i), Customers::getSupportrepid), "CUSTOMER ID: ", Service.getSoughtAttribute(inputlist.get(i), Customers::getId));
//            }
//        }
//
//        // FUNKTIONIERT NOCH NICHT WEIL all_customers UNGEFÜLLTE "BILL" ATTRIBUTE HAT ( MUSS ICH NOCH VON DEM ANDEREN TABLE EINFÜGEN) [ ÜBERLEGEN WIE SINGLE BILL / TOTAL BILL DARGESTELLT / ZUGEGRIFFEN WERDEN SOLL ]
//        if (columnnumbers.contains(13)) {
//            System.out.printf("%8s%s%n","","XXXX XXXX BILL XXXX XXXX");
//            for (int i = 0; i < inputlist.size(); i++) {
//                System.out.printf("%-40s%5s%s%n", Service.getSoughtAttribute(inputlist.get(i), Customers::BillAsString), "CUSTOMER ID: ", Service.getSoughtAttribute(inputlist.get(i), Customers::getId));
//            }
//        }
//
//    }

    //public static void multiAttributePrintSortedByCustomerUnrefactored(String numbersofchosencolumns,ArrayList<Customers> inputlist){

//        ArrayList<Integer> columnnumbers = new ArrayList<>();
//        String[] pieces = numbersofchosencolumns.split(",");
//        for(String piece : pieces){
//            piece = piece.trim();
//            if(!piece.isEmpty()){
//                columnnumbers.add(Integer.parseInt(piece));
//            }
//        }
//        for(int i = 0; i < inputlist.size();i++){
//            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX CUSTOMER COUNT: " + ((i)+1) + " XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//            System.out.println("\n");
//            if (columnnumbers.contains(1)) {
//                System.out.println("Customer ID: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getId));
//            }
//
//            if (columnnumbers.contains(2)) {
//                System.out.println("First Name: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getFirstName));
//            }
//
//            if (columnnumbers.contains(3)) {
//                System.out.println("Last Name: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getLastName));
//            }
//
//            if (columnnumbers.contains(4)) {
//                System.out.println("Address: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getAddress));
//            }
//
//            if (columnnumbers.contains(5)) {
//                System.out.println("City: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getCity));
//            }
//
//            if (columnnumbers.contains(6)) {
//                System.out.println("State: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getState));
//            }
//
//            if (columnnumbers.contains(7)) {
//                System.out.println("Country: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getCountry));
//            }
//
//            if (columnnumbers.contains(8)) {
//                System.out.println("Postal Code: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getPostalcode));
//            }
//
//            if (columnnumbers.contains(9)) {
//                System.out.println("Phone: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getPhone));
//            }
//
//            if (columnnumbers.contains(10)) {
//                System.out.println("Fax: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getFax));
//            }
//
//            if (columnnumbers.contains(11)) {
//                System.out.println("Email: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getEmail));
//            }
//
//            if (columnnumbers.contains(12)) {
//                System.out.println("Support Rep ID: " + Service.getSoughtAttribute(inputlist.get(i),Customers::getSupportrepid));
//            }
//
//            if (columnnumbers.contains(13)) {
//                System.out.println("Bill: " + Service.getSoughtAttribute(inputlist.get(i),Customers::BillAsString)+ "\n");
//            }
//        }
//    }

    //    public static void wholeCustomerFormatAndPrint(String scannerinput)
//    {
//        ArrayList <String> currentkeyofpairlist = new ArrayList<>();
//        ArrayList<Function<Customers,String>> currentvalueofpairlist = new ArrayList<>() ;
//        Set<Map.Entry<String, Function<Customers, String>>> allEntrySets = AttributeNameAndGetterFunktionMap().entrySet(); // Set -> nennt sich "View" es ist kein Datentyp sondern eine "Art auf die Map zu schauen".
//        for(Map.Entry<String, Function<Customers, String>> keyloopvar : allEntrySets) {
//            currentkeyofpairlist.add(keyloopvar.getKey());
//            currentvalueofpairlist.add(keyloopvar.getValue());
//        }
//        for(int i = 0; i < ListNameList.size();i++)
//        { // geht nacheinander alle listen durch -> customerid[0],firstname[1],lastname[2] etc.
//            ArrayList<Customers> currentlist = Service.applyFunctionOnList(ListNameList.get(i), scannerinput, Service::valueSearchByContainingSubString);
//
//            System.out.println("----------------------------------------" + currentkeyofpairlist.get(i) + "------------------------------------------");
//            for(int i2 = 0; i2 < currentlist.size();i2++) {
//                System.out.printf("%-50s%5s%5s%n", Service.getSoughtAttribute(currentlist.get(i2), currentvalueofpairlist.get(i)), "Customer ID:", Service.getSoughtAttribute(currentlist.get(i2), Customers::getId));
//                //%-15s = 15 stellen von links(-) platz für name / 25s = nimmt 25 zeichen platz für customerID AB DEM PUNKT WO DIE 15 stellen des ersten Arguments aufhören(bzw genau ab stelle 15) /
//            }
//        }
//    }

//    private static Map<String, Function<Customers, String>> AttributeNameAndGetterFunktionMap() {
//        Map<String, Function<Customers, String>> map = new LinkedHashMap<>();
//
//        map.put("CUSTOMER ID", Customers::getId);
//        map.put("FIRST NAME", Customers::getFirstName);
//        map.put("LAST NAME", Customers::getLastName);
//        map.put("ADDRESS", Customers::getAddress);
//        map.put("CITY", Customers::getCity);
//        map.put("COUNTRY", Customers::getCountry);
//        map.put("COMPANY", Customers::getCompany);
//        map.put("STATE", Customers::getState);
//        map.put("PHONE", Customers::getPhone);
//        map.put("POSTAL CODE", Customers::getPostalcode);
//        map.put("FAX", Customers::getFax);
//        map.put("EMAIL", Customers::getEmail);
//        map.put("SUPPORT REP ID", Customers::getSupportrepid);
//        map.put("BILLS", Customers::BillAsString);
//
//        return map;
//    }
//    public static ArrayList<String> AttributeList = new ArrayList<>(Arrays.asList
//            ("customerid","first_name","last_name","address","city","country","company","state","phone","postalcode","fax","email","supportrepid","bill"));

}
