package ui.services;

import ui.ui_layer.UserInputHandler;
import java.util.Scanner;
public class BookRoomUI implements UserInputHandler {
    String checkIn;
    String checkOut;
    String bookingDate;
    String address;
    String customerName;
    String contact;
    @Override
    public void collectInput(Scanner scanner){
        System.out.println("Enter CheckIn Date : ");
        checkIn = scanner.nextLine();
        System.out.println("Enter CheckOut Date : ");
        checkOut = scanner.nextLine();
        System.out.println("Enter Booking Date : ");
        bookingDate = scanner.nextLine();
        System.out.println("Enter Customer name: ");
        customerName = scanner.nextLine();
        System.out.println("Enter Customer Address: ");
        address= scanner.nextLine();
        System.out.println("Enter Customer contact no : ");
        contact = scanner.nextLine();


        // to be called Himanshu's code

        //if booked successfully
        //Display Booking successfull method

        //else
        //go to admin menu
    }
}
