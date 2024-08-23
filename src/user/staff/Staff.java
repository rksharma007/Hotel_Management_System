package user.staff;

import database.routes.Staff_Route;
import models.Service;
import user.User_Interface;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Staff implements User_Interface, Staff_Interface {
    @JsonProperty("staff_id")
    private int staffId;

    @JsonProperty("staff_name")
    private String staffName;

    @JsonProperty("staff_username")
    private String staffUsername;

    @JsonProperty("staff_password")
    private String staffPassword;

    private Staff_Route staff_route;
    // Default constructor (required for deserialization)
    public Staff() {
        this.staff_route = new Staff_Route();
    }

    // Parameterized constructor (optional)
    public Staff(int staffId, String staffName, String staffUsername, String staffPassword) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffUsername = staffUsername;
        this.staffPassword = staffPassword;

        this.staff_route = new Staff_Route();
    }

    // Getters and setters
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
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
        List<Service> services = new ArrayList<>();// service_id, service_name
        return services;
    }

    @Override
    public int add_customer_expense(int room_no, int service_id) {
        return 0;
    }
}
