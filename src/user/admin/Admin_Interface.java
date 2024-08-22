package user.admin;

public interface Admin_Interface {
    int get_customer_details();
    int get_audit_details();
    int book_customer();
    int check_in_customer();
    int check_out_customer();
    int pay_expense();
    int register_staff(String name, String ph_no, String username, String password);
}