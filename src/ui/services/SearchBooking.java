package ui.services;

import models.Room;
import ui.helper.MessageDisplay;
import ui.ui_layer.UserInputHandler;
import user.admin.Admin;
import user.admin.Admin_Interface;

import java.util.List;
import java.util.Scanner;

public class SearchBooking implements UserInputHandler {
    String contact;
    @Override
    public void collectInput(Scanner scanner){
        System.out.println("==========================================");
        System.out.println("            Search Booking");
        System.out.println("==========================================\n");
        System.out.println("Enter Contact : ");
        contact = scanner.nextLine();

        Admin_Interface admin = new Admin();
        List<Room> rooms = admin.get_room_details(contact);
        if(rooms==null){
            MessageDisplay.showMessage("No booking exist with this contact!!");
        }
        MessageDisplay.showMessage("Room No   Room Type   Price");
        for (Room room: rooms){
            MessageDisplay.showMessage(room.getRoomNumber() + "   " + room.getRoomType() + "   " + room.getPrice());
        }
    }
}