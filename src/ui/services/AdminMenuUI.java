package ui.services;
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
        System.out.println("6. Logout");
    }
    @Override
    public int getChoice(Scanner scanner)
    {
        this.choice = scanner.nextInt();
        return this.choice;
    }

}