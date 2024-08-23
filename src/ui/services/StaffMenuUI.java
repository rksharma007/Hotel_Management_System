package ui.services;

import ui.ui_layer.DisplayMenu;

import java.util.Scanner;
public class StaffMenuUI implements DisplayMenu{
    private int choice;
    @Override
    public void displayMenu(){
        System.out.println("Staff Menu");
        System.out.println("1. Add Expense");
        System.out.println("2. Logout");
    }
    @Override
    public int getChoice(Scanner scanner){
        this.choice = scanner.nextInt();
        return this.choice;
    }
}
