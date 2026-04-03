package Service;

import Customers.Customers;
import Storage.Storage;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Service {




    //SQL-DATACONVERTING FUNCTIONS//////////////////////////////////////////////////////////////////////////////////////
    public static HashMap<String, ArrayList<Customers>> createKeyAndFillValuesMultiValue(String keyvalue, HashMap<String, ArrayList<Customers>> hashmap, Customers customerinfo) {
        if (!hashmap.containsKey(keyvalue)) {
            hashmap.put(keyvalue, new ArrayList<>());
            hashmap.get(keyvalue).add(customerinfo);

        } else {
            if (hashmap.containsKey(keyvalue)) {
                hashmap.get(keyvalue).add(customerinfo);
            }
            return hashmap;
        }

        return hashmap;
    }

    public static HashMap<String, ArrayList<Customers>> createKeyAndFillValuesSingleValue(String key,HashMap<String, ArrayList<Customers>> list,Customers customerinfo){
        if(!list.containsKey(key)){
            list.put(key, new ArrayList<>());
            list.get(key).add(customerinfo);
        }
        return list;
    }

    public static HashMap<String, Double> getAndRoundFinalSum(HashMap<String, Double> customerlist,String idofcustomer,Double billofcustomer){
    if(!customerlist.containsKey(idofcustomer))
    {
        customerlist.put(idofcustomer, billofcustomer);
    } else {
            // wenn es die customerid schon gibt > nächsten betrag zum Zahlungsbetrag addieren.
            double currentbill = customerlist.get(idofcustomer); // holt die Value aus bill by id (key: customerid | value: bill)
            customerlist.put(idofcustomer, billofcustomer); // pack rinn.
        }
        return customerlist; //jib russ.
    }


    //SORT-AND-FIND-FUNCTIONS///////////////////////////////////////////////////////////////////////////////////////////

    public static HashMap<String, ArrayList<Customers>> sortedByStartingLetters(String startingletterword, HashMap<String, ArrayList<Customers>> outputlist, Customers customerinfo) {
            String startingletter = (startingletterword.substring(0, 1));
            if (!outputlist.containsKey(startingletter)) {
                outputlist.put(startingletter, new ArrayList<>());
                outputlist.get(startingletter).add(customerinfo);
            } else {
                outputlist.get(startingletter).add(customerinfo);
            }
            return outputlist;
    }

    public static String getSoughtAttribute(Customers customer, Function<Customers, String> getter)
    {
       return getter.apply(customer);
    }

    public static HashMap<String, ArrayList<Customers>>  listShortCut(String listname){
        return Storage.customersortedbycategories.get(listname);
    }

    public static ArrayList<Customers> applyFunctionOnList(String listname, String scannerinput, BiFunction<HashMap<String, ArrayList<Customers>>, String, ArrayList<Customers>> output)
        {   ArrayList<Customers> outputresult = new ArrayList<>();
            for(int i = 0; i < listShortCut(listname).size();i++)
            {
            outputresult =  output.apply(listShortCut(listname), scannerinput);
            }
            return outputresult;
    }


    public static ArrayList<Customers> valueSearchByContainingSubString(HashMap<String, ArrayList<Customers>> customerlist,String containedsubstring) {
        ArrayList<Customers>sortedbyinput = new ArrayList<>();
        for (String xxx : customerlist.keySet())
         {
            try
            {
                String xxxtostring = String.valueOf(xxx); // macht null als Datentyp zu "null" als String
                if (xxxtostring.toLowerCase().contains(containedsubstring)) {
                    for (int i = 0; i < customerlist.get(xxxtostring).size(); i++) {
                        sortedbyinput.add(customerlist.get(xxxtostring).get(i));
                    }
                }
            } catch( Exception e){
                System.out.println("none");
                continue;
            }
        }
        return sortedbyinput;
    }
}


