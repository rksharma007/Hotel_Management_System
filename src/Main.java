import ui.services.AdminLoginUI;
import ui.ui_layer.LoginUser;

import ui.ui_layer.*;
import ui.services.*;
import ui.helper.MessageDisplay;

import java.util.Scanner;

public class Main{
    static int choice;
    public static void main(String... args) {
        Scanner scanner = null;

        while (true) {

            System.out.println("==========================================");
            System.out.println("               Main Menu ");
            System.out.println("==========================================\n");

            System.out.println("1. Admin Login");
            System.out.println("2. Staff Login");
            System.out.println("3. Exit\n");

            System.out.println("Enter a choice : ");
            scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    LoginUser adminLogin = new AdminLoginUI();
                    int adminLoginStatus = adminLogin.loginRequester();
                    if(adminLoginStatus==1){
                        MessageDisplay.showMessage("Admin Login Successfull.....\n");
                    }else if(adminLoginStatus == -1){
                        MessageDisplay.showMessage("Error occured while logging in");
                    }
                    while(adminLoginStatus==1){
                        DisplayMenu adminMenu = new AdminMenuUI();
                        adminMenu.displayMenu();
                        scanner = new Scanner(System.in);
                        int menuChoice = adminMenu.getChoice(scanner);
                        if(menuChoice==1){
                            UserInputHandler InputCollector = new BookRoomUI();
                            scanner = new Scanner(System.in);
                            InputCollector.collectInput(scanner);
                        }
                        else if(menuChoice==2){
                            UserInputHandler InputCollector = new CheckAvailabilityInputUI();
                            scanner = new Scanner(System.in);
                            InputCollector.collectInput(scanner);
                        }
                        else if(menuChoice==3){
                            UserInputHandler InputCollector = new CheckInPageUI();
                            scanner = new Scanner(System.in);
                            InputCollector.collectInput(scanner);
                        }
                        else if(menuChoice==4){
                            UserInputHandler InputCollector = new CheckoutPageUI();
                            scanner = new Scanner(System.in);
                            InputCollector.collectInput(scanner);
                        }
                        else if(menuChoice==5){
                            RegisterUser staffRegister = new RegisterStaffUI();
                            staffRegister.register();
                        }
                        else if(menuChoice==6){
                            UserInputHandler cancelBooking = new CancelBooking();
                            scanner = new Scanner(System.in);
                            cancelBooking.collectInput(scanner);
                        }
                        else if(menuChoice==7){
                            UserInputHandler searchBooking = new SearchBooking();
                            scanner = new Scanner(System.in);
                            searchBooking.collectInput(scanner);
                        }
                        else if(menuChoice==8){
                            AuditDetails audits = new AuditDetails();
                            audits.getAudit();
                        }
                        else if(menuChoice==9){
                            MessageDisplay.showMessage("Logout Successfull");
                            adminLoginStatus=0;
                        }
                    }
                    break;
                case 2:
                    LoginUser staffLogin = new StaffLoginUI();
                    int staffloginStatus = staffLogin.loginRequester();
                    if(staffloginStatus==1){
                        MessageDisplay.showMessage("Staff Logged In Successfull.....!");
                    }
                    while(staffloginStatus==1){
                        DisplayMenu staffMenu = new StaffMenuUI();
                        staffMenu.displayMenu();
                        int staffChoice = staffMenu.getChoice(scanner);
                        if(staffChoice==1){
                            UserInputHandler inputCollector = new AddExpenseUI();
                            scanner = new Scanner(System.in);
                            inputCollector.collectInput(scanner);

                        }
                        else if(staffChoice==2){
                            staffloginStatus=0;
                        }
                        else{
                            MessageDisplay.showMessage("Invalid choice");
                            staffloginStatus=0;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the RKSHVA Hotel. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please Enter a valid choice :");

            }
        }
    }
}