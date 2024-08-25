package ui.services;

import models.Room;
import ui.helper.MessageDisplay;
import ui.ui_layer.UserInputHandler;
import user.admin.Admin;
import user.admin.Admin_Interface;

import java.util.List;
import java.util.Scanner;
public class CheckInPageUI implements UserInputHandler {
    String aadhar;
    String contact;
    @Override
    public void collectInput(Scanner scanner){
        System.out.println("================================================");
        System.out.println("         Checkin - Fill required details");
        System.out.println("================================================\n");
        System.out.println("Enter Aadhar no. : ");
        aadhar = scanner.nextLine();
        System.out.println("Enter Contact no : ");
        contact = scanner.nextLine();

        // to be called Himanshu's code
        Admin_Interface admin = new Admin();
        int checkinStatus = admin.check_in_customer(aadhar,contact);
        if(checkinStatus!=0){
            MessageDisplay.showMessage("Checkin Successful");
        }else MessageDisplay.showMessage("Checkin failed.");
    }
}
