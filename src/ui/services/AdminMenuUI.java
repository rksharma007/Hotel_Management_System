package ui.services;
import ui.helper.MessageDisplay;
import ui.ui_layer.DisplayMenu;

import java.util.Scanner;

public class AdminMenuUI implements DisplayMenu{
    private int choice;
    @Override
    public void displayMenu(){
        System.out.println("Admin Menu");
        System.out.println("1. Book a Room");
        System.out.println("2. Check Availabilty");
        System.out.println("3. CheckIn Customer");
        System.out.println("4. CheckOut Customer");
        System.out.println("5. Register Staff");
        System.out.println("6. Cancel Booking");
        System.out.println("7. Search Booking");
        System.out.println("8. Audit Details");
        System.out.println("9. Logout");
    }
    @Override
    public int getChoice(Scanner scanner)
    {
        System.out.println("Enter your choice : ");
        this.choice = scanner.nextInt();
        if(this.choice>=1 && this.choice<=9) {
            return this.choice;
        }
        else{
            MessageDisplay.showMessage("Invalid choice. Try Again");
            return getChoice(scanner);
        }
    }

}