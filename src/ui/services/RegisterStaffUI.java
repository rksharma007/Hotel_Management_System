package ui.services;

import ui.helper.MessageDisplay;
import ui.ui_layer.RegisterUser;
import ui.helper.PasswordMasker;
import user.admin.Admin;
import user.admin.Admin_Interface;

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
        System.out.println("Name : ");
        name = scanner.nextLine();
        System.out.println("Contact : ");
        contact = scanner.nextLine();
        System.out.println("Username : ");
        username = scanner.nextLine();
        System.out.println("Password: ");
        password = scanner.nextLine();
        //System.out.println("\nPassword entered: " + password);
        Admin_Interface admin = new Admin();
        int registration_status = admin.register_staff(name,contact,username,password);
        if(registration_status==1){
            MessageDisplay.showMessage("Registration Successful");
        }else{
            MessageDisplay.showMessage("Staff not registered");
        }
    }

}
