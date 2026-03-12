import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


    public class Customers {
         String id;
         String firstname;
         String lastname;
         String company;
         String address;
         String city;
         String state;
         String postalcode;
         String phone;
         String fax;
         String email;
         String supportrepid;
         String country;
         Double bill;


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



         public String getInfoShort(){
            return "\n\nID: " + id +
                   "\nFirst Name: " + firstname +
                   "\nLast Name: " + lastname +
                    "\nAddress: " + address +
                   "\nCity: " + city +
                   "\nCountry: " + country;


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

        public Double getBill() {
            return bill;
        }




    }





