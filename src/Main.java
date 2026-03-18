import java.sql.Array;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class Main {


    public static void main(String[] args) throws SQLException {
        Connection.connection();

        ///CONNECTION/////////////////////////////////////////////////////////////////////////////////////
        var stmt = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ggord\\IdeaProjects\\neues_projekt\\chinook.db").createStatement();


        ///SQL DATASOURCE|PAYMENTINFOS////////////////////////////////////////////////////////////////////
        var paymentinfos = stmt.executeQuery("SELECT BillingAddress,CustomerId,Total FROM invoices");

        while (paymentinfos.next()) {
            String customerid = paymentinfos.getString("CustomerId");
            Double bill = paymentinfos.getDouble("Total");


            //Erstellen einer HashMap und Rechnung einfügen insofern es für die customerid noch keine gibt

            Service.getandroundfinalsum(customer_bill_by_id, customerid, bill);


        }

        /// SQL DATASOURCE|CUSTOMERINFOS///////////////////////////////////////////////////////////////////
        var customerinfos = stmt.executeQuery("SELECT * FROM customers");


        while (customerinfos.next()) {

            String customerid = customerinfos.getString("CustomerId");
            String firstname = customerinfos.getString("FirstName");
            String lastname = customerinfos.getString("LastName");
            String address = customerinfos.getString("Address");
            String city = customerinfos.getString("City");
            String country = customerinfos.getString("Country");
            String state = customerinfos.getString("State");
            String company = customerinfos.getString("Company");
            String postalcode = customerinfos.getString("PostalCode");
            String phone = customerinfos.getString("Phone");
            String fax = customerinfos.getString("Fax");
            String email = customerinfos.getString("Email");
            String supportrepid = customerinfos.getString("SupportRepId");
            //clabel customerid weil .get die Value zum angegebenen Key sucht
            Double bill = customer_bill_by_id.get(customerinfos.getString("CustomerId"));


            Customers c = new Customers(customerid, firstname, lastname, address, city, country, company, state, phone, postalcode, fax, email, supportrepid, bill);


            //Customer(Value) werden nach Anfangsbuchstabe des Nachnamens(Key) in customer_sorted_by_lastname_letter gepackt
            Service.sortedbystartingletters(firstname, customers_sorted_by_firstname_letter, c);
            Service.sortedbystartingletters(lastname, customers_sorted_by_lastname_letter, c);


            //Mehrere Values werden einem Key zugewiesen
            Service.createkeyandfillvaluesMultiValue(address, customers_sorted_by_address, c);
            Service.createkeyandfillvaluesMultiValue(city,customers_sorted_by_city,c);
            Service.createkeyandfillvaluesMultiValue(country, customers_sorted_by_country, c);
            Service.createkeyandfillvaluesMultiValue(state, customers_sorted_by_state, c);
            Service.createkeyandfillvaluesMultiValue(company, customers_sorted_by_company,c);
            Service.createkeyandfillvaluesMultiValue(postalcode,customers_sorted_by_postalcode,c);
            Service.createkeyandfillvaluesMultiValue(supportrepid,customers_sorted_by_supportrepid,c);

            //Eine Value wird einem Key zugewiesen
            Service.createkeyandfillvaluesSingleValue(lastname, customers_sorted_by_lastname, c);
            Service.createkeyandfillvaluesSingleValue(firstname, customers_sorted_by_firstname, c);
            Service.createkeyandfillvaluesSingleValue(customerid, customers_sorted_by_id, c);
            Service.createkeyandfillvaluesSingleValue(email,customers_sorted_by_email,c);



            //Übergeordnete HashMap (quasi Hauptmenü um sachen bezüglich Customer zu finden)
            customersortedbycategories.put("customerid", customers_sorted_by_id);
            customersortedbycategories.put("first_name_letter", customers_sorted_by_firstname_letter);
            customersortedbycategories.put("last_name_letter", customers_sorted_by_lastname_letter);
            customersortedbycategories.put("first_name", customers_sorted_by_firstname);
            customersortedbycategories.put("last_name", customers_sorted_by_lastname);
            customersortedbycategories.put("company", customers_sorted_by_company);
            customersortedbycategories.put("address", customers_sorted_by_address);
            customersortedbycategories.put("postalcode",customers_sorted_by_postalcode);
            customersortedbycategories.put("city", customers_sorted_by_city);
            customersortedbycategories.put("country", customers_sorted_by_country);
            customersortedbycategories.put("state", customers_sorted_by_state);
            customersortedbycategories.put("phone", customers_sorted_by_phone);
            customersortedbycategories.put("fax", customers_sorted_by_fax);
            customersortedbycategories.put("supportrepid", customers_sorted_by_supportrepid);
            customersortedbycategories.put("bill", customers_sorted_by_bill);



        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the main menu\nWhat do you want to do??\n1-Search\n2-blabla\n3-blablabla\nInput: ");
        int auswahlmenu = scanner.nextInt();
        if(auswahlmenu == 1){
            System.out.println("What do you want to search?\n1-Search in the whole Database\n2-Search in a certain column\nInput: ");
            int auswahlsuche = scanner.nextInt();
            if(auswahlsuche == 1){
                return;
            }
            if(auswahlsuche == 2){
                System.out.println("What column do you want to search in?\n1-Customer ID\n2-first name\n3-last name\n4-company\n5-address\n6-postal code" +
                        "7-city\n8-country\n9-state\n10-phone\n11-fax\n12-support rep id\n13-bill");
                int columnsuche = scanner.nextInt();
                if(columnsuche == 1){
                    System.out.println("Please insert what you want to search\ninsert \"all\" for every entry: ");
                    String customeridinput = scanner.next();
                    if (!Objects.equals(customeridinput, "all")) {
                        System.out.println(Service.outputofcustomerwithsamestartingletters(customeridinput, customersortedbycategories.get("customerid")));
                    }
                    if(Objects.equals(customeridinput, "all")){
                        System.out.println(Service.valuesearchbycontainingsubstring(customersortedbycategories.get("customerid"),""));
                    }
                    //Numerische Oder irgendwelche reihenfolgen werden nicht von HashMaps, nur von linkedHashMaps generiert, muss ich mich morgen mal schlau machen.
                }
                if(columnsuche == 2){
                    System.out.println("Please insert what you want to search\ninsert \"all\" for every entry: ");
                    String firstnameinput = scanner.next();
                    System.out.println(Service.valuesearchbycontainingsubstring(customersortedbycategories.get("first_name"),firstnameinput));
                }
                if(columnsuche == 3){
                    System.out.println("Please insert what you want to search");
                    String lastnameinput = scanner.next();
                    System.out.println(Service.valuesearchbycontainingsubstring(customersortedbycategories.get("last_name"),lastnameinput));
                }
                if(columnsuche == 4){
                    System.out.println("Please insert what you want to search");
                    String companyinput = scanner.next();
                    System.out.println(Service.valuesearchbycontainingsubstring(customersortedbycategories.get("company"),companyinput));
                }
                if(columnsuche == 5){
                    System.out.println("Please insert what you want to search");
                    String addressinput = scanner.next();
                    System.out.println(Service.valuesearchbycontainingsubstring(customersortedbycategories.get("address"),addressinput));
                }
                if(columnsuche == 6){
                    System.out.println("Please insert what you want to search");
                    String postalcodeinput = scanner.next();
                    System.out.println(Service.valuesearchbycontainingsubstring(customersortedbycategories.get("postalcode"),postalcodeinput));
                }
                if(columnsuche == 7){
                    System.out.println("Please insert what you want to search");
                    String cityinput = scanner.next();
                    System.out.println(Service.valuesearchbycontainingsubstring(customersortedbycategories.get("city"),cityinput));
                }
                if(columnsuche == 8){
                    System.out.println("Please insert what you want to search");
                    String countryinput = scanner.next();
                    System.out.println(Service.valuesearchbycontainingsubstring(customersortedbycategories.get("country"),countryinput));
                }
                if(columnsuche == 9){
                    System.out.println("Please insert what you want to search");
                    String stateinput = scanner.next();
                    System.out.println(Service.valuesearchbycontainingsubstring(customersortedbycategories.get("state"),stateinput));
                }
                if(columnsuche == 10){
                    System.out.println("Please insert what you want to search");
                    String phoneinput = scanner.next();
                    System.out.println(Service.valuesearchbycontainingsubstring(customersortedbycategories.get("phone"),phoneinput));
                }
                if(columnsuche == 11){
                    System.out.println("Please insert what you want to search");
                    String faxinput = scanner.next();
                    System.out.println(Service.valuesearchbycontainingsubstring(customersortedbycategories.get("fax"),faxinput));
                }
                if(columnsuche == 12){
                    System.out.println("Please insert what you want to search");
                    String supportrepidinput = scanner.next();
                    System.out.println(Service.valuesearchbycontainingsubstring(customersortedbycategories.get("supportrepid"),supportrepidinput));
                }
                if(columnsuche == 13){
                    System.out.println("Please insert what you want to search");
                    String billinput = scanner.next();
                    System.out.println(Service.valuesearchbycontainingsubstring(customersortedbycategories.get("bill"),billinput));
                }

            }
        }
        if (auswahlmenu == 2){
            return;
        }

//        System.out.println(customersortedbycategories.get("first_name"));
//
//        //customersortedbycategories get first_name ist basically die referenz durch die HashMap auf die customers sorted by firstname Hashmap
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        Service.outputofcustomerwithsamestartingletters("H", customersortedbycategories.get("first_name_letter"));
//        Service.outputofcustomerwithsamestartingletters("H", customersortedbycategories.get("last_name_letter"));
//        System.out.println("XYXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//
//        System.out.println(customers_sorted_by_firstname_letter.get("A").get(0).getInfoShort());
//
//
//        Service.valuesearchbycontainingsubstring(customersortedbycategories.get("first_name"), "la");
//        Service.valuesearchbycontainingsubstring(customersortedbycategories.get("last_name"), "H");
//

    }


    static HashMap<String, Double> customer_bill_by_id = new HashMap<>();

    // übergeordnete HashMap um Kategorien auszuwählen
    static HashMap<String, HashMap<String, ArrayList<Customers>>> customersortedbycategories = new HashMap<>();


    //static HashMap<String, ArrayList<String>> customers_sorted_by_country = new HashMap<>();
    //funktioniert, ist aber Scheiße weil man keine einzelnen Attribute aufrufen kann da alle Attribute in ,und als, String gespeichert werden.


    //eher so mit kompletten Objekten als Value(bzw ArrayListen mit Objekten drin)
    static LinkedHashMap<String, ArrayList<Customers>> customers_sorted_by_id = new LinkedHashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_country = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_firstname_letter = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_lastname_letter = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_firstname = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_lastname = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_state = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_address = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_city = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_company = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_phone = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_postalcode = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_fax = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_email = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_supportrepid = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_bill = new HashMap<>();


}



