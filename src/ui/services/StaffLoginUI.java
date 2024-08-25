package ui.services;

import ui.ui_layer.LoginUser;
import ui.helper.PasswordMasker;
import user.User_Interface;
import user.admin.Admin;
import user.staff.Staff;

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
        System.out.println("Password : ");
        password = scanner.nextLine();
//        String password = PasswordMasker.readPassword(console, "Enter your password: ");

        //Call Staff login method;
        User_Interface staff = new Staff();
        return staff.login(username,password);
    }
}
