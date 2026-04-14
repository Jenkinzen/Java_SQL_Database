package DataAccessAndConnection;

import Customers.Customers;
import Storage.Storage;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataAccess
{
    public static void getcustomerdata() throws SQLException {
        /// DATABASE-VARIABLES////////////////////////////////////////////////////////////////////////////

        String CHINOOK_DB = "jdbc:sqlite:C:\\Users\\ggord\\IdeaProjects\\neues_projekt\\chinook.db";
        String COMPARE_DB = "jdbc:sqlite:C:\\Users\\ggord\\IdeaProjects\\neues_projekt\\compare.db";


        /// CONNECTION////////////////////////////////////////////////////////////////////////////////////
        var conn_chinook = Connection.connection(CHINOOK_DB);
        var stmt_chinook = conn_chinook.createStatement();

        var conn_compare = Connection.connection(COMPARE_DB);
        var stmt_compare = conn_compare.createStatement();

        /// SQL DATASOURCE|PAYMENTINFOS///////////////////////////////////////////////////////////////////
        var paymentinfos = stmt_chinook.executeQuery("SELECT BillingAddress,CustomerId,Total FROM invoices");

        while (paymentinfos.next()) {
            String customerid = paymentinfos.getString("CustomerId");
            Double bill = paymentinfos.getDouble("Total");


            //Erstellen einer HashMap und Rechnungen einfügen insofern es für die customerid noch keine gibt

            Service.Service.getBills(Storage.customer_bill_by_id, customerid, bill);


        }


        /// SQL DATASOURCE| CUSTOMERINFOS//////////////////////////////////////////////////////////////////
        var customerinfos = stmt_chinook.executeQuery("SELECT * FROM customers");



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
            ArrayList<Double> bill = Storage.customer_bill_by_id.get(customerid);


            Customers c = new Customers(customerid, firstname, lastname, address, city, country, company, state, phone, postalcode, fax, email, supportrepid, bill);

            Storage.all_customers.add(c);


        }
        /// COMPARING SETUP TO FILL IN STATES FOR NULL/////////////////////////////////////////////////////
        stmt_compare.execute("DROP TABLE IF EXISTS customers_without_state"); // hab den table schon created,deshalb wurde nachträglich column postalcode nicht inserted, deshalb > table löschen , dann wird er neu MIT postalcode angelegt
        stmt_compare.execute
                ("CREATE TABLE IF NOT EXISTS customers_without_state(CustomerId TEXT,City TEXT,State TEXT,Country TEXT,PostalCode TEXT)");
        var insertstmt = conn_compare.prepareStatement("INSERT INTO customers_without_state(CustomerId,City,State,Country,PostalCode) VALUES (?,?,?,?,?)");
        var customerwithoutstateinfos = stmt_chinook.executeQuery("SELECT CustomerId,City,State,Country,PostalCode FROM customers ");

        stmt_compare.execute("DELETE FROM customers_without_state"); // löscht alte einträge bevor im loop hier drunter wieder neue aufgefüllt werden.
        while(customerwithoutstateinfos.next()){

            String customerid = customerwithoutstateinfos.getString("CustomerId");
            String city = customerwithoutstateinfos.getString("City");
            String state = customerwithoutstateinfos.getString("State");
            String country = customerwithoutstateinfos.getString("Country");
            String postalcode = customerwithoutstateinfos.getString("PostalCode");

            insertstmt.setString(1, customerid);
            insertstmt.setString(2, city);
            insertstmt.setString(3, state);
            insertstmt.setString(4, country);
            insertstmt.setString(5, postalcode);
            insertstmt.executeUpdate();
        }
        stmt_compare.execute("ALTER TABLE customers_without_state ADD COLUMN CountryShortCut");

        stmt_compare.execute("UPDATE customers_without_state SET CountryShortCut = allCountriesPostalCode.field1 " +
                                 "FROM allCountriesPostalCode WHERE customers_without_state.City = allCountriesPostalCode.field3 AND customers_without_state.PostalCode = allCountriesPostalCode.field2");

        stmt_compare.execute
                ("UPDATE customers_without_state SET State = allCountriesPostalCode.field4" +
                        " FROM allCountriesPostalCode" +
                        " WHERE customers_without_state.PostalCode = allCountriesPostalCode.field2 AND customers_without_state.City = allCountriesPostalCode.field3");



        var check = stmt_compare.executeQuery("SELECT * FROM customers_without_state");

        while (check.next()) {
            System.out.println(
                    check.getString("CustomerId") + " | " +
                            check.getString("City") + " | " +
                            check.getString("State") + " | " +
                            check.getString("Country") + " | " +
                            check.getString("PostalCode") + " | " +
                            check.getString("CountryShortCut")
            );

        }





        /// SQL DATASOURCE| ARTISTINFOS////////////////////////////////////////////////////////////////////
        var artistinfos = stmt_chinook.executeQuery("SELECT * FROM artists");

        while ( artistinfos.next()){
            String artistid = artistinfos.getString("ArtistId");
            String artist = artistinfos.getString("Name");
        }

        var albuminfos = stmt_chinook.executeQuery("SELECT * FROM albums");

        while ( albuminfos.next()){
            String albumid = albuminfos.getString("AlbumId");
            String albumtitle = albuminfos.getString("Title");
            String albumartistid = albuminfos.getString("ArtistId");
        }

        var trackinfos = stmt_chinook.executeQuery("SELECT * FROM tracks");

        while (trackinfos.next()){
            String trackid = trackinfos.getString("TrackId");
            String tracktitle = trackinfos.getString("Name");
            String trackalbumid = trackinfos.getString("AlbumId");
            String trackgenreid = trackinfos.getString("GenreId");
        }

        var genreinfos = stmt_chinook.executeQuery("SELECT * FROM genres");

        while (genreinfos.next()){
           String genreid = genreinfos.getString("GenreId");
           String genretitle = genreinfos.getString("Name");
        }

    }













    //Customer(Value) werden nach Anfangsbuchstabe des Nachnamens(Key) in customer_sorted_by_lastname_letter gepackt
