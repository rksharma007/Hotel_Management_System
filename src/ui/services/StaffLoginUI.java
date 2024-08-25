package ui.services;

import ui.ui_layer.LoginUser;
import ui.helper.PasswordMasker;
import user.User_Interface;
import user.admin.Admin;
import user.staff.Staff;

import javax.swing.*;
import java.io.Console;
import java.util.Scanner;

public class StaffLoginUI implements LoginUser {
    private String username;
    private String password;
    @Override
    public int loginRequester(){
        System.out.println("==================================");
        System.out.println("         Staff Login");
        System.out.println("==================================");
        Scanner scanner = new Scanner(System.in);
//        Console console = System.console();
//        if (console == null) {
//            System.out.println("No console available");
//            System.exit(1);
//        }
        System.out.println("Username : ");
        username = scanner.nextLine();
//        System.out.println("Password : ");
//        password = scanner.nextLine();
//        String password = PasswordMasker.readPassword(console, "Enter your password: ");
        JPasswordField passwordField = new JPasswordField();

        // Prompt the user to enter a password
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Check if the user pressed "OK"
        if (option == JOptionPane.OK_OPTION) {
            // Get the password from the JPasswordField
            char[] enteredPasswordArray = passwordField.getPassword();
            password = new String(enteredPasswordArray);


            User_Interface staff = new Staff();
            if (staff.login(username,password) == 1) {
//                JOptionPane.showMessageDialog(null, "Password is correct. Access granted.");
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Password is incorrect. Access denied.");
                return 0;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operation canceled.");
            return 0;
        }

        //Call Staff login method;
//        return staff.login(username,password);
    }
}