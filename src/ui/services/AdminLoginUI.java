package ui.services;

import ui.ui_layer.LoginUser;
import ui.helper.PasswordMasker;
import user.admin.Admin;

import java.io.Console;
import java.util.Scanner;
public class AdminLoginUI implements LoginUser {
    private String username;
    private String password;
//
    @Override
    public void loginRequester() {
        System.out.println("==================================");
        System.out.println("         Admin Login");
        System.out.println("==================================");
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();
//        if (console == null) {
//            System.out.println("No console available");
//            System.exit(1);
//        }
        System.out.println("Username : ");
        username = scanner.nextLine();
//        password = PasswordMasker.readPassword(console, "Enter your password: ");

        //Call Admin login method;
        Admin admin = new Admin();
        int login = admin.login(username,password);
        System.out.println("Admin login status:" + login);
    }
}