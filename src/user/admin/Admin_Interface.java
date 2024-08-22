package user.admin;

import models.Room;

public interface Admin_Interface {
    int get_customer_details();
    int get_audit_details();

    //------------
    int book_customer(String check_in, String check_out, String booking_date, String address, String cust_name, String contact, Room r1, Room r2);

    int check_in_customer();
    int check_out_customer();
    int pay_expense();
    int register_staff(String name, String ph_no, String username, String password);

    int check_availability(String checkin, String checkout);
}