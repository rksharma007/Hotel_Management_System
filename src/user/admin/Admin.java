package user.admin;

import database.routes.Admin_Route;
import models.Customer;
import models.Room;
import user.User_Interface;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Admin implements User_Interface, Admin_Interface {

    private Admin_Route admin_route;
    public Admin(){
        admin_route = new Admin_Route();
    }

    @Override
    public String hashing(String password){

        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Apply the hash function
            byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Convert the byte array into a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // Print the hashed password in hexadecimal format
//            System.out.println("Original password: " + password);
//            System.out.println("Hashed password: " + hexString.toString());
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // Handle error if SHA-256 algorithm is not available
        }
        return "";
    }

    public int login(String username, String password){
        if(username.isEmpty() || password.isEmpty())return 0;
//        password encryption
        String hashedPassword = hashing(password);
//        Check if username and password exist
        return admin_route.is_exist(username,hashedPassword);
    }

    @Override
    public int get_customer_details() {
//        Retrieves all available customers from the table.
        List<Customer> customers = admin_route.get_customers();
        return 1;
    }

    @Override
    public int get_audit_details() {
        return 0;
    }


    @Override
    public int check_availability(String checkin, String checkout){
        if(checkin.isEmpty() && checkout.isEmpty()){
            admin_route.check_availability(checkin,checkout);
            return 1;
        }
        return 0;
    }
//------------
    @Override
    public int book_customer(String check_in, String check_out, String booking_date, String address, String cust_name, String contact, Room r1, Room r2) {

        return 0;
    }

    @Override
    public int check_in_customer() {
        return 0;
    }

    @Override
    public int check_out_customer() {
        return 0;
    }

    @Override
    public int pay_expense() {
        return 0;
    }
    @Override
    public int register_staff(String name, String ph_no, String username, String password){
//        password get encrypted
//        retrieve data from the staff table
//        Check if a person with username exists
        return 0; // user already exists
//        If not exists, add new user in the staff table
//        return 1; // user added to the db.
    }
}
