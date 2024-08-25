package ui.services;
import models.Response;
import ui.ui_layer.UserInputHandler;
import ui.helper.MessageDisplay;
import user.admin.Admin;
import user.admin.Admin_Interface;

import java.util.Scanner;
public class CheckoutPageUI implements UserInputHandler {
    public String contact;
    private String pendingExpenseStatus;
    @Override
    public void collectInput(Scanner scanner){
        System.out.println("================================================");
        System.out.println("         Checkout - Fill required details");
        System.out.println("================================================");
        System.out.println("Enter Contact : ");

        contact = scanner.nextLine();

        // Do checkout
        //1 or 0
        //if checkedout show message
        //Get list of expenses by himansu's code
        //else go to admin menu page

//        contact input -> get_room_details and its corressponding expenses.
        Admin_Interface admin = new Admin();
        Response checkout_response = admin.check_out_customer(contact);
        pendingExpenseStatus = checkout_response.getStatus();

        if(pendingExpenseStatus.equals("failed")){
            //Print each room no with their expense
            MessageDisplay.showMessage(checkout_response.getMessage());
            MessageDisplay.showMessage("\nWant to clear expense?\n1 .Yes    2 .No\nEnter a choice");
            int choice = scanner.nextInt();
            if(choice==1){
                MessageDisplay.showMessage("Enter Room Number: ");
                int room_input = scanner.nextInt();
                int pay_expense_status = admin.pay_expenses(room_input);
                if(pay_expense_status==1){
                    MessageDisplay.showMessage("Expenses cleared. Checked Out successfully");
                    pendingExpenseStatus="success"; //Expense cleared
                }else{
                    MessageDisplay.showMessage("Expense not cleared. Can't checkout");
                }
            }
            else if(choice==2){
                MessageDisplay.showMessage("Expense not cleared. Can't checkout");
            }
        }
        else{
            MessageDisplay.showMessage("No Expenses found.\nCheckout Successfull");
        }
    }
}