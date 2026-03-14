import java.sql.Array;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main
{


    public static void main(String[] args) throws SQLException
    {   Connection.connection();

        ///CONNECTION/////////////////////////////////////////////////////////////////////////////////////
        var stmt = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ggord\\IdeaProjects\\neues_projekt\\chinook.db").createStatement();


        ///SQL DATASOURCE|PAYMENTINFOS////////////////////////////////////////////////////////////////////
        var paymentinfos = stmt.executeQuery("SELECT BillingAddress,CustomerId,Total FROM invoices");

        while (paymentinfos.next())
        {
            String customerid = paymentinfos.getString("CustomerId");
            Double bill = paymentinfos.getDouble("Total");




            //Erstellen einer HashMap und Rechnung einfügen insofern es für die customerid noch keine gibt

            Service.getandroundfinalsum(customer_bill_by_id,customerid,bill);



        }


        /// SQL DATASOURCE|CUSTOMERINFOS///////////////////////////////////////////////////////////////////
        var customerinfos = stmt.executeQuery("SELECT * FROM customers");



        while (customerinfos.next())
        {

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



            Customers c = new Customers(customerid,firstname,lastname,address,city,country,state,company,postalcode,phone,fax,email,supportrepid,bill);

                    //Customer(Value) werden nach Anfangsbuchstabe des Nachnamens(Key) in customer_sorted_by_lastname gepackt
                    Service.sortingbyletters(lastname,customers_sorted_by_lastname,c);

                    //Customer(Value) werden in Länder(Key) unterteilt
                    Service.createkeyandfillvalues(country,customer_sorted_by_country,c);

        }


        // Übergeordnete HashMap anlegen -> HashMap<(Kategorien nach denen sortiert werden soll als string), HashMap<Unterkategorie, ArrayList<Customers> (bspw customer sorted by country oder by last name.)

        System.out.println(customer_bill_by_id.get("38")+"$");


        ArrayList<Customers> xyz = customer_sorted_by_country.get("Germany"); //wählt erst Key ("Germany")
        System.out.println("\n" + xyz.get(2).getInfoShort()); //Dann Value (1) plus Getter(funktion)


        Customers x = customer_sorted_by_country.get("Germany").get(2);//Wählt erst Key UND Value.
        System.out.println("\n" + x.getInfoShort()); // danach nur noch Getter(funktion).

        System.out.println(customer_sorted_by_country.get("Germany").get(2).getInfoShort()); //ohne Variable in einer Line

        //Alle Customer eines Landes
        Service.customersbycountry(customer_sorted_by_country,"France");


        //Alle Customer sortiert nach Anfangsbuchstaben der Nachnamen
        Service.sortedbylastnameletter("H",customers_sorted_by_lastname);





    }




    static HashMap<String, Double> customer_bill_by_id = new HashMap<>();


    //static HashMap<String, ArrayList<String>> customers_sorted_by_country = new HashMap<>();
    //funktioniert, ist aber Scheiße weil man keine einzelnen Attribute aufrufen kann da alle Attribute in ,und als, String gespeichert werden.


    //eher so mit kompletten Objekten als Value(bzw ArrayListen mit Objekten drin)
    static HashMap<String, ArrayList<Customers>> customer_sorted_by_country = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_lastname = new HashMap<>();



}



