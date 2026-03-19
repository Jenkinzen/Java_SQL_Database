import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Storage {
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
