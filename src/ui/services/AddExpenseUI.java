package ui.services;

import models.Service;
import ui.ui_layer.UserInputHandler;
import user.staff.Staff;

import java.util.List;
import java.util.Scanner;
public class AddExpenseUI implements UserInputHandler {
    int roomNo;
    int typeOfMeal;
    @Override
    public void collectInput(Scanner scanner){
        System.out.println(" Enter room number : ");
        roomNo = scanner.nextInt();
        Staff staff = new Staff();
        List<Service> services = staff.get_service();
        System.out.println("    Type of Service\n  ");
        for(int i=0;i<services.size();i++){
            System.out.println(i + " " + services.get(i).getServiceName() + " " + services.get(i).getServicePrice() + "\n");
        }
//        System.out.println("    Type of Service\n  1.Meal   2.Spa");
//        Take input from user about which service they want and return its name to db;
        typeOfMeal = scanner.nextInt();
        if(typeOfMeal!=1 && typeOfMeal!=2) {
            System.out.println("Please choose a valid point");
        }

    }
}
