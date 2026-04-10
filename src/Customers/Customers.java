package Customers;

import java.util.ArrayList;


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
        ArrayList<Double> bills;


        public Customers(String id,
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
                         ArrayList<Double> bills
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
            this.bills = bills;


        }





    public ArrayList<String> getInfoDynamical(int input) {
            ArrayList<String> output = new ArrayList<>();


                if (input == 1) {
                    output.add(getId());
                }

                if (input == 2) {
                    output.add(getFirstName());
                }

                if (input == 3) {
                    output.add(getLastName());
                }

                if (input == 4) {
                    output.add(getAddress());
                }

                if (input == 5) {
                    output.add(getCity());
                }

                if (input == 6) {
                    output.add(String.valueOf(getState()));
                }

                if (input == 7) {
                    output.add(getCountry());
                }

                if (input == 8) {
                    output.add(getPostalcode());
                }

                if (input == 9) {
                    output.add(getPhone());
                }

                if (input == 10) {
                    output.add(getFax());
                }

                if (input == 11) {
                    output.add(getEmail());
                }

                if (input == 12) {
                    output.add(getSupportrepid());
                }

                if (input == 13) {
                    output.add(BillAsString());
                }


        return output;
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
            return state;
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

        public ArrayList<Double> getBills() { return bills;}

        public String BillAsString(){
            String stringbill = String.valueOf(getBills());
            return stringbill;
        }


    }





