package ui.services;

import ui.ui_layer.DisplayMenu;
import java.util.Scanner;

public class StaffMenu implements DisplayMenu {
    private int choice;
    @Override
    public void displayMenu(){
        System.out.println(" 1. Add Expenses");
        System.out.println(" 2. Logout");

    }
    @Override
    public int getChoice(Scanner scanner){
        System.out.println("Enter your choice : ");
        this.choice = scanner.nextInt();
        if(choice!=1 && choice!=2){
            System.out.println("Enter a valid choice ");
            return getChoice(scanner);
        }
        return this.choice;
    }
}
