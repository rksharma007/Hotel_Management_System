package user.staff;

import database.routes.Staff_Route;
import models.Service;
import user.User_Interface;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Staff implements User_Interface, Staff_Interface {

    private Staff_Route staff_route;
    public Staff(){
        staff_route = new Staff_Route();
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

    @Override
    public int login(String username, String password) {
        if(username.isEmpty() || password.isEmpty())return 0;
//        password encryption
        String hashedPassword = hashing(password);
//        Check if username and password exist
        return staff_route.login(username,hashedPassword);
    }

    @Override
    public List<Service> get_service() {
        return staff_route.get_services();
    }

    @Override
    public int add_customer_expense(int room_no, int service_id) {
        return staff_route.add_expense(room_no,service_id);
    }
}
