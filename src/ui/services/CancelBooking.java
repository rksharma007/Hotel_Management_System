package ui.services;

import ui.helper.MessageDisplay;
import ui.ui_layer.UserInputHandler;
import user.admin.Admin;
import user.admin.Admin_Interface;

import java.util.Scanner;

public class CancelBooking implements UserInputHandler {
    String contact;
    @Override
    public void collectInput(Scanner scanner){
        System.out.println("==========================================");
        System.out.println("            Cancel Booking");
        System.out.println("==========================================\n");
        System.out.println("Enter Contact : ");
        contact = scanner.nextLine();

        Admin_Interface admin = new Admin();
        int bookingStatus = admin.cancel_booking(contact);
        if(bookingStatus==1){
            MessageDisplay.showMessage("Booking Cancelled Successfully!!");
        }else MessageDisplay.showMessage("Unable to cancel Booking!! Please try again!!!");
    }
}