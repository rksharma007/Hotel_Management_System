package ui.services;

import models.Room;
import ui.helper.MessageDisplay;
import ui.ui_layer.UserInputHandler;
import user.admin.Admin;
import user.admin.Admin_Interface;

import java.util.List;
import java.util.Scanner;
public class CheckAvailabilityInputUI implements UserInputHandler {
    String checkIn;
    String checkOut;
    @Override
    public  void collectInput(Scanner scanner){
        System.out.println("================================================");
        System.out.println("    Check Availabilty - Fill required details");
        System.out.println("================================================\n");
        System.out.println("Enter check in date : ");
        checkIn = scanner.nextLine();
        System.out.println("Enter check out date : ");
        checkOut = scanner.nextLine();

        // get Available Rooms detail from Himanshu's code
        Admin_Interface admin = new Admin();
        List<Room> rooms_avaialable = admin.check_availability(checkIn,checkOut);

        MessageDisplay.showMessage("Available rooms\n");
        for(Room room: rooms_avaialable){
            System.out.println(room.getRoomNumber()+" "+room.getRoomType()+" "+room.getPrice()+"\n");
        }
//        System.out.println(rooms_avaialable);

//        RoomDetailsUI roomDetails = new RoomDetailsUI();
//        roomDetails.renderResults();
    }
}
