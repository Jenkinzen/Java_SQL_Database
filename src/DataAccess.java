import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DataAccess
{
    public static void getcustomerdata() throws SQLException {
        Connection.connection();

        ///CONNECTION/////////////////////////////////////////////////////////////////////////////////////
        var stmt = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ggord\\IdeaProjects\\neues_projekt\\chinook.db").createStatement();


        ///SQL DATASOURCE|PAYMENTINFOS////////////////////////////////////////////////////////////////////
        var paymentinfos = stmt.executeQuery("SELECT BillingAddress,CustomerId,Total FROM invoices");

        while (paymentinfos.next()) {
            String customerid = paymentinfos.getString("CustomerId");
            Double bill = paymentinfos.getDouble("Total");


            //Erstellen einer HashMap und Rechnung einfügen insofern es für die customerid noch keine gibt

            Service.getandroundfinalsum(Storage.customer_bill_by_id, customerid, bill);


        }

        /// SQL DATASOURCE|CUSTOMERINFOS///////////////////////////////////////////////////////////////////
        var customerinfos = stmt.executeQuery("SELECT * FROM customers");


        while (customerinfos.next()) {

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
            Double bill = Storage.customer_bill_by_id.get(customerinfos.getString("CustomerId"));


            Customers c = new Customers(customerid, firstname, lastname, address, city, country, company, state, phone, postalcode, fax, email, supportrepid, bill);


            //Customer(Value) werden nach Anfangsbuchstabe des Nachnamens(Key) in customer_sorted_by_lastname_letter gepackt
            Service.sortedbystartingletters(firstname, Storage.customers_sorted_by_firstname_letter, c);
            Service.sortedbystartingletters(lastname, Storage.customers_sorted_by_lastname_letter, c);


            //Mehrere Values werden einem Key zugewiesen
            Service.createkeyandfillvaluesMultiValue(address, Storage.customers_sorted_by_address, c);
            Service.createkeyandfillvaluesMultiValue(city, Storage.customers_sorted_by_city, c);
            Service.createkeyandfillvaluesMultiValue(country, Storage.customers_sorted_by_country, c);
            Service.createkeyandfillvaluesMultiValue(state, Storage.customers_sorted_by_state, c);
            Service.createkeyandfillvaluesMultiValue(company, Storage.customers_sorted_by_company, c);
            Service.createkeyandfillvaluesMultiValue(postalcode, Storage.customers_sorted_by_postalcode, c);
            Service.createkeyandfillvaluesMultiValue(supportrepid, Storage.customers_sorted_by_supportrepid, c);

            //Eine Value wird einem Key zugewiesen
            Service.createkeyandfillvaluesSingleValue(lastname, Storage.customers_sorted_by_lastname, c);
            Service.createkeyandfillvaluesSingleValue(firstname, Storage.customers_sorted_by_firstname, c);
            Service.createkeyandfillvaluesSingleValue(customerid, Storage.customers_sorted_by_id, c);
            Service.createkeyandfillvaluesSingleValue(email, Storage.customers_sorted_by_email, c);


            //Übergeordnete HashMap (quasi Hauptmenü um sachen bezüglich Customer zu finden)
            Storage.customersortedbycategories.put("customerid", Storage.customers_sorted_by_id);
            Storage.customersortedbycategories.put("first_name_letter", Storage.customers_sorted_by_firstname_letter);
            Storage.customersortedbycategories.put("last_name_letter", Storage.customers_sorted_by_lastname_letter);
            Storage.customersortedbycategories.put("first_name", Storage.customers_sorted_by_firstname);
            Storage.customersortedbycategories.put("last_name", Storage.customers_sorted_by_lastname);
            Storage.customersortedbycategories.put("company", Storage.customers_sorted_by_company);
            Storage.customersortedbycategories.put("address", Storage.customers_sorted_by_address);
            Storage.customersortedbycategories.put("postalcode", Storage.customers_sorted_by_postalcode);
            Storage.customersortedbycategories.put("city", Storage.customers_sorted_by_city);
            Storage.customersortedbycategories.put("country", Storage.customers_sorted_by_country);
            Storage.customersortedbycategories.put("state", Storage.customers_sorted_by_state);
            Storage.customersortedbycategories.put("phone", Storage.customers_sorted_by_phone);
            Storage.customersortedbycategories.put("fax", Storage.customers_sorted_by_fax);
            Storage.customersortedbycategories.put("supportrepid", Storage.customers_sorted_by_supportrepid);
            Storage.customersortedbycategories.put("bill", Storage.customers_sorted_by_bill);


        }
    }






}


