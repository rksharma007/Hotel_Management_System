package ui.services;

import ui.ui_layer.RegisterUser;
import ui.helper.PasswordMasker;

import java.io.Console;
import java.util.Scanner;

public class RegisterStaffUI implements RegisterUser{
    private String name;
    private String contact;
    private String username;
    private String password;
    @Override
    public void register(){
        System.out.println("==================================");
        System.out.println("         Staff Register");
        System.out.println("==================================");

        Scanner scanner = new Scanner(System.in);
        Console console = System.console();

        if (console == null) {
            System.out.println("No console available");
            System.exit(1);
        }
        System.out.println("Name : ");
        name = scanner.nextLine();
        System.out.println("Contact : ");
        contact = scanner.nextLine();
        System.out.println("Username : ");
        username = scanner.nextLine();
        String password = PasswordMasker.readPassword(console, "Enter your password: ");
        //System.out.println("\nPassword entered: " + password);
    }

}
