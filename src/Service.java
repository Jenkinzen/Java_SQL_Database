import java.util.ArrayList;
import java.util.HashMap;

public class Service {

    public static HashMap<String, ArrayList<Customers>> createkeyandfillvalues(String keyvalue, HashMap<String, ArrayList<Customers>> hashmap,Customers customerinfo) {
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

    public static HashMap<String, Double> getandroundfinalsum(HashMap<String, Double> customerlist,String idofcustomer,Double billofcustomer){
    if(!customerlist.containsKey(idofcustomer))
    {
        customerlist.put(idofcustomer, billofcustomer);
    } else {
            // wenn es die customerid schon gibt > nächsten betrag zum Zahlungsbetrag addieren.
            double currentbill = customerlist.get(idofcustomer);
            double summedbillrounded = Math.round(100.0 * (currentbill + billofcustomer)) / 100.0;
            customerlist.put(idofcustomer, summedbillrounded);
        }
        return customerlist;
    }
}