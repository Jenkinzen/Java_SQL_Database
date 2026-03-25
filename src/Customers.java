import java.util.ArrayList;
import java.util.HashMap;


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

    public ArrayList<String> getInfoDynamical(String input, ArrayList<Customers> list) {
            ArrayList<String> output = new ArrayList<>();

            for(int i = 0; i < list.size();i++) {
                if (input.contains("1")) {
                    output.add(getId());
                }

                if (input.contains("2")) {
                    output.add(getFirstName());
                }

                if (input.contains("3")) {
                    output.add(getLastName());
                }

                if (input.contains("4")) {
                    output.add(getAddress());
                }

                if (input.contains("5")) {
                    output.add(getCity());
                }

                if (input.contains("6")) {
                    output.add(getState());
                }

                if (input.contains("7")) {
                    output.add(getCountry());
                }

                if (input.contains("8")) {
                    output.add(getPostalcode());
                }

                if (input.contains("9")) {
                    output.add(getPhone());
                }

                if (input.contains("10")) {
                    output.add(getFax());
                }

                if (input.contains("11")) {
                    output.add(getEmail());
                }

                if (input.contains("12")) {
                    output.add(getSupportrepid());
                }

                if (input.contains("13")) {
                    output.add(BillAsString());
                }

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





