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

        ///CONNECTION/////////////////////////////////////////////////////////////////////////
        var stmt = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ggord\\IdeaProjects\\neues_projekt\\chinook.db").createStatement();


        ///SQL DATASOURCE////////////////////////////////////////////////////////////////////
        var paymentinfos = stmt.executeQuery("SELECT BillingAddress,CustomerId,Total FROM invoices");

        while (paymentinfos.next())
        {
            String customerid = paymentinfos.getString("CustomerId");
            Double bill = paymentinfos.getDouble("Total");




            //Erstellen einer HashMap und Rechnung einfügen insofern es für die customerid noch keine gibt

            Service.getandroundfinalsum(customer_bill_by_id,customerid,bill);



        }



        var customerinfos = stmt.executeQuery("SELECT * FROM customers");



        while (customerinfos.next())
        {
            String firstname = customerinfos.getString("FirstName");
            String lastname = customerinfos.getString("LastName");
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

                Service.sortingbyletters(customerinfos.getString("LastName"),customers_sorted_by_lastname,c);

            Service.createkeyandfillvalues(country,customer_sorted_by_country,c);









        }


        System.out.println(customer_bill_by_id.get("38")+"%");

        //so kann man mehrere Attribute holen
        ArrayList<Customers> xyz = customer_sorted_by_country.get("Germany");
        System.out.println("\n" + xyz.get(1).getInfoShort());


        //so kann man auch mehrere Attribute holen
        Customers x = customer_sorted_by_country.get("Germany").get(2);
        System.out.println("\n" + x.getInfoShort());

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        Service.customersbycountry(customer_sorted_by_country,"France");

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        System.out.println(customers_sorted_by_lastname.keySet());
        for(int i = 0; i < customers_sorted_by_lastname.get("B").toArray().length;i++) {
            ArrayList<Customers> blllla = customers_sorted_by_lastname.get("B");
            blllla.get(i);
            System.out.println(blllla.get(i).getLastName());
        }
    }




    static HashMap<String, Double> customer_bill_by_id = new HashMap<>();


    //static HashMap<String, ArrayList<String>> customers_sorted_by_country = new HashMap<>();
    //funktioniert, ist aber Scheiße weil man keine einzelnen Attribute aufrufen kann da alle Attribute in ,und als, String gespeichert werden.


    //eher so mit kompletten Objekten als Value(bzw ArrayListen mit Objekten drin)
    static HashMap<String, ArrayList<Customers>> customer_sorted_by_country = new HashMap<>();
    static HashMap<String, ArrayList<Customers>> customers_sorted_by_lastname = new HashMap<>();



}



