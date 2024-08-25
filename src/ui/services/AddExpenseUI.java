package ui.services;

import models.Service;
import ui.helper.MessageDisplay;
import ui.ui_layer.UserInputHandler;
import user.staff.Staff;

import java.util.List;
import java.util.Scanner;
public class AddExpenseUI implements UserInputHandler {
    int roomNo;
    int serviceId;
    @Override
    public void collectInput(Scanner scanner){
        System.out.println(" Enter room number : ");
        roomNo = scanner.nextInt();
        Staff staff = new Staff();
        List<Service> services = staff.get_service();
        System.out.println("    Type of Services\n  ");
        for(int i=0;i<services.size();i++){
            System.out.println(services.get(i).getServiceId() + " " + services.get(i).getServiceName() + " " + services.get(i).getServicePrice() + "\n");
        }
//        System.out.println("    Type of Service\n  1.Meal   2.Spa");
//        Take input from user about which service they want and return its name to db;
        serviceId = scanner.nextInt();
        System.out.println("You selected service: " + serviceId);
        int add_expense_status = staff.add_customer_expense(roomNo,serviceId);
        if(add_expense_status==1){
            MessageDisplay.showMessage("Service added successfully!!");
        }else{
            MessageDisplay.showMessage("Service not added!!");
        }
    }
}
