package Storage;

import Customers.Customers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Storage {
    public static HashMap<String, Double> customer_bill_by_id = new HashMap<>();

    // übergeordnete HashMap um Kategorien auszuwählen
    public static HashMap<String, HashMap<String, ArrayList<Customers>>> customersortedbycategories = new HashMap<>();


//public static HashMap<String, ArrayList<String>> customers_sorted_by_country = new HashMap<>();
//funktioniert, ist aber Scheiße weil man keine einzelnen Attribute aufrufen kann da alle Attribute in ,und als, String gespeichert werden.


    //eher so mit kompletten Objekten als Value(bzw ArrayListen mit Objekten drin)
    public static LinkedHashMap<String, ArrayList<Customers>> customers_sorted_by_id = new LinkedHashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_country = new HashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_firstname_letter = new HashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_lastname_letter = new HashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_firstname = new HashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_lastname = new HashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_state = new HashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_address = new HashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_city = new HashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_company = new HashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_phone = new HashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_postalcode = new HashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_fax = new HashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_email = new HashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_supportrepid = new HashMap<>();
    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_bill = new HashMap<>();
}
