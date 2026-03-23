import java.util.ArrayList;
import java.util.HashMap;

public class Service {


    //Erstellen einer HashMap und Rechnung einfügen insofern es für die customerid noch keine gibt
    // else -> wenn es eine gibt die Values in die ArrayList der HashMap einfügen

    public static HashMap<String, ArrayList<Customers>> createkeyandfillvaluesMultiValue(String keyvalue, HashMap<String, ArrayList<Customers>> hashmap,Customers customerinfo) {
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


    public static ArrayList<Customers> valuesearchbycontainingsubstring(HashMap<String, ArrayList<Customers>> customerlist,String containedsubstring) {
        ArrayList<Customers>sortedbyinput = new ArrayList<>();
        for (String xxx : customerlist.keySet())
        {

            String xxxtostring = String.valueOf(xxx);
            if (xxxtostring.contains(containedsubstring))
            {
                for (int i = 0; i < customerlist.get(xxxtostring).size(); i++)
                {
                    sortedbyinput.add(customerlist.get(xxxtostring).get(i));
                }
            }
        }
        return sortedbyinput;
    }

    public static HashMap<String, ArrayList<Customers>> createkeyandfillvaluesSingleValue(String key,HashMap<String, ArrayList<Customers>> list,Customers customerinfo){
        if(!list.containsKey(key)){
            list.put(key, new ArrayList<>());
            list.get(key).add(customerinfo);
        }
        return list;
    }

    public static HashMap<String, Double> getandroundfinalsum(HashMap<String, Double> customerlist,String idofcustomer,Double billofcustomer){
    if(!customerlist.containsKey(idofcustomer))
    {
        customerlist.put(idofcustomer, billofcustomer);
    } else {
            // wenn es die customerid schon gibt > nächsten betrag zum Zahlungsbetrag addieren.
            double currentbill = customerlist.get(idofcustomer); // holt die Value aus bill by id (key: customerid | value: bill)
            //double summedbillrounded = Math.round(100.0 * (currentbill + billofcustomer)) / 100.0; //rundet auf 2Nachkommastellen (wegen Bug)
            customerlist.put(idofcustomer, billofcustomer); // pack rinn.
        }
        return customerlist; //jib russ.
    }



    //Erzeuge neuen Key für Anfangsbuchstabe des Attributes wenns keinen gibt, sonst pack jede Value mit gleichem Anfangsbuchstaben an den Key.
    // weiß nich obs überhaupt smart is den kram in ner funktion zu haben weil sortieren nach anfangsbuchstabe klingt jetz nich so krass nach
    // reusability... naja ma gucken.
    public static HashMap<String, ArrayList<Customers>> sortedbystartingletters(String startingletterword, HashMap<String, ArrayList<Customers>> outputlist, Customers customerinfo) {
            String startingletter = (startingletterword.substring(0, 1));
            if (!outputlist.containsKey(startingletter)) {
                outputlist.put(startingletter, new ArrayList<>());
                outputlist.get(startingletter).add(customerinfo);
            } else {
                outputlist.get(startingletter).add(customerinfo);
            }
            return outputlist;
    }





    //gib mir die ganzen Infos der Values des eingegebenen Keys
    public static ArrayList<Customers> outputofcustomerwithsamestartingletters(HashMap<String, ArrayList<Customers>> list,String lastnameletter)
    {
        for(int i = 0; i < list.get(lastnameletter).toArray().length;i++) {
            ArrayList<Customers> listbyletters = list.get(lastnameletter);
            listbyletters.get(i);
            System.out.println(listbyletters.get(i).getInfoShort());
        }
        return null;
    }



}


