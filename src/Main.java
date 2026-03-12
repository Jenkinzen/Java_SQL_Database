import java.sql.Array;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main
{


    public static void connect() throws SQLException
    {
        //connection string
        var url = "jdbc:sqlite:C:\\Users\\ggord\\IdeaProjects\\neues_projekt\\chinook.db";

        try (var conn = DriverManager.getConnection(url)){
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException
    {
        connect();


        var stmt = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ggord\\IdeaProjects\\neues_projekt\\chinook.db").createStatement();

        var paymentinfos = stmt.executeQuery("SELECT BillingAddress,CustomerId,Total FROM invoices");

        while (paymentinfos.next())
        {
            String customerid = paymentinfos.getString("CustomerId");
            Double bill = paymentinfos.getDouble("Total");
            



            //Erstellen einer HashMap und Rechnung einfügen insofern es für die customerid noch keine gibt
            if(!customer_bill_by_id.containsKey(customerid))
            {
                customer_bill_by_id.put(customerid, bill);
            } else {
                // wenn es die customerid schon gibt > nächsten betrag zum Zahlungsbetrag addieren.
                 double currentbill = customer_bill_by_id.get(customerid);
                double summedbillrounded = Math.round(100.0 * (currentbill + bill)) / 100.0;
                 customer_bill_by_id.put(customerid, summedbillrounded);
            }


        }



        var customerinfos = stmt.executeQuery("SELECT * FROM customers");



        while (customerinfos.next())
        {

            String country = customerinfos.getString("Country");
            String customerid = customerinfos.getString("CustomerId");










            Customers c = new Customers(
                    customerinfos.getString("CustomerId"),customerinfos.getString("FirstName"),
                    customerinfos.getString("LastName"),customerinfos.getString("Company"),customerinfos.getString("Address"),
                    customerinfos.getString("City"),customerinfos.getString("State"),
                    country,customerinfos.getString("PostalCode"),
                    customerinfos.getString("Phone"),customerinfos.getString("Fax"),
                    customerinfos.getString("Email"),customerinfos.getString("SupportRepId"),
                    //clabel customerid weil .get die Value zum angegebenen Key sucht
                    customer_bill_by_id.get(customerinfos.getString("CustomerId")));


                Double getbillrounded = Math.round(100.0*c.getBill()) / 100.0;

            if(!customers_sorted_by_country.containsKey(country)){
                customers_sorted_by_country.put(country,new ArrayList<>());
            }

            customers_sorted_by_country.get(customerinfos.getString("Country")).add(
                            "\n\nCustomer ID: " + c.getId()+ " " +
                            "\nFirst name: " +c.getFirstName()+ " " +
                            "\nLast name: "+c.getLastName()+ " " +
                            "\nAddress: " + c.getAddress()+ " " +
                            "\nCity: " + c.getCity()+ " "+
                            "\nCountry: " + c.getCountry()+ " " +
                            "\nBill: " + getbillrounded + " $");


            if(!customer_sorted_by_country_as_customerobject.containsKey(country)){
                customer_sorted_by_country_as_customerobject.put(country,new ArrayList<>());
            }
            if(customer_sorted_by_country_as_customerobject.containsKey(country)){
                customer_sorted_by_country_as_customerobject.get(country).add(c);
            }



            if(!customer_sorted_by_id.containsKey(country)){
                customer_sorted_by_id.put(country, c);
            }
            customer_sorted_by_id.get(customerid);

        }



        System.out.println(customers_sorted_by_country.get("Germany"));
        System.out.println(customer_bill_by_id.get("38"));


        ArrayList<Customers> xyz = customer_sorted_by_country_as_customerobject.get("Germany");
        System.out.println(xyz.get(1).getFirstName() + "\n");


        //so kann man mehrere Attribute holen
        Customers x = customer_sorted_by_country_as_customerobject.get("Germany").get(0);
        System.out.println(x.getFirstName());
        System.out.println(x.getLastName());
        System.out.println(x.getAddress());
        System.out.println(x.getState());
        System.out.println(x.getCountry());




    }


    static HashMap<String, Customers> customer_sorted_by_id = new HashMap<>();
    static HashMap<String, Double> customer_bill_by_id = new HashMap<>();

    //funktioniert, ist aber Scheiße weil man keine einzelnen Attribute aufrufen kann da alle Attribute in ,und als, String gespeichert werden.
    static HashMap<String, ArrayList<String>> customers_sorted_by_country = new HashMap<>();

    //eher so mit kompletten Objekten als Value
    static HashMap<String, ArrayList<Customers>> customer_sorted_by_country_as_customerobject = new HashMap<>();



}



