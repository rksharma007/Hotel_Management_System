package user.admin;

import user.User_Interface;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Admin implements User_Interface, Admin_Interface {

    @JsonProperty("admin_id")
    private int adminId;

    @JsonProperty("admin_name")
    private String adminName;

    @JsonProperty("admin_password")
    private String adminPassword;

    @JsonProperty("admin_contact")
    private String adminContact;

    @JsonProperty("admin_username")
    private String adminUsername;

    // Default constructor (required for deserialization)
    public Admin() {}

    // Parameterized constructor (optional)
    public Admin(int adminId, String adminName, String adminPassword, String adminContact, String adminUsername) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminContact = adminContact;
        this.adminUsername = adminUsername;
    }

    // Getters and setters
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminContact() {
        return adminContact;
    }

    public void setAdminContact(String adminContact) {
        this.adminContact = adminContact;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    @Override
    public String Hashing(String password){

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
        return 1;
    }

    @Override
    public int get_customer_details() {
        return 0;
    }

    @Override
    public int get_audit_details() {
        return 0;
    }
//------------
    @Override
    public int book_customer() {
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
