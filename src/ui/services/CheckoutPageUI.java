package ui.services;
import ui.ui_layer.UserInputHandler;

import java.util.Scanner;
public class CheckoutPageUI implements UserInputHandler {
    int roomNo;
    @Override
    public void collectInput(Scanner scanner){
        System.out.println("================================================");
        System.out.println("         Checkout - Fill required details");
        System.out.println("================================================");
        System.out.println("       Enter room number : ");

        roomNo = scanner.nextInt();

        // Do checkout

        //if checkedout show message
        //else go to admin menu page
    }
}
