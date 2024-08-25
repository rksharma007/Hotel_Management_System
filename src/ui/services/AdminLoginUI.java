package ui.services;

import ui.ui_layer.LoginUser;
import ui.helper.PasswordMasker;
import user.User_Interface;
import user.admin.Admin;

import javax.swing.*;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
public class AdminLoginUI implements LoginUser {
    private String username;
    private String password;
//
//    @Override

    public int loginRequester() {
        System.out.println("==================================");
        System.out.println("         Admin Login");
        System.out.println("==================================");
        Scanner scanner = new Scanner(System.in);
//        Console console = System.console();
//        if (console == null) {
//            System.out.println("No console available");
//            System.exit(1);
//        }
        System.out.println("Username : ");
        username = scanner.nextLine();
//        System.out.println("Enter your password: ");
//        password = scanner.nextLine();

        JPasswordField passwordField = new JPasswordField();

        // Prompt the user to enter a password
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Password :", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Check if the user pressed "OK"
        if (option == JOptionPane.OK_OPTION) {
            // Get the password from the JPasswordField
            char[] enteredPasswordArray = passwordField.getPassword();
            password = new String(enteredPasswordArray);

            User_Interface admin = new Admin();
            if (admin.login(username,password) == 1) {
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

//        System.out.println("Working!");
        //Call Admin login method;
//        return admin.login(username,password);
    }
}