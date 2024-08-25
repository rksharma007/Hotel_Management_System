package ui.services;

import ui.helper.MessageDisplay;
import ui.ui_layer.UserInputHandler;
import user.admin.Admin;
import user.admin.Admin_Interface;

import java.util.Scanner;
public class BookRoomUI implements UserInputHandler {
    String checkIn;
    String checkOut;
    String address;
    String customerName;
    String contact;
    private int deluxeRoomCount;
    private int standardRoomCount;
    @Override
    public void collectInput(Scanner scanner){
        System.out.println("Enter CheckIn Date : ");
        checkIn = scanner.nextLine();
        System.out.println("Enter CheckOut Date : ");
        checkOut = scanner.nextLine();
        System.out.println("Enter Customer Address: ");
        address= scanner.nextLine();
        System.out.println("Enter Customer name: ");
        customerName = scanner.nextLine();
        System.out.println("Enter Customer contact no : ");
        contact = scanner.nextLine();
        System.out.println("Enter standard room count");
        standardRoomCount = scanner.nextInt();
        System.out.println("Enter deluxe room count");
        deluxeRoomCount = scanner.nextInt();

        // to be called Himanshu's code
        Admin_Interface admin = new Admin();
        int bookingStatus = admin.book_customer(checkIn,checkOut,address,customerName,contact,standardRoomCount,deluxeRoomCount);
        if(bookingStatus == 0){
            MessageDisplay.showMessage("Booking unsuccessful!!");
        }else MessageDisplay.showMessage("Booking successful!!");
        //if booked successfully
        //Display Booking successfull method
        //else
        //go to admin menu
    }
}
