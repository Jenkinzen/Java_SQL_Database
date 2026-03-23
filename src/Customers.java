import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


public class Customers {
         String id;
         String firstname;
         String lastname;
         String address;
        String city;
        String country;
        String company;
        String state;
        String phone;
        String postalcode;
        String fax;
        String email;
        String supportrepid;
         Double bill;


        Customers(String id,
                  String firstname,
                  String lastname,
                  String address,
                  String city,
                  String country,
                  String company,
                  String state,
                  String phone,
                  String postalcode,
                  String fax,
                  String email,
                  String supportrepid,
                  Double bill
        ) {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.address = address;
            this.city = city;
            this.country = country;
            this.company = company;
            this.state = state;
            this.phone = phone;
            this.postalcode = postalcode;
            this.fax = fax;
            this.email = email;
            this.supportrepid = supportrepid;
            this.bill = bill;


        }



         public String getInfoShort(){
            return "\n\nID: " + id +
                   "\nFirst Name: " + firstname +
                   "\nLast Name: " + lastname +
                    "\nAddress: " + address +
                   "\nCity: " + city +
                   "\nCountry: " + country+
                    "\nBill: " + bill+ "$\n";


        }

        public String getInfoAll(){
            return "\n\nID: " + id +
                    "\nFirst Name: " + firstname +
                    "\nLast Name: " + lastname +
                    "\nCompany: " + company +
                    "\nAddress: " + address +
                    "\nCity: " + city +
                    "\nState: " + state +
                    "\nCountry: " + country +
                    "\nPostal Code: " + postalcode +
                    "\nPhone: " + phone +
                    "\nFax: " + fax +
                    "\nEmail: " + email +
                    "\nSupport Rep ID: " + supportrepid +
                    "\nBill: " + bill + "$\n";

        }


        public String getId(){
            return id;
        }

        public String getFirstName() {
            return firstname;
        }

        public String getLastName() {
            return lastname;
        }

        public String getCompany() {
            return company;
        }

        public String getAddress() {
            return address;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return lastname;
        }

        public String getCountry() {
            return country;
        }

        public String getPostalcode() {
            return postalcode;
        }

        public String getPhone() {
            return phone;
        }

        public String getFax() {
            return fax;
        }

        public String getEmail() {
            return email;
        }

        public String getSupportrepid() {
            return supportrepid;
        }

        public double getBill() {

            return Math.round(bill*100) / 100;

        }

        public String BillAsString(){
            String stringbill = String.valueOf(getBill());
            return stringbill;
        }


    }





