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



        var customerinfos = stmt.executeQuery("SELECT customers.*, invoices.BillingAddress, " +
                "invoices.Total FROM customers JOIN invoices ON customers.CustomerId = invoices.CustomerId");

        while (customerinfos.next())
        {
            if(!customers_sorted_by_country.containsKey(customerinfos.getString("Country"))){
                customers_sorted_by_country.put(customerinfos.getString("Country"),new ArrayList<>());
            }


            // WIRD MEHRMALS AUSGEGEBEN WEIL EINE PERSON MEHRERE BETRÄGE OFFEN HAT , ALSO MORGEN "TOTAL" aus invoice zsm rechnen lassen und das dem kunden als

            Customer.Customers c = new Customer.Customers(
                    customerinfos.getString("CustomerId"),customerinfos.getString("FirstName"),
                    customerinfos.getString("LastName"),customerinfos.getString("Company"),customerinfos.getString("Address"),
                    customerinfos.getString("City"),customerinfos.getString("State"),
                    customerinfos.getString("Country"),customerinfos.getString("PostalCode"),
                    customerinfos.getString("Phone"),customerinfos.getString("Fax"),
                    customerinfos.getString("Email"),customerinfos.getString("SupportRepId"),customerinfos.getDouble("Total"));


            customers_sorted_by_country.get(customerinfos.getString("Country")).add(
                            "\n\nFirst name: " +c.getFirstName()+ " " +
                            "\nLast name: "+c.getLastName()+ " " +
                            "\nAddress: " + c.getAddress()+ " " +
                            "\nCity: " + Customer.Customers.getCity()+ " "+
                            "\nCountry: " + c.getCountry()+ " " +
                            "\nBill: " + c.getPaymentamount()+ " $"
            );


        }



        System.out.println(customers_sorted_by_country.get("Germany"));




    }

    static HashMap<String, Double> customerpaymentcheck = new HashMap<>();
    static HashMap<String, ArrayList<String>> customers_sorted_by_id = new HashMap<>();
    static HashMap<String, ArrayList<String>> customers_sorted_by_country = new HashMap<>();





}



