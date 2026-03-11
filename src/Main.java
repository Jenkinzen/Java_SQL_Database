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
                // wenn es die customerid schon gibt > nächsten betrag zur Rechnung adden.
                 double currentbill = customer_bill_by_id.get(customerid);
                 customer_bill_by_id.put(customerid, currentbill + bill);
            }


        }



        var customerinfos = stmt.executeQuery("SELECT * FROM customers");



        while (customerinfos.next())
        {

            String country = customerinfos.getString("Country");

            if(!customers_sorted_by_country.containsKey(country)){
                customers_sorted_by_country.put(country,new ArrayList<>());
            }






            Customer.Customers c = new Customer.Customers(
                    customerinfos.getString("CustomerId"),customerinfos.getString("FirstName"),
                    customerinfos.getString("LastName"),customerinfos.getString("Company"),customerinfos.getString("Address"),
                    customerinfos.getString("City"),customerinfos.getString("State"),
                    country,customerinfos.getString("PostalCode"),
                    customerinfos.getString("Phone"),customerinfos.getString("Fax"),
                    customerinfos.getString("Email"),customerinfos.getString("SupportRepId"),
                    //clabel customerid weil .get die Value zum angegebenen Key sucht
                    customer_bill_by_id.get(customerinfos.getString("CustomerId")));





            customers_sorted_by_country.get(customerinfos.getString("Country")).add(
                            "\n\nFirst name: " +c.getFirstName()+ " " +
                            "\nLast name: "+c.getLastName()+ " " +
                            "\nAddress: " + c.getAddress()+ " " +
                            "\nCity: " + c.getCity()+ " "+
                            "\nCountry: " + c.getCountry()+ " " +
                            "\nBill: " + c.getBill()+ " $");
        }



        System.out.println(customers_sorted_by_country.get("Germany"));
        System.out.println(customer_bill_by_id.get("1"));



    }


    static HashMap<String, Double> customer_bill_by_id = new HashMap<>();
    static HashMap<String, ArrayList<String>> customers_sorted_by_country = new HashMap<>();





}