//            Service.Service.sortedByStartingLetters(firstname, Storage.customers_sorted_by_firstname_letter, c);
//            Service.Service.sortedByStartingLetters(lastname, Storage.customers_sorted_by_lastname_letter, c);

//            //Mehrere Values werden einem Key zugewiesen
//            Service.Service.createKeyAndFillValuesMultiValue(address, Storage.customers_sorted_by_address, c);
//            Service.Service.createKeyAndFillValuesMultiValue(city, Storage.customers_sorted_by_city, c);
//            Service.Service.createKeyAndFillValuesMultiValue(country, Storage.customers_sorted_by_country, c);
//            Service.Service.createKeyAndFillValuesMultiValue(state, Storage.customers_sorted_by_state, c);
//            Service.Service.createKeyAndFillValuesMultiValue(company, Storage.customers_sorted_by_company, c);
//            Service.Service.createKeyAndFillValuesMultiValue(postalcode, Storage.customers_sorted_by_postalcode, c);
//            Service.Service.createKeyAndFillValuesMultiValue(supportrepid, Storage.customers_sorted_by_supportrepid, c);
//            Service.Service.createKeyAndFillValuesMultiValue(bill.toString(), Storage.customers_sorted_by_bill, c);
//
//            //Eine Value wird einem Key zugewiesen
//            Service.Service.createKeyAndFillValuesSingleValue(lastname, Storage.customers_sorted_by_lastname, c);
//            Service.Service.createKeyAndFillValuesSingleValue(firstname, Storage.customers_sorted_by_firstname, c);
//            Service.Service.createKeyAndFillValuesSingleValue(customerid, Storage.customers_sorted_by_id, c);
//            Service.Service.createKeyAndFillValuesSingleValue(email, Storage.customers_sorted_by_email, c);
//
//
//            //Übergeordnete HashMap (quasi Hauptmenü um sachen bezüglich Customer zu finden)
//            Storage.customersortedbycategories.put("customerid", Storage.customers_sorted_by_id);
//            Storage.customersortedbycategories.put("first_name", Storage.customers_sorted_by_firstname);
//            Storage.customersortedbycategories.put("last_name", Storage.customers_sorted_by_lastname);
//            Storage.customersortedbycategories.put("company", Storage.customers_sorted_by_company);
//            Storage.customersortedbycategories.put("address", Storage.customers_sorted_by_address);
//            Storage.customersortedbycategories.put("postalcode", Storage.customers_sorted_by_postalcode);
//            Storage.customersortedbycategories.put("city", Storage.customers_sorted_by_city);
//            Storage.customersortedbycategories.put("country", Storage.customers_sorted_by_country);
//            Storage.customersortedbycategories.put("state", Storage.customers_sorted_by_state);
//            Storage.customersortedbycategories.put("phone", Storage.customers_sorted_by_phone);
//            Storage.customersortedbycategories.put("fax", Storage.customers_sorted_by_fax);
//            Storage.customersortedbycategories.put("supportrepid", Storage.customers_sorted_by_supportrepid);
//            Storage.customersortedbycategories.put("bill", Storage.customers_sorted_by_bill);
//            Storage.customersortedbycategories.put("email", Storage.customers_sorted_by_email);


}


