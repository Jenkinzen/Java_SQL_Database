import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Customer {

    static public class Customers {
        static String id;
        static String firstname;
        static String lastname;
        static String company;
        static String address;
        static String city;
        static String state;
        static String postalcode;
        static String phone;
        static String fax;
        static String email;
        static String supportrepid;
        static String country;
        static Double bill;


        Customers(String id,
                  String firstname,
                  String lastname,
                  String company,
                  String address,
                  String city,
                  String state,
                  String country,
                  String postalcode,
                  String phone,
                  String fax,
                  String email,
                  String supportrepid,
                  Double bill
        ) {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.company = company;
            this.address = address;
            this.city = city;
            this.state = state;
            this.country = country;
            this.postalcode = postalcode;
            this.phone = phone;
            this.fax = fax;
            this.email = email;
            this.supportrepid = supportrepid;
            this.bill = bill;


        }






        static public String getId(){
            return id;
        }
        static public String getFirstName() {
            return firstname;
        }

        static public String getLastName() {
            return lastname;
        }

        static public String getCompany() {
            return company;
        }

        static public String getAddress() {
            return address;
        }

        static public String getCity() {
            return city;
        }

        static public String getState() {
            return lastname;
        }

        static public String getCountry() {
            return country;
        }

        static public String getPostalcode() {
            return postalcode;
        }

        static public String getPhone() {
            return phone;
        }

        static public String getFax() {
            return fax;
        }

        static public String getEmail() {
            return email;
        }

        static public String getSupportrepid() {
            return supportrepid;
        }

        static public Double getBill() {
            return bill;
        }




    }

}



