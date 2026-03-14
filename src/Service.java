import java.util.ArrayList;
import java.util.HashMap;

public class Service {


    //Erstellen einer HashMap und Rechnung einfügen insofern es für die customerid noch keine gibt
    // else -> wenn es eine gibt die Values in die ArrayList der HashMap einfügen

    public static HashMap<String, ArrayList<Customers>> createkeyandfillvaluesStringArray(String keyvalue, HashMap<String, ArrayList<Customers>> hashmap,Customers customerinfo) {
        if (!hashmap.containsKey(keyvalue)) {
            hashmap.put(keyvalue, new ArrayList<>());

        } else {
            if (hashmap.containsKey(keyvalue)) {
                hashmap.get(keyvalue).add(customerinfo);
            }
            return hashmap;
        }

        return hashmap;
    }

    public static HashMap<String, ArrayList<Customers>> createkeyandfillvaluesStringArrayDirectAdd(String customerid,HashMap<String, ArrayList<Customers>> list,Customers customerinfo){
        if(!list.containsKey(customerid)){
            list.put(customerid, new ArrayList<>());
            list.get(customerid).add(customerinfo);
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

    //
    public static ArrayList<Customers> customersbycountry(HashMap<String, ArrayList<Customers>> customerlist,String thecountryx)
    {
        ArrayList<Customers> bla = customerlist.get(thecountryx); //
        for (int i = 0; i < customerlist.get(thecountryx).toArray().length; i++)
            {
                System.out.println(bla.get(i).getInfoShort());
            }
        return bla;
    }
    //Erzeuge neuen Key für Anfangsbuchstabe des Attributes wenns keinen gibt, sonst pack jede Value mit gleichem Anfangsbuchstaben an den Key.
    // weiß nich obs überhaupt smart is den kram in ner funktion zu haben weil sortieren nach anfangsbuchstabe klingt jetz nich so krass nach
    // reusability... naja ma gucken.
    public static HashMap<String, ArrayList<Customers>> sortingbylastnamestartingletters(String lastname,HashMap<String, ArrayList<Customers>>outputlist,Customers customerinfo) {
        String startingletter = (lastname.substring(0, 1));
        if (!outputlist.containsKey(startingletter)) {
            outputlist.put(startingletter, new ArrayList<>());
        } else {
            outputlist.get(startingletter).add(customerinfo);
        }
        return outputlist;
    }


    //gib mir die ganzen Infos der Values des eingegebenen Keys
    public static ArrayList<Customers> outputofcustomerwithsamestartingletters(String lastnameletter,HashMap<String, ArrayList<Customers>> list)
    {
    System.out.println(list.keySet());
        for(int i = 0; i < list.get(lastnameletter).toArray().length;i++) {
            ArrayList<Customers> listbyletters = list.get(lastnameletter);
            listbyletters.get(i);
            System.out.println(listbyletters.get(i).getInfoShort());
        }
        return null;
    }
}