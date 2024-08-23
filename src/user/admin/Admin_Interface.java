package user.admin;

import models.Customer;
import models.Room;

import java.util.List;

public interface Admin_Interface {
    List<Customer> get_customer_details();
    List<Customer> get_audit_details();
    int book_customer(String check_in, String check_out, String address, String cust_name, String contact, int cnt1, int cnt2);

    List<Room> check_in_customer(String adhaar_no, String contact);
    int check_out_customer(String contact);

    int pay_expenses(int room_no);

    int register_staff(String name, String ph_no, String username, String password);

    List<Room> check_availability(String checkin, String checkout);

    List<Room> get_room_details(String contact);
    int cancel_booking(String contact);
}