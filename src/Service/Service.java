package Service;

import Customers.Customers;
import Storage.Storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Service {

     //all_customer functions///////////////////////////////////////////////////////////////////////////////////////////

//    System.out.println("Where do you want to search? (dann 1-14 auflistung aller attribute"
//                       "in der Line dann scanner für Int -> soughtAttribute"
//                       "What do you want to search?
//                       "in der Line dann scanner für String -> input")
    public static ArrayList<Customers> searchInColumnDynamical(ArrayList<Customers> customerlist,int soughtAttribute,String input){
        ArrayList<Customers> outputlist = new ArrayList<>();
        for(int i = 0; i < customerlist.size();i++){
            for(int i2 = 0; i2 < Storage.all_customers.get(i).getInfoDynamical(soughtAttribute).size();i2++) {
                if (Storage.all_customers.get(i).getInfoDynamical(soughtAttribute).get(i2).toLowerCase().contains(input.toLowerCase())) { // if ID of customer contains input
                    outputlist.add(Storage.all_customers.get(i));                           // put it in outputlist
                }
            }
        }
        return outputlist;
    }
   //all_customers.get(0) [Customers 0] .getInfoDynamical(2 = first name) ->ArrayList<String> mit treffern

    //  System.out.println(Storage.all_customers.get(1).getInfoDynamical(3).get(0));

        //get(1) (zweiter Customer (1=0)
        //                                  3 Eintrag(getInfoDynamical arbeitet nicht mit index deshalb 3=3)
        //get(0) -> erster eintrag(da jedes attribut nur 1 eintrag hat isses an der stelle immer get(0).








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

    public static HashMap<String, ArrayList<Customers>> createKeyAndFillValuesSingleValue(String key, HashMap<String, ArrayList<Customers>> list, Customers customerinfo) {
        if (!list.containsKey(key)) {
            list.put(key, new ArrayList<>());
            list.get(key).add(customerinfo);
        }
        return list;
    }

    public static HashMap<String, Double> getAndRoundFinalSum(HashMap<String, Double> customerlist, String idofcustomer, Double billofcustomer) {
        if (!customerlist.containsKey(idofcustomer)) {
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

    public static String getSoughtAttribute(Customers customer, Function<Customers, String> getter) {
        return getter.apply(customer);
    }

    public static HashMap<String, ArrayList<Customers>> listShortCut(String listname) {
        return Storage.customersortedbycategories.get(listname);
    }

    public static ArrayList<Customers> applyFunctionOnList(String listname, String scannerinput, BiFunction<HashMap<String, ArrayList<Customers>>, String, ArrayList<Customers>> output) {

            return output.apply(listShortCut(listname), scannerinput);

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
            }
        }
        return sortedbyinput;
    }



}




