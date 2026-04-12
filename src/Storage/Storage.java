package Storage;

import Customers.Customers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Storage {

    // BILL LIST ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public static HashMap<String, ArrayList<Double>> customer_bill_by_id = new HashMap<>();


    // MAIN LIST ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public static ArrayList<Customers> all_customers = new ArrayList<>();

    // ATTRIBUTE TITLE LIST ////////////////////////////////////////////////////////////////////////////////////////////
    public static ArrayList<String> attribute_title_list = new ArrayList<>(Arrays.asList(
            "Customer ID","First Name","Last Name","Address","City","State","Country","Postal Code"
            ,"Phone","Fax","Email","Support Rep ID","Bill"));

    public static ArrayList<Function<Customers,String>> getter_function_list = new ArrayList<>(Arrays.asList(
            Customers::getId,Customers::getFirstName,Customers::getLastName,Customers::getAddress,Customers::getCity
            ,Customers::getState,Customers::getCountry,Customers::getPostalcode,Customers::getPhone,Customers::getFax
            ,Customers::getEmail,Customers::getSupportrepid,Customers::BillAsString
    ));















    // übergeordnete HashMap um Kategorien auszuwählen
    //public static HashMap<String, HashMap<String, ArrayList<Customers>>> customersortedbycategories = new HashMap<>();

//    public static LinkedHashMap<String, ArrayList<Customers>> customers_sorted_by_id = new LinkedHashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_country = new HashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_firstname_letter = new HashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_lastname_letter = new HashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_firstname = new HashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_lastname = new HashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_state = new HashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_address = new HashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_city = new HashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_company = new HashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_phone = new HashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_postalcode = new HashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_fax = new HashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_email = new HashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_supportrepid = new HashMap<>();
//    public static HashMap<String, ArrayList<Customers>> customers_sorted_by_bill = new HashMap<>();

}
