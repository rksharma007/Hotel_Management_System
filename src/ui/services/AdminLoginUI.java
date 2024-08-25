package ui.services;

import ui.ui_layer.LoginUser;
import ui.helper.PasswordMasker;
import user.User_Interface;
import user.admin.Admin;

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
        System.out.println("Enter your password: ");
        password = scanner.nextLine();

//        System.out.println("Working!");
        //Call Admin login method;
        User_Interface admin = new Admin();
        return admin.login(username,password);
    }

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("         Admin Login");
        System.out.println("==================================");
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();
        if (console == null) {
            System.out.println("No console available");
            System.exit(1);
        }
        System.out.println("Username : ");
        String username = scanner.nextLine();
        String password = PasswordMasker.readPassword(console, "Enter your password: ");

//        System.out.println("Working!");
//        Call Admin login method;
//        User_Interface admin = new Admin();
//        int login = admin.login(username,password);
//        System.out.println("Admin login status:" + login);
    }
}